package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Classes.Carrer;
import Classes.Jugador;
import Classes.Propietat;

public class CarrerDAO implements ICarrerDAO{

	protected SessionFactory sessionFactory;

	public CarrerDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}
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
		Carrer c = (Carrer) propietat;
		jugador.setDiners(jugador.getDiners()-calcularLloguerCarrer(c));
		return true;
	}

	@Override
	public boolean ComprovarColorComplet(Carrer carrer) {
		Jugador propietari = carrer.getJugador();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Carrer> query = session.createQuery("select * from propietats where tipusPropietat = :tipus and colorid = :color");
		query.setParameter("tipus", "Carrer");
		query.setParameter("color", carrer.getColor());
		List<Carrer> propietatambColor = query.list();
		boolean todos = true;
		for(Carrer c : propietatambColor) {
			if(!(c.getJugador() == propietari)) todos = false;
		}
		return todos;
	}

	@Override
	public int edificar(Jugador jugador, Carrer carrer) {
		// TODO Auto-generated method stub
		if(ComprovarColorComplet(carrer) && carrer.getJugador() == jugador)
			if(jugador.getDiners() >= carrer.getPreuCasa()) 
				if(carrer.getNombreCases()<5) 
					carrer.setNombreCases(carrer.getNombreCases()+1);
		return carrer.getNombreCases();
	}

	@Override
	public int calcularLloguerCarrer(Carrer carrer) {
		// TODO Auto-generated method stub
		int preuFinal = carrer.getLloguer0();
		if(carrer.getNombreCases() == 5) {
			preuFinal = carrer.getLlogerHotel();
		}else if(carrer.getNombreCases() == 4) {
			preuFinal = carrer.getLloger4();
		}else if(carrer.getNombreCases() == 3) {
			preuFinal = carrer.getLloger3();
		}else if(carrer.getNombreCases() == 2) {
			preuFinal = carrer.getLloger2();
		}else if(carrer.getNombreCases() == 1) {
			preuFinal = carrer.getLloger1();
		}else if(ComprovarColorComplet(carrer)) {
			preuFinal *= 2;
		}
		return preuFinal;
	}

	@Override
	public boolean vendreCases(Jugador jugador, Carrer carrer, int quantitat) {
		// TODO Auto-generated method stub
		if(carrer.getNombreCases()>=quantitat && quantitat > 0) {
			jugador.setDiners(jugador.getDiners()+((carrer.getPreuCasa()/2)*quantitat));
			return true;
		}
		else
			return false;
	}

}
