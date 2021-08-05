package mz.co.ldevz.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Bilhete 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@EqualsAndHashCode.Include
	private Long codigo;

	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalDate dataReserva;
	
	@OneToOne
	@JoinColumn(name = "codigo_voo")
	private Voo voo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
