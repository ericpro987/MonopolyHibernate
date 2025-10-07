import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Companyia")
public class CompanyiaServeis extends Propietat{

	@Enumerated(EnumType.STRING)
	@Column
	TipusServei tipusServei;
	
	
	public TipusServei getTipusServei() {
		return tipusServei;
	}


	public void setTipusServei(TipusServei tipusServei) {
		this.tipusServei = tipusServei;
	}


	public CompanyiaServeis() {
		super();
	}


	public CompanyiaServeis(TipusServei tipusServei) {
		super();
		this.tipusServei = tipusServei;
	}


	@Override
	public void CalcularLloger() {
		// TODO Auto-generated method stub
		
	}

}
