package com.ufcg.si1.model;

public class Prefeitura {

		private double indiceRuim;
		private double indiceRegular;
		private SituacaoPrefeitura situacaoPrefeitura;
		
		public Prefeitura() {
			this.setSituacaoPrefeitura(new SituacaoPrefeitura(indiceRuim, indiceRegular));
		}

		public double getIndiceRuim() {
			return indiceRuim;
		}

		public void setIndiceRuim(double indiceRuim) {
			this.indiceRuim = indiceRuim;
		}

		public double getIndiceRegular() {
			return indiceRegular;
		}

		public void setIndiceRegular(double indiceRegular) {
			this.indiceRegular = indiceRegular;
		}

		public SituacaoPrefeitura getSituacaoPrefeitura() {
			return situacaoPrefeitura;
		}

		public void setSituacaoPrefeitura(SituacaoPrefeitura situacaoPrefeitura) {
			this.situacaoPrefeitura = situacaoPrefeitura;
		}

		// FALTA HASHCODE E EQUALS

}
