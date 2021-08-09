package mz.co.ldevz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity

public class CompanhiaAerea extends AbstractEntity
{
	
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "codigo_nacionalidade", nullable = false)
	private Nacionalidade nacionalidade;
 public CompanhiaAerea() {
	// TODO Auto-generated constructor stub
}
	public CompanhiaAerea(Long id)
	{
		super.setId(id);
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
