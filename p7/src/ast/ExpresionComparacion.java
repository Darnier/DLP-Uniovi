package ast;

import visitor.*;

//	ExpresionComparacion:Expresion -> left:Expresion  symbol:String  right:Expresion ;

public class ExpresionComparacion extends AbstractExpresion {

	public ExpresionComparacion(Expresion left, String symbol, Expresion right) {
		this.left = left;
		this.symbol = symbol;
		this.right = right;

		searchForPositions(left, right);	// Obtener linea/columna a partir de los hijos
	}

	public ExpresionComparacion(Object left, Object symbol, Object right) {
		this.left = (Expresion) left;
		this.symbol = (symbol instanceof Token) ? ((Token)symbol).getLexeme() : (String) symbol;
		this.right = (Expresion) right;

		searchForPositions(left, symbol, right);	// Obtener linea/columna a partir de los hijos
	}

	public Expresion getLeft() {
		return left;
	}
	public void setLeft(Expresion left) {
		this.left = left;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Expresion getRight() {
		return right;
	}
	public void setRight(Expresion right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion left;
	private String symbol;
	private Expresion right;
}

