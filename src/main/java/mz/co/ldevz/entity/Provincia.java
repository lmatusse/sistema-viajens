package mz.co.ldevz.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

	@SuppressWarnings("serial")
	@Entity
	public class Provincia extends AbstractEntity
	{
		
		
		private String nome;
		
		@ManyToMany(mappedBy="provincia")
		private List <Voo> voo;
public Provincia() {
	// TODO Auto-generated constructor stub
}
		public Provincia(Long id)
		{
			super.setId(id);
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Voo> getVoo() {
			return voo;
		}

		public void setVoo(List<Voo> voo) {
			this.voo = voo;
		}
		
		
		
}
