package erp.model;

public enum TipoEmpresa {
	
	MEI("Microempreendedor Individual"),
	EIRELI("Empresa individual de responsabilidade Limitada"),
	LTDA("Sociedade limitada"),
	SA("Sociedade anônima");
	
	private String descricao;
	
	TipoEmpresa(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
