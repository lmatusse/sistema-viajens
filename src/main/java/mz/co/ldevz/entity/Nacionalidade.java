package mz.co.ldevz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Nacionalidade extends AbstractEntity
{
	
	private String pais;
public Nacionalidade() {
	// TODO Auto-generated constructor stub
}
	public Nacionalidade(Long id)
	{
		super.setId(id);
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
