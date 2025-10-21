package DAO;

import Classes.Carrer;
import Classes.Jugador;

public interface ICarrerDAO extends IPropietatDAO<Carrer, Integer>{
	
	boolean ComprovarColorComplet(Carrer carrer);
	
	int edificar(Jugador jugador, Carrer carrer);

	int calcularLloguerCarrer(Carrer carrer);
	
	boolean vendreCases(Jugador jugador, Carrer carrer, int quantitat);
	

}
