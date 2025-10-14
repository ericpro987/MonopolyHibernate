package DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Classes.Carrer;
import Classes.CompanyiaServeis;
import Classes.Ferrocarril;
import Classes.Fitxa;
import Classes.Jugador;
import Classes.Partida;
import Classes.Propietat;

public class PartidaDAO implements IPartidaDAO{

	protected SessionFactory sessionFactory;

	public PartidaDAO() {
		// crides a la sessionFactory desde el singleton
		sessionFactory = SessionManager.getSessionFactory();

	}
	@Override
	public void SaveOrUpdate(Partida entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Partida entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Partida> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partida get(Integer id) {
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
		return false;
	}

	@Override
	public Jugador Reassignar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Partida p = new Partida();
		p.setDataInici(new Date());
		Jugador j1 = new Jugador();
		j1.setNom("Jugador1");
		j1.setViu(true);
		j1.getPartides().add(p);
		p.getJugadors().add(j1);
		Fitxa f1 = new Fitxa();
		f1.setPosicio(0);
		f1.setJugador(j1);
		Jugador j2 = new Jugador();
		j2.setNom("Jugador2");
		j2.setViu(true);
		j2.getPartides().add(p);
		p.getJugadors().add(j2);
		Fitxa f2 = new Fitxa();
		f2.setPosicio(0);
		f2.setJugador(j2);
		Jugador j3 = new Jugador();
		j3.setNom("Jugador3");
		j3.setViu(true);
		j3.getPartides().add(p);
		p.getJugadors().add(j3);
		Fitxa f3 = new Fitxa();
		f3.setPosicio(0);
		f3.setJugador(j3);
		List<Jugador> list = new ArrayList<Jugador>();
		list.add(j1);
		list.add(j2);
		list.add(j3);
		Collections.shuffle(list);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setOrdre(i+1);
			list.get(i).setDiners(1500);
		}
		session.persist(p);
		session.persist(j1);
		session.persist(j2);
		session.persist(j3);
		session.persist(f1);
		session.persist(f2);
		session.persist(f3);
		session.getTransaction().commit();
	}
	public static int dau = 0;
	@Override
	public void Roll(Jugador jugador) {
		// TODO Auto-generated method stub
		Random r = new Random();
		dau = r.nextInt(1,7);
		jugador.getFitxa().setPosicio(jugador.getFitxa().getPosicio()+dau);
		if(40-jugador.getFitxa().getPosicio()<= 0) {
			jugador.setDiners(jugador.getDiners()+200);
			jugador.getFitxa().setPosicio(jugador.getFitxa().getPosicio()%40);
		}
		GenericDAO gDAO = new GenericDAO();
		Propietat p = gDAO.getPropietatenCasella(jugador.getFitxa().getPosicio());
		if(p.getJugador()==null) {
			int comprar = r.nextInt(0,2);
			if(comprar == 0) {
				if(jugador.getDiners()>=p.getPreu()) {
					gDAO.Comprar(jugador, p);
				}
			}else {
				
			}
		}else if(p.getJugador() == jugador) {
			if(p instanceof Ferrocarril) {
				int ferro = r.nextInt(0,2);
				FerrocarrilDAO fDAO = new FerrocarrilDAO();
				if(ferro == 0)
					fDAO.transportFerrocarril(jugador, ((Ferrocarril) p).getAntFerro());
				else
					fDAO.transportFerrocarril(jugador, ((Ferrocarril) p).getSeguentFerro());
			}
		}else if(p instanceof Carrer){
			CarrerDAO c = new CarrerDAO();
			c.PagarLloguer(jugador, p);
		}else if(p instanceof Ferrocarril){
			FerrocarrilDAO fDAO = new FerrocarrilDAO();
			fDAO.PagarLloguer(jugador, p);
		}else if(p instanceof CompanyiaServeis){
			CompanyiaServeisDAO csDAO = new CompanyiaServeisDAO();
			csDAO.PagarLloguer(jugador, p);
		}
	}

	@Override
	public void PassarTorn() {
		// TODO Auto-generated method stub
		
	}

}
