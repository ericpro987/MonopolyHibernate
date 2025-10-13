package DAO;

import java.util.List;

import Classes.Jugador;
import Classes.Partida;
import Classes.Propietat;

public class PartidaDAO implements IPartidaDAO{

	@Override
	public void SaveOrUpdate(Partida entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Partida entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Partida> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partida get(Integer id) {
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
	public Jugador Reassignar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Roll(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PassarTorn() {
		// TODO Auto-generated method stub
		
	}

}
