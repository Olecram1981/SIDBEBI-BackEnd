package com.marcelo.sidbebi.domain;

import javax.swing.plaf.multi.MultiPopupMenuUI;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

import com.marcelo.sidbebi.domain.enums.Tipo;

public class Produto {
	
	private Integer idInteger;
	private Tipo tipo;
	private String nomeString;
	private double valorUnit;
	private double valorTotal;
	
	private Fornecedor fornecedor;
	private Produto produto;
}
