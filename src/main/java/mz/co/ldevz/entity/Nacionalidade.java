package mz.co.ldevz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nacionalidade 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@EqualsAndHashCode.Include
	private Long codigo;
	
	private String pais;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
