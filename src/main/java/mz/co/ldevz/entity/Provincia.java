package mz.co.ldevz.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

	@Entity
	public class Provincia 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@EqualsAndHashCode.Include
		private Long codigo;
		
		private String nome;
		
		@ManyToMany(mappedBy="provincia")
		private List <Voo> voo;

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
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
