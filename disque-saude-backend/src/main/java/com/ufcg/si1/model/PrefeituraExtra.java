package com.ufcg.si1.model;

public class PrefeituraExtra extends Prefeitura {

	private static final double INDICERUIM = 0.1;
	private static final double INDICEREGULAR = 0.05;
	
	public PrefeituraExtra() {
		this.setIndiceRuim(INDICERUIM);
		this.setIndiceRegular(INDICEREGULAR);
	}
}
