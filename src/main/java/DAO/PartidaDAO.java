package DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Classes.Carrer;
import Classes.CompanyiaServeis;
import Classes.Ferrocarril;
import Classes.Fitxa;
import Classes.Jugador;
import Classes.Partida;
import Classes.Propietat;

public class PartidaDAO implements IPartidaDAO<Partida, Integer>{

	protected SessionFactory sessionFactory;

	public PartidaDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
    private Class<Partida> getEntityClass() {
		return Partida.class;
	}
	@Override
	public List<Partida> findAll() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				try {
					session.beginTransaction();
					List<Partida> list = session.createQuery("SELECT e FROM " + getClass().getSuperclass().getName() + " e").list();
					return list;
				} catch (HibernateException e) {

				} finally {
					session.getTransaction().commit();
					session.close();

				}
				return null;
	}

	@Override
	public Jugador Reassignar() {
			// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query<Jugador> query = session.createQuery("from Jugador where diners < 0");
		List<Jugador> bancaRota = query.list();
		for (Jugador jugador : bancaRota) {
			jugador.setViu(false);
			jugador.getPropietats().clear();
			session.merge(jugador);
		}
		Query<Jugador> query2 = session.createQuery("from Jugador");
		List<Jugador> jugadorsActuals = query2.list();
		if(jugadorsActuals.size() == 1) {
			Jugador winner = jugadorsActuals.get(0);
			winner.setVictories(winner.getVictories()+1);
			Query<Partida> query3 = session.createQuery("from Partida where dataFi is null");
			Partida partida = query3.getSingleResult();
			partida.setDataFi(new Date());
			session.merge(partida);
			session.merge(winner);
			session.close();
			return winner;
		}
		session.close();
		return null;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Partida p = new Partida();
		p.setDataInici(new Date());
		Jugador j1 = new Jugador();
		j1.setNom("Jugador1");
		j1.setOrdre(0);
		j1.setViu(true);
		j1.getPartides().add(p);
		p.getJugadors().add(j1);
		Fitxa f1 = new Fitxa();
		j1.setFitxa(f1);
		f1.setJugador(j1);
		Jugador j2 = new Jugador();
		j2.setNom("Jugador2");
		j2.setOrdre(1);
		j2.setViu(true);
		j2.getPartides().add(p);
		p.getJugadors().add(j2);
		Fitxa f2 = new Fitxa();
		j2.setFitxa(f2);
		f2.setJugador(j2);
		Jugador j3 = new Jugador();
		j3.setNom("Jugador3");
		j3.setOrdre(2);
		j3.setViu(true);
		j3.getPartides().add(p);
		p.getJugadors().add(j3);
		Fitxa f3 = new Fitxa();
		j3.setFitxa(f3);
		f3.setJugador(j3);
		Jugador j4 = new Jugador();
		j4.setNom("Jugador4");
		j4.setOrdre(3);
		j4.setViu(true);
		j4.getPartides().add(p);
		p.getJugadors().add(j4);
		Fitxa f4 = new Fitxa();
		j4.setFitxa(f4);
		f4.setJugador(j4);
		List<Jugador> list = new ArrayList<Jugador>();
		list.add(j1);
		list.add(j2);
		list.add(j3);
		list.add(j4);
		Collections.shuffle(list);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setOrdre(i);
			list.get(i).setDiners(1500);
		}
		session.persist(p);
		session.persist(j1);
		session.persist(j2);
		session.persist(j3);
		session.persist(j4);
		session.persist(f1);
		session.persist(f2);
		session.persist(f3);
		session.persist(f4);
		session.getTransaction().commit();
		session.close();
	}
	public static int dau = 0;
	@Override
	public void Roll(Jugador jugador) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int roll = rand.nextInt(1,7);
		dau = roll;
		Fitxa fitxa = jugador.getFitxa();
		int novaPosicio = (fitxa.getPosicio() + roll)%40;
		CarrerDAO carrerDAO = new CarrerDAO();
		Propietat propietat = carrerDAO.getPropietatenCasella(novaPosicio);
		if(propietat != null) {
			if(propietat.getJugador() != null) {
				if(propietat.getJugador() != jugador) {
					carrerDAO.PagarLloguer(jugador, propietat);
				}
			}
			
		}
		fitxa.setPosicio(novaPosicio);
	}
	int torn = 0;
	
	@Override
	public void PassarTorn() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		torn++;
		torn = torn%4;
	}
	public int getTorn() {
		return torn;
	}


public Jugador getJugadorActiu() {
    Session session = sessionFactory.openSession();
    try {
        session.beginTransaction();
        Query<Jugador> query = session.createQuery("from Jugador where ordre = :ordre and viu = true", Jugador.class);
        query.setParameter("ordre", torn);
        Jugador jugador = query.uniqueResult();
        session.getTransaction().commit();
        return jugador;
    } catch (Exception e) {
        if (session.getTransaction().isActive()) session.getTransaction().rollback();
        return null;
    } finally {
        session.close();
    }
	}

	@Override
	public Partida get(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Partida partida = session.get(Partida.class, id);
			return partida;
		} catch (HibernateException e) {

		} finally {
			session.getTransaction().commit();
			session.close();

		}
		return null;
	}


	@Override
	public void SaveOrUpdate(Partida entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Partida entity) {
		// TODO Auto-generated method stub
		
	}


	public Partida getPartidaActiva() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Partida> list = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e").list();
		for (Partida partida : list) {
			if(partida.getDataFi() == null)
				session.getTransaction().commit();

				return partida;
		}
		
		return null;
	}


}
