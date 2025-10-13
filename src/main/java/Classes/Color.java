package Classes;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	String nom;
	@OneToMany
	Set<Propietat> propietats = new HashSet<Propietat>();

	public Color() {
		super();
	}

	public Color(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Propietat> getPropietats() {
		return propietats;
	}

	public void setPropietats(Set<Propietat> propietats) {
		this.propietats = propietats;
	}

	public int getId() {
		return id;
	}

}
