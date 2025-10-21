package DAO;

import java.io.Serializable;

import Classes.Jugador;

public interface IJugadorDAO<T, ID extends Serializable> extends IGenericDAO<T, ID>{
	
	void update(Jugador j);
	int ModificarDiners(Jugador jugador, int diners);
	
}
