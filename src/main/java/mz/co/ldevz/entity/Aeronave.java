package mz.co.ldevz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Aeronave 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@EqualsAndHashCode.Include
	private Long codigo;
	
	private String referencia;
	
	private Integer capacidade;
	
	@ManyToOne
	@JoinColumn(name = "codigo_companhia_area")
	private CompanhiaAerea companhiaAerea;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
