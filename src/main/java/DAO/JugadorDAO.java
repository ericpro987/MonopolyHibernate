package DAO;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Classes.Carrer;
import Classes.Jugador;
import Classes.Partida;

public class JugadorDAO implements IJugadorDAO<Jugador, Integer> {
	
	protected SessionFactory sessionFactory;

	public JugadorDAO() {
		// TODO Auto-generated constructor stub
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}
	
	@Override
	public int ModificarDiners(Jugador jugador, int diners) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Jugador j) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(j);
		session.getTransaction().commit();
	}

	public List<Jugador> getJugadorsByPartida(int id) {
		// TODO Auto-generated method stub
		PartidaDAO pdao = new PartidaDAO();
		Partida partida = pdao.get(id);
		List<Jugador> allJugadors = this.findAll();
		List<Jugador> jugadors = new ArrayList<Jugador>();
		for (Jugador jugador : allJugadors) {
			if(jugador.getPartides().contains(partida))
				jugadors.add(jugador);
		}
		return jugadors;
	}

	@Override
	public void SaveOrUpdate(Jugador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Jugador entity) {
		// TODO Auto-generated method stub
		
	}
	private Class<Jugador> getEntityClass() {
		return (Class<Jugador>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	@Override
	public List<Jugador> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Jugador> list = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e").list();
			return list;
		} catch (HibernateException e) {

		} finally {
			session.getTransaction().commit();
			session.close();

		}
		return null;
	}

	@Override
	public Jugador get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
