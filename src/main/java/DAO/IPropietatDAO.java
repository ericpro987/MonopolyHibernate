package DAO;

import java.io.Serializable;
import java.util.List;

import Classes.Jugador;
import Classes.Partida;
import Classes.Propietat;

public interface IPropietatDAO<T, ID extends Serializable> extends IGenericDAO<T, ID>{


	
	Jugador ComprovarPropietari(Propietat propietat);

	boolean Comprar(Jugador jugador, Propietat propietat);
	
	boolean Hipotecar(Jugador jugador, Propietat propietat);

	boolean Deshipotecar(Jugador jugador, Propietat propietat);

	int modificarDiners(Jugador jugador, int quantitat);
	
	Propietat getPropietatenCasella(int posicio);

	boolean PagarLloguer(Jugador jugador, Propietat propietat);
	
	
	
}
