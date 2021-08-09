package mz.co.ldevz.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "`usuario`")
public class Usuario extends AbstractEntity {

	// User fields and annotate with it's column to connect to jpa entity manager

	@Column(name = "user_username")
	private String username;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_email")
	private String email;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bilhete_id")
	private Collection<Bilhete> bilhetes;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_perfil", 
	joinColumns = @JoinColumn(name = "usuario_id"), 
	inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private Collection<Perfil> roles;
	
	public void addPerfil(UsuarioPerfil tipo) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(new Perfil(tipo.getCod()));
	}
	public Usuario() {
		super();
	}
	// User super and fields constructors
public Usuario(Long id)
{
	super.setId(id);
}
	/*public Usuario() {
	}

	public Usuario(String userName, String password, String email, Collection<Perfil> roles) {
		this.username = userName;
		this.password = password;
		this.email = email;
		this.roles = roles;
		
	}*/

	// User getters and setters fields

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Perfil> getRoles() {		
		return roles;
	}

	public void setRoles(List<Perfil> list) {
		Collection<Perfil> roles1 = new ArrayList<>();
		roles1.add(new Perfil("CLIENTE"));

		
		this.roles = roles1;
	}
	
	

	

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ", userName=" + username + ", password=" + password + ", email=" + email + ", roles="
				+ roles +  "]";
	}

}

