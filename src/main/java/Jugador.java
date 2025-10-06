import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;

	@Column
	String nom;

	@Column
	boolean viu;

	@Column
	int ordre;

	@Column
	int diners;

	@Column
	int victories;

	@ManyToOne
	Partida partida;

	@OneToOne(mappedBy = "jugador")
	Fitxa fitxa;

	@OneToMany(mappedBy = "jugador")
	Set<Propietat> propietats = new HashSet();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isViu() {
		return viu;
	}

	public void setViu(boolean viu) {
		this.viu = viu;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public int getDiners() {
		return diners;
	}

	public void setDiners(int diners) {
		this.diners = diners;
	}

	public int getVictories() {
		return victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Fitxa getFitxa() {
		return fitxa;
	}

	public void setFitxa(Fitxa fitxa) {
		this.fitxa = fitxa;
	}

	public int getId() {
		return id;
	}

	public Set<Propietat> getPropietats() {
		return propietats;
	}

	public Jugador() {
		super();
	}

	public Jugador(String nom, boolean viu, int ordre, int diners, int victories, Partida partida, Fitxa fitxa) {
		super();
		this.nom = nom;
		this.viu = viu;
		this.ordre = ordre;
		this.diners = diners;
		this.victories = victories;
		this.partida = partida;
		this.fitxa = fitxa;
	}

}
