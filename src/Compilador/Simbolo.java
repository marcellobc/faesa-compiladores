package Compilador;

import Compilador.Simbolo;

public class Simbolo {
	
	private static final long serialVersionUID = 11234L;
	private static int tamanhoMaiorNome = 0;
	private String nome;   
	private char tipo;     
	private int referencia;
	private static int marcador = 1;
	private boolean inicializada;
	
	
	public Simbolo() {
		
	}
	
	
	public Simbolo(String nome_valor, char tipo) {
		this.nome = nome_valor;
		this.tipo = tipo;
		this.referencia = Simbolo.marcador;
		this.inicializada = false;
		
		setMarcador(tipo);
		setTamanhoMaiorNome(nome.length());
		System.out.println(marcador);
	}
	
	
	public static int getTamanhoMaiorNome() {
		return tamanhoMaiorNome;
	}


	public static void setTamanhoMaiorNome(int tamanhoMaiorNome) {
		Simbolo.tamanhoMaiorNome = tamanhoMaiorNome;
	}


	public boolean getInicializada() {
		return inicializada;
	}


	public void setInicializada(boolean inicializada) {
		this.inicializada = inicializada;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	public static int getMarcador() {
		return marcador;
	}
	public static void setMarcador(int marcador) {
		Simbolo.marcador = marcador;
	} 

	public String toString() {

		return "\n" + "Nome:"+this.getNome() + "\t" + "Tipo:"+this.getTipo() + "\t" + "Refer�ncia:"+this.getReferencia();

	}
	



}
