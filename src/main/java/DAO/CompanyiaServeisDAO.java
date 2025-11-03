package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Classes.CompanyiaServeis;
import Classes.Ferrocarril;
import Classes.Jugador;
import Classes.Propietat;

public class CompanyiaServeisDAO implements ICompanyiaServeisDAO{

	protected SessionFactory sessionFactory;

	public CompanyiaServeisDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}
	
	@Override
	public void SaveOrUpdate(CompanyiaServeis entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CompanyiaServeis entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyiaServeis> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<CompanyiaServeis> list = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e").list();
			return list;
		} catch (Exception e) {

		} finally {
			session.getTransaction().commit();
			session.close();

		}
		return null;
	}

	private Class<CompanyiaServeis> getEntityClass() {
		// TODO Auto-generated method stub
		return CompanyiaServeis.class;
	}

	@Override
	public CompanyiaServeis get(Integer id) {
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
		jugador.setDiners(jugador.getDiners()-calcularLloguerCompanyia(((CompanyiaServeis) propietat), PartidaDAO.dau));
		return true;
	}

	@Override
	public int calcularLloguerCompanyia(CompanyiaServeis companyia, int resultatDaus) {
		// TODO Auto-generated method stub
		Jugador propietari = companyia.getJugador();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Ferrocarril> query =  session.createQuery("select * from propietat p where p.tipusPropietat = Companyia and p.jugador_id = :id");
		query.setParameter("id", propietari.getId());
		int lloguer = 0;
		if(query.list().size()>1) {
			lloguer = resultatDaus*10;
		}else {
			lloguer = resultatDaus*4;
		}

		return lloguer;
	}

}
