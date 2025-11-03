package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Classes.Ferrocarril;
import Classes.Jugador;
import Classes.Partida;
import Classes.Propietat;

public class FerrocarrilDAO implements IFerrocarrilDAO{

	protected SessionFactory sessionFactory;

	public FerrocarrilDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}
	

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Ferrocarril> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Ferrocarril> list = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e").list();
			return list;
		} catch (Exception e) {

		} finally {
			session.getTransaction().commit();
			session.close();

		}
		return null;
	}

	private Class<Ferrocarril> getEntityClass() {
		// TODO Auto-generated method stub
		return Ferrocarril.class;
	}


	@Override
	public Ferrocarril get(Integer id) {
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
		jugador.setDiners(jugador.getDiners()-calcularLloguerFerrocarril(((Ferrocarril) propietat)));
		return false;
	}

	@Override
	public List<Ferrocarril> ferrocarrilsVeins(Ferrocarril ferrocarril) {
		// TODO Auto-generated method stub
		List<Ferrocarril> l = new ArrayList<Ferrocarril>();
		l.add(ferrocarril.getAntFerro());
		l.add(ferrocarril.getSeguentFerro());
		return l;
	}

	@Override
	public boolean isFerrocarrilVei(Ferrocarril f1, Ferrocarril f2) {
		// TODO Auto-generated method stub
		if(ferrocarrilsVeins(f1).contains(f2))
			return true;
		else
			return false;
	}

	@Override
	public boolean transportFerrocarril(Jugador jugador, Ferrocarril desti) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Integer> query =  session.createQuery("select posicio from propietat p where tipusPropietat = Ferro");
		List<Integer> ferros = query.list();
		if(ferros.contains(jugador.getFitxa().getPosicio())) {
			session.beginTransaction();
			Query<Ferrocarril> query2 =  session.createQuery("select * from propietat p where posicio = :posicio");
			query2.setParameter("posicio", jugador.getFitxa().getPosicio());
			Ferrocarril f1 = query2.getSingleResult();
			if(f1.getJugador() == jugador && desti.getJugador() == jugador) {
				if(isFerrocarrilVei(f1, desti)) {
					jugador.getFitxa().setPosicio(desti.getPosicio());
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int calcularLloguerFerrocarril(Ferrocarril f) {
		// TODO Auto-generated method stub
		int nFerros = 25;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Ferrocarril> query =  session.createQuery("select * from propietat p where tipusPropietat = Ferro");
		for(Ferrocarril fe : query.list()) {
			if(fe != f) {
				if(fe.getJugador() == f.getJugador()) {
					nFerros *= 2;
				}
			}
		}
		return nFerros;
	}

	@Override
	public void SaveOrUpdate(Ferrocarril entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Ferrocarril entity) {
		// TODO Auto-generated method stub
		
	}


	public void afegirVeins(Ferrocarril f1, Ferrocarril f2, Ferrocarril f3, Ferrocarril f4) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		f1.setAntFerro(f4);
		f1.setSeguentFerro(f2);
		f2.setAntFerro(f1);
		f2.setSeguentFerro(f3);
		f3.setAntFerro(f2);
		f3.setSeguentFerro(f4);
		f4.setAntFerro(f3);
		f4.setSeguentFerro(f1);
		
		session.merge(f1);
		session.merge(f2);
		session.merge(f3);
		session.merge(f4);

		session.getTransaction().commit();
	}

}
