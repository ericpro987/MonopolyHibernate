import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Fitxa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;

	@Column
	String color;

	@Column
	int posicio;

	@Column
	String iconType;

	@OneToOne
	Jugador jugador;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPosicio() {
		return posicio;
	}

	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}

	public String getIconType() {
		return iconType;
	}

	public void setIconType(String iconType) {
		this.iconType = iconType;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getId() {
		return id;
	}

	public Fitxa() {
		super();
	}

	public Fitxa(String color, int posicio, String iconType, Jugador jugador) {
		super();
		this.color = color;
		this.posicio = posicio;
		this.iconType = iconType;
		this.jugador = jugador;
	}

}
