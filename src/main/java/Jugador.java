import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

	@Column(length = 50)
	String nom;

	@Column(nullable = false)
	@ColumnDefault(value = "true")
	boolean viu;

	@Column
	int ordre;

	@Column
	int diners;

	@Column
	int victories;

	@ManyToMany
	Set<Partida> partides;

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

	public Set<Partida> getPartides() {
		return partides;
	}

	public void setPartides(Set<Partida> partides) {
		this.partides = partides;
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
		viu = true;
		this.partides = new HashSet<Partida>();
	}

	public Jugador(String nom, boolean viu, int ordre, int diners, int victories, Partida partida, Fitxa fitxa) {
		super();
		this.nom = nom;
		this.viu = viu;
		this.ordre = ordre;
		this.diners = diners;
		this.victories = victories;
		this.partides = new HashSet<Partida>();
		this.fitxa = fitxa;
	}

}
