package DAO;

import Classes.Jugador;
import Classes.Partida;

public interface IPartidaDAO extends IGenericDAO<Partida, Integer>{

	Jugador Reassignar();
	
	void Start();
	
	void Roll(Jugador jugador);
	
	void PassarTorn();
	
}
