package com.prf.inventario.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
	
	@Embeddable
	public class IdSchemaUsuario implements Serializable {
		
		private static final long serialVersionUID = 1L;		
		
		@ManyToOne
		@JoinColumn(name = "T009_ID_SCHEMA")
		private Schema schema;
		
		@ManyToOne
		@JoinColumn(name = "T007_ID_USUARIO")
		private Usuario usuario;
		
		
		//Getter e Setters

		public Schema getSchema() {
			return schema;
		}

		public void setSchema(Schema schema) {
			this.schema = schema;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		//HashCode e Equals

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((schema == null) ? 0 : schema.hashCode());
			result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
			IdSchemaUsuario other = (IdSchemaUsuario) obj;
			if (schema == null) {
				if (other.schema != null)
					return false;
			} else if (!schema.equals(other.schema))
				return false;
			if (usuario == null) {
				if (other.usuario != null)
					return false;
			} else if (!usuario.equals(other.usuario))
				return false;
			return true;
		}
		
		
		
		
		
		
		
		

	
		
	}
