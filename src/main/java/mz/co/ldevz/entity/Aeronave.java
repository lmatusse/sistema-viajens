package mz.co.ldevz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity

public class Aeronave extends AbstractEntity
{
	
	private String referencia;
	
	private Integer capacidade;
	
	@ManyToOne
	@JoinColumn(name = "codigo_companhia_area")
	private CompanhiaAerea companhiaAerea;

	public Aeronave() {
		// TODO Auto-generated constructor stub
	}
	public Aeronave(Long id)
	{
		super.setId(id);
	}
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}
	
	
}
