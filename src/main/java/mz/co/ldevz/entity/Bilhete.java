package mz.co.ldevz.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity

public class Bilhete extends AbstractEntity
{

	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalDate dataReserva;
    @Column(name="bilhete_id")
    private Long usuario;
	
	

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	@OneToOne
	@JoinColumn(name = "codigo_voo")
	private Voo voo;
	
	public Bilhete() {}
	
	public Bilhete(Long id)
	{
		super.setId(id);
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	

}
