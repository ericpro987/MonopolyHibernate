import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public abstract class Propietat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	String nom;
	@Column
	int preu;
	@Column
	int preuHipoteca;
	@Column
	boolean hipotecada;
	@Column
	int posicio;
	
	@ManyToOne
	Jugador jugador;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPreu() {
		return preu;
	}
	public void setPreu(int preu) {
		this.preu = preu;
	}
	public int getPreuHipoteca() {
		return preuHipoteca;
	}
	public void setPreuHipoteca(int preuHipoteca) {
		this.preuHipoteca = preuHipoteca;
	}
	public boolean isHipotecada() {
		return hipotecada;
	}
	public void setHipotecada(boolean hipotecada) {
		this.hipotecada = hipotecada;
	}
	public int getPosicio() {
		return posicio;
	}
	public void setPosicio(int posicio) {
		this.posicio = posicio;
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
	public abstract void CalcularLloger();
	
	public Propietat() {
		super();
	}
	
}
