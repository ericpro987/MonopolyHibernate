import java.time.DateTimeException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date dataInici;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date dataFi;

	@Column
	String estat;

	@OneToMany(mappedBy = "partida")
	Set<Jugador> jugadors;

	public Date getDataInici() {
		return dataInici;
	}

	public void setDataInici(Date dataInici) {
		this.dataInici = dataInici;
	}

	public Date getDataFi() {
		return dataFi;
	}

	public void setDataFi(Date dataFi) {
		this.dataFi = dataFi;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public Set<Jugador> getJugadors() {
		return jugadors;
	}

	public int getId() {
		return id;
	}

	public Partida() {
		super();
		jugadors = new HashSet();
	}

	public Partida(Date dataInici, Date dataFi, String estat, Set<Jugador> jugadors) {
		super();
		this.dataInici = dataInici;
		this.dataFi = dataFi;
		this.estat = estat;
		this.jugadors = jugadors;
		jugadors = new HashSet();
	}

}
