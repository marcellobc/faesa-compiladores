/* Generated By:JavaCC: Do not edit this line. AMelhorConstants.java */
package Compilador;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface AMelhorConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SOMA = 1;
  /** RegularExpression Id. */
  int SUBTRACAO = 2;
  /** RegularExpression Id. */
  int MULTIPLICACAO = 3;
  /** RegularExpression Id. */
  int DIVISAO = 4;
  /** RegularExpression Id. */
  int CONSTANTE_NUMERO = 5;
  /** RegularExpression Id. */
  int CONSTANT = 6;
  /** RegularExpression Id. */
  int STRING = 7;
  /** RegularExpression Id. */
  int INTEGER = 8;
  /** RegularExpression Id. */
  int PRINT = 9;
  /** RegularExpression Id. */
  int INPUT = 10;
  /** RegularExpression Id. */
  int VAR = 11;
  /** RegularExpression Id. */
  int VAREXPRE = 12;
  /** RegularExpression Id. */
  int LETRA = 13;
  /** RegularExpression Id. */
  int DIGITO = 14;
  /** RegularExpression Id. */
  int POTENCIA = 15;
  /** RegularExpression Id. */
  int VIRGULA = 16;
  /** RegularExpression Id. */
  int RESTO_DIVISAO = 17;
  /** RegularExpression Id. */
  int IGUAL = 18;
  /** RegularExpression Id. */
  int ATRIBUICAO = 19;
  /** RegularExpression Id. */
  int ABRE_PARENTESES = 20;
  /** RegularExpression Id. */
  int FECHA_PARENTESES = 21;
  /** RegularExpression Id. */
  int MAIOR = 22;
  /** RegularExpression Id. */
  int MAIOR_IGUAL = 23;
  /** RegularExpression Id. */
  int MENOR = 24;
  /** RegularExpression Id. */
  int MENOR_IGUAL = 25;
  /** RegularExpression Id. */
  int CONCATENACAO = 26;
  /** RegularExpression Id. */
  int QUEBRA_LINHA = 27;
  /** RegularExpression Id. */
  int TABULACAO = 28;
  /** RegularExpression Id. */
  int CONSTANTE_TEXTO = 29;
  /** RegularExpression Id. */
  int ENQUANTO = 30;
  /** RegularExpression Id. */
  int SE = 31;
  /** RegularExpression Id. */
  int SENAO = 32;
  /** RegularExpression Id. */
  int VERDADEIRO = 33;
  /** RegularExpression Id. */
  int FALSE = 34;
  /** RegularExpression Id. */
  int THEN = 35;
  /** RegularExpression Id. */
  int FIMSE = 36;
  /** RegularExpression Id. */
  int FIMENQUANTO = 37;
  /** RegularExpression Id. */
  int BEGIN = 38;
  /** RegularExpression Id. */
  int END = 39;
  /** RegularExpression Id. */
  int OR = 40;
  /** RegularExpression Id. */
  int AND = 41;
  /** RegularExpression Id. */
  int NOT = 42;
  /** RegularExpression Id. */
  int DIFERENTE = 43;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "<CONSTANTE_NUMERO>",
    "<CONSTANT>",
    "\"string\"",
    "\"integer\"",
    "\"print\"",
    "\"input\"",
    "\"VAR\"",
    "<VAREXPRE>",
    "<LETRA>",
    "<DIGITO>",
    "\"^\"",
    "\",\"",
    "\"%\"",
    "\"==\"",
    "\":\"",
    "\"(\"",
    "\")\"",
    "\">\"",
    "\" >=\"",
    "\"<\"",
    "\">=\"",
    "\"\\\\\"",
    "\"\\n\"",
    "\"\\t\"",
    "<CONSTANTE_TEXTO>",
    "\"enquanto\"",
    "\"se\"",
    "\"senao\"",
    "\"true\"",
    "\"false\"",
    "\"THEN\"",
    "\"FIMSE\"",
    "\"FIMENQUANTO\"",
    "\"BEGIN\"",
    "\"END\"",
    "\"OR\"",
    "\"AND\"",
    "\"NOT\"",
    "\"!=\"",
  };

}