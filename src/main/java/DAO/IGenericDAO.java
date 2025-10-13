package DAO;

import java.io.Serializable;
import java.util.List;

import Classes.Jugador;
import Classes.Propietat;

public interface IGenericDAO<T, ID extends Serializable> {

	void SaveOrUpdate(T entity);

	void delete(ID id);

	void delete(T entity);

	List<T> findAll();
	
	T get(ID id);
	
	Jugador ComprovarPropietari(Propietat propietat);

	boolean Comprar(Jugador jugador, Propietat propietat);
	
	boolean Hipotecar(Jugador jugador, Propietat propietat);

	boolean Deshipotecar(Jugador jugador, Propietat propietat);

	int modificarDiners(Jugador jugador, int quantitat);
	
	Propietat getPropietatenCasella(int posicio);

	boolean PagarLloguer(Jugador jugador, Propietat propietat);
	
	
	
}
