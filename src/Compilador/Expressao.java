package Compilador;


import java.io.Serializable;
import java.util.LinkedList;



public class Expressao implements Serializable {

      private LinkedList<Item> listaExp;

      public Expressao() {

            this.listaExp = new LinkedList<Item>();

      }

      public void inclui(Item item) {

    	  this.listaExp.add(item);
      }

      public LinkedList<Item> getLista() {
    	  
    	  return this.listaExp;   	  
    	  
      }
      
      /* Dica de implementa��o: todas as vezes que encontrar um 
	  operador, antes de inser�-lo na lista, pergunte se os dois �ltimos elementos da lista s�o num�ricos, 
	  se sim, ent�o retire estes dois elementos, execute a opera��o e insira o resultado na lista. Se n�o, 
      coloque normalmente o operador na lista.  
          Operacao pode ser +, -, *, /, ^*/
      public boolean otimizaExpressao(char operacao){
    	  Item item;
    	  double res, a, b;
    	  // listaExp.getLast().getTipo() -> ultimo elemento da lista
    	  // listaExp.get(listaExp.size() - 2).getTipo() -> penultimo elemento da lista
    	  if(listaExp.getLast().getTipo() == 'n' && listaExp.get(listaExp.size() - 2).getTipo() == 'n'){
    		  b=Double.parseDouble(listaExp.removeLast().getValor());
    		  a=Double.parseDouble(listaExp.removeLast().getValor());
    		  if(operacao == '+')
    			  res=a+b;
    		  else if(operacao == '-')
    				 res=a-b;
    		  else if(operacao == '*')
    				  res=a*b;
    		  else if(operacao == '/')
    				  res=a/b;
    		  else
    			  res = Math.pow(a, b);
    		  item = new Item('n', String.valueOf(res));
    		  this.inclui(item);
    		  return true;
    	  }
    	  
    	  if(this.elementoNeutroPos(operacao))
    		  return true;
    	  
    	  if(this.elementoNeutroPre(operacao))
    		  return true;
    	  
    	  return false;
      }
      
      //Otimiza situa��es onde se tem elemento neutro
     //Para situa��es onde se tem  x + 0, x - 0, x * 1, x / 1, x^1, x*0, x^0.
      private boolean elementoNeutroPos(char op){
    	  char penultimoListaTipo = listaExp.get(listaExp.size() - 2).getTipo();
    	  char ultimoListaTipo = listaExp.getLast().getTipo();
    	  double ultimoListaValor;

    	  if( (penultimoListaTipo == 'v') && (ultimoListaTipo == 'n')){  

    		  ultimoListaValor = Double.parseDouble(listaExp.getLast().getValor());

    		  if((ultimoListaValor == 0) || (ultimoListaValor == 1)){

    			  if(op == '+' || op == '-'){
    				  if(ultimoListaValor == 0){//x+0, x-0
    					  listaExp.removeLast();
    					  return true;
    				  }
    			  }  
    			  else if(op == '*'){	  	  
    				  if(ultimoListaValor == 0){//x*0
    					  removePenultimoLista();
    					  return true;
    				  }
    				  else{//x*1
    					  listaExp.removeLast();
    					  return true;
    				  }
    			  }else if(op == '/'){
    				  if(ultimoListaValor == 0){// x/0 Teremos que criar uma excessao 
    					  System.err.println("ERRO!\n Opera��o ilegal: a v�riavel " + listaExp.get(listaExp.size() - 2).getValor() + "foi dividida por zero");
    				  }
    				  else{// x/1
    					  this.listaExp.removeLast();
    					  return true;
    				  } 
    			  }
    			  else if(op == '^'){
    				  if(ultimoListaValor == 0){//x^0
    					  listaExp.removeLast();
    					  listaExp.removeLast();
    					  listaExp.add(new Item('n', "1"));
    					  return true;
    				  }
    				  else{//x^1
    					  this.listaExp.removeLast();
    					  return true;
    				  }
    			  }
    		  }
    	  }

    	  return false;
      }
      //Para situa��es onde se tem 0 + x, 1 * x, 1^x, 0^x, 0*x, 0/x.
      private boolean elementoNeutroPre(char op){
    	  char penultimoListaTipo = listaExp.get(listaExp.size() - 2).getTipo();
    	  char ultimoListaTipo = listaExp.getLast().getTipo();
    	  double ultimoListaValor;

    	  if( (penultimoListaTipo == 'n') && (ultimoListaTipo == 'v') ){

    		  ultimoListaValor = Double.parseDouble(listaExp.get(listaExp.size() - 2).getValor());

    		  if((ultimoListaValor == 0) || (ultimoListaValor == 1) ){

    			  if(op == '+' || op == '-'){
    				  if(ultimoListaValor == 0){//0+x, 0-x
    					  this.removePenultimoLista();
    					  return true;
    				  }
    			  }  
    			  else if(op == '*'){	  	  
    				  if(ultimoListaValor == 0){//0*x
    					  this.listaExp.removeLast();
    					  return true;
    				  }
    				  else{//1*x
    					  this.removePenultimoLista();
    					  return true;
    				  }
    			  }else if(op == '/'){
    				  if(ultimoListaValor == 0){// 0/x 
    					  this.listaExp.removeLast();
    					  return true;
    				  }
    			  }
    			  else if(op == '^'){// 0^x, 1^x
    				  this.listaExp.removeLast();
    				  return true;
    			  }

    		  }
    	  }

    	  return false;
      } 
      
      private void removePenultimoLista(){
    	  Item item;
    	  item = listaExp.removeLast();
		  listaExp.removeLast();
		  listaExp.add(item);
      }
      
      // Retorna a quantidade de elementos
      public int nElem(){
    	  return this.listaExp.size();
      }

      public boolean otimizaString(){
    	  String a,b;
    	  Item item;

    	  if(listaExp.getLast().getTipo() == 's' && listaExp.get(listaExp.size() - 2).getTipo() == 's'){
    		  b=listaExp.removeLast().getValor();
    		  a=listaExp.removeLast().getValor();
    		  a = a.substring(0, a.length()-1); //Elimina a ultima aspas
    		  b = b.substring(1, b.length()); //Elimina a primeira aspas
    		  item = new Item ('s', (a+b));
    		  this.inclui(item);
    		  return true;
    	  }
    	  return false;
    	  
      }
      // Remove o primeiro elemento e retorna
      public Item removePrim(){
    	  return this.listaExp.removeFirst();
      }
      
      public int tamMaxPilha(Expressao exp){
    	  int cont=0;
    	  
    	  for(int i=0; i<exp.nElem(); i++){
    		  if(exp.get(i).getTipo() == 'n' || exp.get(i).getTipo() == 'v')
    			  cont+=2;
    	  }
    	  return cont;
      }
      //Verifica se � uma expressao num�rica
      //Na expressao num�rica s� pode ter operadores aritm�ticos, variaveis num�ricas e numeros
      public boolean isExpressaoNumerica(Tabela tab) {
    	  Item item;
    	  Simbolo simb;
    	  String op;
    	  int nElem = this.nElem();
    	  
    	  for(int i=0; i<nElem; i++){//Percorre a lista
    		  item = this.get(i);
    	    		 
    		  if( item.getTipo() == 'v' ){// Se for v�riavel do tipo string retorna false
    			  simb = tab.getSimbolo(item.getValor());

    			  if(simb != null){
    				  if( simb.getTipo() == 's')
    					  return false;
    			  }
    		  } 
    		  else if( item.getTipo() == 'o'){//Se for um operador que n�o seja aritm�tico retorna false
    			  op = item.getValor();

    			  if(op != "+" && op != "-" && op != "/" && op != "*" && op != "^" )
    				  return false;
    		  }
    		  else if(item.getTipo() == 's')// Se for uma string retorna false
    			  return false;
    	  }
    	  
    	  return true;
      }
      //Verifica se � uma expressao Texto
      //Na expressao Texto s� pode ter operador aditivo, variaveis num�ricas, variaveis texto, Strings e numeros.
      //Os n�meros s�o concatenados. Texto a = 5 + 7; Iria exibir 57  
      //N�o pode se ter expressoes aritm�ticas nas exibicoes
      public boolean isExpressaoTexto(){//Percorre a lista
    	  Item item;
    	  String op;
    	  int nElem = this.nElem();
    	  
    	  for(int i=0; i < nElem; i++){
    		  item = this.get(i);
    		  
    		  if( item.getTipo() == 'o'){//Se tiver algum operador diferente de + retorna false
     			 op = item.getValor();

     			 if(op != "+")
     				 return false;
     		  }
    	  }
    	  
    	  return true;
      }
      //Verifica se � uma expressao a ser usada nas condi��es (se, enquanto)
      //Na condi��o pode se ter tudo menos v�riaveis do tipo string e strings
      public boolean isExpressaoCondicional(Tabela tab){
    	  Item item;
    	  Simbolo simb;
    	  int nElem = this.nElem();
    	  
    	  for(int i=0; i < nElem; i++){//Percorre a lista
    		  item = this.get(i);
    		 
    		  if( item.getTipo() == 'v' ){// Se for v�riavel do tipo string retorna false
    			  simb = tab.getSimbolo(item.getValor());
    			  
    			  if(simb != null){
    				  if( simb.getTipo() == 's')
    					  return false;
    			  }
    		  }
    		  else if( item.getTipo() == 's' )// Se tiver alguma string retorna false
    			  return false;

    	  }
    	  
    	  return true;

      }
      
      public Item get(int n){
    	  return this.listaExp.get(n);  
      }
      
      public String toString() {

            return this.listaExp.toString();

      }

}

