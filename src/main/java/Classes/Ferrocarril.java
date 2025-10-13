package Classes;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("Ferro")
public class Ferrocarril extends Propietat {

	@OneToOne
	Ferrocarril seguentFerro;
	@OneToOne(mappedBy = "seguentFerro")
	Ferrocarril antFerro;
	
	
	
	public Ferrocarril getSeguentFerro() {
		return seguentFerro;
	}

	public void setSeguentFerro(Ferrocarril seguentFerro) {
		this.seguentFerro = seguentFerro;
	}

	public Ferrocarril getAntFerro() {
		return antFerro;
	}

	public void setAntFerro(Ferrocarril antFerro) {
		this.antFerro = antFerro;
	}

	public Ferrocarril(Ferrocarril seguentFerro, Ferrocarril antFerro) {
		super();
		this.seguentFerro = seguentFerro;
		this.antFerro = antFerro;
	}

	public Ferrocarril() {
		super();
	}

	@Override
	public void CalcularLloger() {
		// TODO Auto-generated method stub

	}

}
