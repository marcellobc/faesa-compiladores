package Compilador;

import java.util.HashMap;

public class Tabela {
	
	
	private HashMap<String, Simbolo>tab = new HashMap<String, Simbolo>();
	

	public boolean inclui(Simbolo simbolo_valor) {
		if(this.tab.containsKey(simbolo_valor.getNome())) {
			return false;
		}else
			this.tab.put(simbolo_valor.getNome(),simbolo_valor);
			return true;
	}
	
	public Simbolo getSimbolo(String Chave) {
		return tab.get(Chave);
	}
	
	public int consultaReferencia(String chave) {
		return this.tab.get(chave).getReferencia();
	}
	
	public boolean isExistent(String chave) {
		return this.tab.containsKey(chave);
	}
	
	public int getNumeroSimbolos() {
		return tab.size();
	}
	
	public int getMarcador() {
		return Simbolo.getMarcador();
	}
	
	
	public boolean foiInicializado(String nome) {
		Simbolo simb;
		simb =  this.getSimbolo(nome);
		
		if (simb != null) {
			return simb.getInicializada();
		}
		
		return false;
	}
	
	public void inicializaIdent(String nome) {
		Simbolo simb = this.getSimbolo(nome);
		if(simb !=null) {
			simb.setInicializada(true);
		}
	}
	
	
	public String toString() {
		return this.tab.toString();
	}
	
	
	
}
