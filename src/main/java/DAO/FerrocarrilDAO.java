package DAO;

import java.util.List;

import Classes.Ferrocarril;
import Classes.Jugador;
import Classes.Propietat;

public class FerrocarrilDAO implements IFerrocarrilDAO{

	@Override
	public void SaveOrUpdate(Ferrocarril entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ferrocarril entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ferrocarril> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ferrocarril get(Integer id) {
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
	public List<Ferrocarril> ferrocarrilsVeins(Ferrocarril ferrocarril) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFerrocarrilVei(Ferrocarril f1, Ferrocarril f2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transportFerrocarril(Jugador jugador, Ferrocarril desti) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calcularLloguerFerrocarril(Ferrocarril f) {
		// TODO Auto-generated method stub
		return 0;
	}

}
