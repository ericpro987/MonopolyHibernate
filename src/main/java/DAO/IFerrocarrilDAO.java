package DAO;

import java.util.List;

import Classes.Ferrocarril;
import Classes.Jugador;

public interface IFerrocarrilDAO extends IGenericDAO<Ferrocarril, Integer>{

	List<Ferrocarril> ferrocarrilsVeins(Ferrocarril ferrocarril);
	
	boolean isFerrocarrilVei(Ferrocarril f1, Ferrocarril f2);
	
	boolean transportFerrocarril(Jugador jugador, Ferrocarril desti);
	
	int calcularLloguerFerrocarril(Ferrocarril f);
	
}
