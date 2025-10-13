package Classes;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Carrer")
public class Carrer extends Propietat {

	@Column
	int lloguer0;
	@Column
	int lloger1;
	@Column
	int lloger2;
	@Column
	int lloger3;
	@Column
	int lloger4;
	@Column
	int llogerHotel;
	@Column
	int preuCasa;
	@Column
	int nombreCases;
	@ManyToOne
	Color color;
	@Override
	public void CalcularLloger() {
		// TODO Auto-generated method stub
		
	}
	public int getLloguer0() {
		return lloguer0;
	}
	public void setLloguer0(int lloguer0) {
		this.lloguer0 = lloguer0;
	}
	public int getLloger1() {
		return lloger1;
	}
	public void setLloger1(int lloger1) {
		this.lloger1 = lloger1;
	}
	public int getLloger2() {
		return lloger2;
	}
	public void setLloger2(int lloger2) {
		this.lloger2 = lloger2;
	}
	public int getLloger3() {
		return lloger3;
	}
	public void setLloger3(int lloger3) {
		this.lloger3 = lloger3;
	}
	public int getLloger4() {
		return lloger4;
	}
	public void setLloger4(int lloger4) {
		this.lloger4 = lloger4;
	}
	public int getLlogerHotel() {
		return llogerHotel;
	}
	public void setLlogerHotel(int llogerHotel) {
		this.llogerHotel = llogerHotel;
	}
	public int getPreuCasa() {
		return preuCasa;
	}
	public void setPreuCasa(int preuCasa) {
		this.preuCasa = preuCasa;
	}
	public int getNombreCases() {
		return nombreCases;
	}
	public void setNombreCases(int nombreCases) {
		this.nombreCases = nombreCases;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Carrer(int lloguer0, int lloger1, int lloger2, int lloger3, int lloger4, int llogerHotel, int preuCasa,
			int nombreCases, Color color) {
		super();
		this.lloguer0 = lloguer0;
		this.lloger1 = lloger1;
		this.lloger2 = lloger2;
		this.lloger3 = lloger3;
		this.lloger4 = lloger4;
		this.llogerHotel = llogerHotel;
		this.preuCasa = preuCasa;
		this.nombreCases = nombreCases;
		this.color = color;
	}
	public Carrer() {
		super();
	}

}
