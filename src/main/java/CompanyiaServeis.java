import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table
public class CompanyiaServeis extends Propietat{

	@Enumerated(EnumType.STRING)
	@Column
	TipusServei tipusServei;
	@Override
	public void CalcularLloger() {
		// TODO Auto-generated method stub
		
	}

}
