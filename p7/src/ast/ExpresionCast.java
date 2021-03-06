package ast;

import visitor.*;

//	ExpresionCast:Expresion -> tipo:Tipo  expresion:Expresion ;

public class ExpresionCast extends AbstractExpresion {

	public ExpresionCast(Tipo tipo, Expresion expresion) {
		this.tipo = tipo;
		this.expresion = expresion;

		searchForPositions(tipo, expresion);	// Obtener linea/columna a partir de los hijos
	}

	public ExpresionCast(Object tipo, Object expresion) {
		this.tipo = (Tipo) tipo;
		this.expresion = (Expresion) expresion;

		searchForPositions(tipo, expresion);	// Obtener linea/columna a partir de los hijos
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Expresion getExpresion() {
		return expresion;
	}
	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Tipo tipo;
	private Expresion expresion;
}

