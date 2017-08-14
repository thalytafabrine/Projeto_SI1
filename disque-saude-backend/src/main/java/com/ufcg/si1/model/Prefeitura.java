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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(indiceRegular);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(indiceRuim);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((situacaoPrefeitura == null) ? 0 : situacaoPrefeitura.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			Prefeitura other = (Prefeitura) obj;
			
			if (Double.doubleToLongBits(indiceRegular) != Double.doubleToLongBits(other.indiceRegular))
				return false;
			if (Double.doubleToLongBits(indiceRuim) != Double.doubleToLongBits(other.indiceRuim))
				return false;
			
			if (situacaoPrefeitura == null) {
				if (other.situacaoPrefeitura != null)
					return false;
			} else if (!situacaoPrefeitura.equals(other.situacaoPrefeitura))
				return false;
			
			return true;
		}

		

}
