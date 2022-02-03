package com.marcelo.sidbebi.domain.enums;

public enum Tipo {
	
	ALCOOLICA(0, "ALCOOLICA"), NAOALCOOLICA(1, "NAO_ALCOOLICA"), COMIDA(2, "COMIDA");
	
	private Integer codigoInteger;
	private String descricao;
	
	private Tipo(Integer codigoInteger, String descricao) {
		this.codigoInteger = codigoInteger;
		this.descricao = descricao;
	}

	public Integer getCodigoInteger() {
		return codigoInteger;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//método que verifica se foi digitado um dos tipos enumerados acima (0, 1, 2, 3)
	public static Tipo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Tipo xStatus : Tipo.values()) {
			if(cod.equals(xStatus.getCodigoInteger())) {
				return xStatus;
			}
		}
		throw new IllegalArgumentException("Tipo Inválido");
	}

}
