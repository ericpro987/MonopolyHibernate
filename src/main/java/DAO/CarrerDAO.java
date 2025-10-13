package DAO;

import java.util.List;

import Classes.Carrer;
import Classes.Jugador;
import Classes.Propietat;

public class CarrerDAO implements ICarrerDAO{

	@Override
	public void SaveOrUpdate(Carrer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Carrer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carrer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrer get(Integer id) {
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
	public boolean ComprovarColorComplet(Carrer carrer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int edificar(Jugador jugador, Carrer carrer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularLloguerCarrer(Carrer carrer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean vendreCases(Jugador jugador, Carrer carrer, int quantitat) {
		// TODO Auto-generated method stub
		return false;
	}

}
