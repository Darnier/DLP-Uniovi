package ast;

import visitor.*;

//	Campo -> identificador:String  tipo:Tipo ;

public class Campo extends AbstractTraceable implements AST {

	public Campo(String identificador, Tipo tipo) {
		this.identificador = identificador;
		this.tipo = tipo;

		searchForPositions(tipo);	// Obtener linea/columna a partir de los hijos
	}

	public Campo(Object identificador, Object tipo) {
		this.identificador = (identificador instanceof Token) ? ((Token)identificador).getLexeme() : (String) identificador;
		this.tipo = (Tipo) tipo;

		searchForPositions(identificador, tipo);	// Obtener linea/columna a partir de los hijos
	}

	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String identificador;
	private Tipo tipo;
	public int offset;
	public int offset(){return offset;};
	public int size(){return tipo.size();}

}

