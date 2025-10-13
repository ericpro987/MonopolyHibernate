package DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Classes.Jugador;
import Classes.Propietat;

public class GenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	protected SessionFactory sessionFactory;

	public GenericDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}

	@Override
	public void SaveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			// Tota operació de modificació necessita una transacció
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// En cas d'error, fem rollback de la transacció
			handleException(session, e);
		}

	}

	@Override
	public void delete(ID id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(), id);
			session.remove(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			handleException(session, e);
		}
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<T> list = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e").list();
			return list;
		} catch (HibernateException e) {

		} finally {
			session.getTransaction().commit();
			session.close();

		}
		return null;
	}

	private void handleException(Session session, HibernateException e) {
		e.printStackTrace();
		if (session != null && session.getTransaction() != null) {
			System.out.println("\n.......Transaction Is Being Rolled Back.......");
			session.getTransaction().rollback();
		}
		e.printStackTrace();
	}

	@Override
	public T get(ID id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			// Utilitzem el mètode getEntityClass() per obtenir la classe correcta
			T entity = (T) session.get(getEntityClass(), id);
			session.getTransaction().commit();
			return entity;
		} catch (HibernateException e) {
			handleException(session, e);
			return null;
		}

	}

	@Override
	public Jugador ComprovarPropietari(Propietat propietat) {
		// TODO Auto-generated method stub
		return propietat.getJugador();
	}

	@Override
	public boolean Comprar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		if (propietat.getJugador() == null || propietat.isHipotecada()) {
			jugador.setDiners(jugador.getDiners() - propietat.getPreu());
			propietat.setJugador(jugador);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Hipotecar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		if (propietat.getJugador() == jugador && !propietat.isHipotecada()) {
			propietat.setHipotecada(true);
			jugador.setDiners(jugador.getDiners() + propietat.getPreuHipoteca());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Deshipotecar(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		if (propietat.getJugador() == jugador && propietat.isHipotecada()) {
			propietat.setHipotecada(false);
			jugador.setDiners(jugador.getDiners() - propietat.getPreuHipoteca());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int modificarDiners(Jugador jugador, int quantitat) {
		// TODO Auto-generated method stub
		jugador.setDiners(jugador.getDiners() + quantitat);
		return jugador.getDiners();
	}

	@Override
	public Propietat getPropietatenCasella(int posicio) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Propietat p = (Propietat) session.createQuery("SELECT * FROM propietat p WHERE p.posicio = "+posicio).uniqueResult();
		return p;
	}

	@Override
	public boolean PagarLloguer(Jugador jugador, Propietat propietat) {
		// TODO Auto-generated method stub
		return false;
	}

}
