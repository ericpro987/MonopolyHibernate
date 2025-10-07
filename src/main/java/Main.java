import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {

	private static Session session;

	static SessionFactory sessionFactory;

	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// Crea el registre de serveis utilitzant el fitxer hibernate.cfg.xml
			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Partida p = new Partida();
		p.setDataInici(new Date());
		Jugador j1 = new Jugador();
		j1.setNom("Light");
		j1.getPartides().add(p);
		p.getJugadors().add(j1);
		Jugador j2 = new Jugador();
		j2.setNom("Lelouch");
		j2.getPartides().add(p);
		p.getJugadors().add(j2);
		session.persist(p);
		session.persist(j1);
		session.persist(j2);
		Ferrocarril f1 = new Ferrocarril();
		Ferrocarril f2 = new Ferrocarril();
		Ferrocarril f3 = new Ferrocarril();
		Ferrocarril f4 = new Ferrocarril();
		f1.seguentFerro = f2;
		f1.antFerro = f4;
		f2.antFerro = f1;
		f2.seguentFerro = f3;
		f3.antFerro = f2;
		f3.seguentFerro = f4;
		f4.antFerro = f3;
		f4.seguentFerro = f1;
		session.persist(f1);
		session.persist(f2);
		session.persist(f3);
		session.persist(f4);
		session.getTransaction().commit();
	}

	private void Inici() {
			session.getTransaction().begin();
			Color color = new Color();
		for (int i = 0; i < 39; i++) {

			if (i < 22) {
				Carrer carrer = new Carrer();
				if (i < 2) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("marro")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 5) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("blau claret")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 8) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("rosa")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 11) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("taronja")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 14) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("vermell")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 17) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("groc")) {
							carrer.setColor(c);
						}
					}
				} else if (i < 20) {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("verd")) {
							carrer.setColor(c);
						}
					}
				} else {
					for (Color c : ((Set<Color>) session.createQuery("from color").list())) {
						if (c.nom.equals("blau fosc")) {
							carrer.setColor(c);
						}
					}
				}
				session.persist(carrer);
			}
			if(i < 26) {
				Ferrocarril ferro = new Ferrocarril();
				session.persist(ferro);
			}
			if(i < 28) {
				CompanyiaServeis comp = new CompanyiaServeis();
				if(i == 26) {
					comp.setTipusServei(TipusServei.ELECTRICITAT);
				}else {
					comp.setTipusServei(TipusServei.AIGUA);
				}
			}
		}	
		session.getTransaction().commit();
	}
}
