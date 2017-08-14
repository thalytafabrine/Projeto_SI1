package com.ufcg.si1.model;

public class PrefeituraNormal extends Prefeitura {

	private static final double INDICERUIM = 0.2;
	private static final double INDICEREGULAR = 0.1;
	
	public PrefeituraNormal() {
		this.setIndiceRuim(INDICERUIM);
		this.setIndiceRegular(INDICEREGULAR);
	}
}
