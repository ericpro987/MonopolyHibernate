package DAO;

import java.util.List;

import Classes.CompanyiaServeis;
import Classes.Jugador;
import Classes.Propietat;

public class CompanyiaServeisDAO implements ICompanyiaServeisDAO{

	@Override
	public void SaveOrUpdate(CompanyiaServeis entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CompanyiaServeis entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyiaServeis> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyiaServeis get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador ComprovarPropietari(Propietat propietat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Comprar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Hipotecar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Deshipotecar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int modificarDiners(Jugador jugador, int quantitat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Propietat getPropietatenCasella(int posicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean PagarLloguer(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calcularLloguerCompanyia(CompanyiaServeis companyia, int resultatDaus) {
		// TODO Auto-generated method stub
		return 0;
	}

}
