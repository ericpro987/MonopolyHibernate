package DAO;

import java.io.Serializable;

import Classes.Jugador;
import Classes.Partida;

public interface IPartidaDAO<T, ID extends Serializable> extends IGenericDAO<T, ID>{

	Jugador Reassignar();
	
	void Start();
	
	void Roll(Jugador jugador);
	
	void PassarTorn();
	
}
