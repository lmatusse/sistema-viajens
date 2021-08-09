package mz.co.ldevz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`perfil`")
public class Perfil extends AbstractEntity {

	// Role fields and annotate with it's column to connect to jpa entity manager
	
	@Column(name = "role_name")
	private String name;

	// Role super and fields constructors
	public Perfil() {super();}
	
	public Perfil(Long id)
	{
		super.getId();
	}
	public Perfil(String name) {
		this.name = name;
	}

	// Role getters and setters fields
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// override to string method to contain all fields

	@Override
	public String toString() {
		return "Role{" + "id=" + super.getId() + ", name='" + name + '\'' + '}';
	}
}
