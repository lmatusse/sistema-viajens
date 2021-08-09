package mz.co.ldevz.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity

public class Voo extends AbstractEntity
{
	
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate data;
	
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime horaPartida;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime horaChegada;
	
	private BigDecimal preco;
	
	@OneToOne
	@JoinColumn(name = "codigo_aeronave", nullable = false)
	private Aeronave aeronave;
	
	@ManyToMany
	@JoinTable(name="voopro",
		joinColumns= {@JoinColumn(name = "codigo_voo")},
		inverseJoinColumns= {@JoinColumn(name = "codigo_provincia")}
	)
	private List<Provincia> provincia;

	public Voo() {
		// TODO Auto-generated constructor stub
	}
	public Voo(Long id)
	{
		super.setId(id);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public List<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(List<Provincia> provincia) {
		this.provincia = provincia;
	}

}
