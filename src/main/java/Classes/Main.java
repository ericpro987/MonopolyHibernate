package Classes;

import java.util.List;

import DAO.CarrerDAO;
import DAO.CompanyiaServeisDAO;
import DAO.FerrocarrilDAO;
import DAO.JugadorDAO;
import DAO.PartidaDAO;
import DAO.PropietatDAO;

/**
 * Classe Main de demostració del projecte Monopoly
 * Prova totes les funcionalitats d'Hibernate sense Spring
 * 
 * @author Institut Sabadell - DAM
 */
public class Main {

    private static PartidaDAO partidaDAO;
    private static JugadorDAO jugadorDAO;
    private static PropietatDAO propietatDAO;
    private static CarrerDAO carrerDAO;
    private static FerrocarrilDAO ferrocarrilDAO;
    private static CompanyiaServeisDAO companyiaDAO;
    //private static ColorDAO colorDAO;
    
    public static void main(String[] args) {
        
        System.out.println("=== MONOPOLY - HIBERNATE DEMO ===\n");
        
        // Inicialitzar DAOs
        inicialitzarDAOs();
        
        try {
            // 1. INICIAR PARTIDA
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  1. INICIAR PARTIDA                    ║");
            System.out.println("╚════════════════════════════════════════╝");
            partidaDAO.Start();
            System.out.println("✓ Partida creada amb jugadors i propietats\n");
            
            // Obtenir la partida activa
            Partida partida = partidaDAO.getPartidaActiva();
            List<Jugador> jugadors = jugadorDAO.getJugadorsByPartida(partida.getId());
            
            System.out.println("Jugadors creats:");
            for (Jugador j : jugadors) {
                System.out.println("  - " + j.getNom() + " (Fitxa: " + j.getFitxa().getColor() + 
                                   ", Diners: " + j.getDiners() + "€)");
            }
            System.out.println();
            
            // 2. MOSTRAR PROPIETATS DISPONIBLES
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  2. PROPIETATS DEL TAULELL             ║");
            System.out.println("╚════════════════════════════════════════╝");
            mostrarPropietats();
            
            // 3. COMPRAR PROPIETATS
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  3. COMPRAR PROPIETATS                 ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarCompres(jugadors);
            
            // 4. CONSULTAR PROPIETATS D'UN JUGADOR
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  4. PROPIETATS DEL JUGADOR 1           ║");
            System.out.println("╚════════════════════════════════════════╝");
            List<Propietat> propietatsJugador1 = propietatDAO.getPropietatsByJugador(jugadors.get(0).getId());
            System.out.println(jugadors.get(0).getNom() + " té " + propietatsJugador1.size() + " propietats:");
            for (Propietat p : propietatsJugador1) {
                System.out.println("  - " + p.getNom() + " (Posició: " + p.getPosicio() + ")");
            }
            System.out.println();
            
            // 5. COMPROVAR COLOR COMPLET I EDIFICAR
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  5. EDIFICAR EN CARRERS                ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarEdificacio(jugadors.get(0));
            
            // 6. CALCULAR LLOGUER DE CARRERS
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  6. CÀLCUL DE LLOGUER (CARRERS)        ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarLloguerCarrers();
            
            // 7. FERROCARRILS I VEÏNS
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  7. FERROCARRILS I VEÏNS               ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarFerrocarrils(jugadors.get(1));
            
            // 8. COMPANYIES DE SERVEIS
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  8. COMPANYIES DE SERVEIS              ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarCompanyies(jugadors.get(0));
            
            // 9. HIPOTECAR I DESHIPOTECAR
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  9. HIPOTEQUES                         ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarHipoteques(jugadors.get(0));
            
            // 10. PAGAR LLOGUER
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  10. PAGAR LLOGUER                     ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarPagamentLloguer(jugadors.get(0), jugadors.get(1));
            
            // 11. MODIFICAR DINERS
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  11. MODIFICAR DINERS                  ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarModificarDiners(jugadors.get(0));
            
            // 12. TIRAR DAUS I MOURE
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  12. TIRAR DAUS I MOURE                ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarTiradaDaus(jugadors.get(0));
            
            // 13. TRANSPORT EN FERROCARRIL
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  13. TRANSPORT FERROCARRIL             ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarTransportFerrocarril(jugadors.get(1));
            
            // 14. VENDRE CASES
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  14. VENDRE CASES                      ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarVendreCases(jugadors.get(0));
            
            // 15. REASSIGNAR (BANCARROTA)
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  15. GESTIÓ DE BANCARROTA              ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarBancarrota(jugadors.get(1));
            
            // 16. PASSAR TORN
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  16. PASSAR TORN                       ║");
            System.out.println("╚════════════════════════════════════════╝");
            provarPassarTorn();
            
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║  ✓ TOTES LES PROVES COMPLETADES        ║");
            System.out.println("╚════════════════════════════════════════╝");
            
        } catch (Exception e) {
            System.err.println("❌ Error durant l'execució: " + e.getMessage());
            e.printStackTrace();
        } finally {
            //HibernateUtil.shutdown();
        }
    }
    
    private static void inicialitzarDAOs() {
        partidaDAO = new PartidaDAO();
        jugadorDAO = new JugadorDAO();
        propietatDAO = new PropietatDAO();
        carrerDAO = new CarrerDAO();
        ferrocarrilDAO = new FerrocarrilDAO();
        companyiaDAO = new CompanyiaServeisDAO();
        //olorDAO = new ColorDAO();
    }
    
    private static void mostrarPropietats() {
        List<Carrer> carrers = carrerDAO.findAll();
        System.out.println("Carrers disponibles: " + carrers.size());
        
        List<Ferrocarril> ferrocarrils = ferrocarrilDAO.findAll();
        System.out.println("Ferrocarrils disponibles: " + ferrocarrils.size());
        
        List<CompanyiaServeis> companyies = companyiaDAO.findAll();
        System.out.println("Companyies disponibles: " + companyies.size());
        System.out.println();
    }
    
    private static void provarCompres(List<Jugador> jugadors) {
        Jugador jugador1 = jugadors.get(0);
        Jugador jugador2 = jugadors.get(1);
        
        // Jugador 1 compra propietats del color MARRÓ
        List<Carrer> carrersMarrons = carrerDAO.GetCarrerByColor("MARRÓ");
        for (Carrer carrer : carrersMarrons) {
            boolean comprat = propietatDAO.Comprar(jugador1, carrer);
            System.out.println((comprat ? "✓" : "✗") + " " + jugador1.getNom() + 
                               " compra " + carrer.getNom() + " (" + carrer.getPreu() + "€)");
        }
        
        // Jugador 2 compra alguns ferrocarrils
        List<Ferrocarril> ferrocarrils = ferrocarrilDAO.findAll();
        for (int i = 0; i < Math.min(2, ferrocarrils.size()); i++) {
            boolean comprat = propietatDAO.Comprar(jugador2, ferrocarrils.get(i));
            System.out.println((comprat ? "✓" : "✗") + " " + jugador2.getNom() + 
                               " compra " + ferrocarrils.get(i).getNom());
        }
        
        // Jugador 1 compra una companyia
        List<CompanyiaServeis> companyies = companyiaDAO.findAll();
        if (!companyies.isEmpty()) {
            boolean comprat = propietatDAO.Comprar(jugador1, companyies.get(0));
            System.out.println((comprat ? "✓" : "✗") + " " + jugador1.getNom() + 
                               " compra " + companyies.get(0).getNom());
        }
        System.out.println();
    }
    
    private static void provarEdificacio(Jugador jugador) {
        List<Propietat> propietats = propietatDAO.getPropietatsByJugador(jugador.getId());
        
        for (Propietat p : propietats) {
            if (p instanceof Carrer) {
                Carrer carrer = (Carrer) p;
                boolean colorComplet = carrerDAO.ComprovarColorComplet(carrer);
                System.out.println("Carrer " + carrer.getNom() + " - Color complet? " + 
                                   (colorComplet ? "SÍ" : "NO"));
                
                if (colorComplet) {
                    // Intentar edificar
                    int cases = carrerDAO.edificar(jugador, carrer);
                    if (cases > 0) {
                        System.out.println("  ✓ Edificat! Ara hi ha " + cases + " case(s)");
                    } else {
                        System.out.println("  ✗ No s'ha pogut edificar");
                    }
                }
            }
        }
        System.out.println();
    }
    
    private static void provarLloguerCarrers() {
        List<Carrer> carrers = carrerDAO.findAll();
        
        for (int i = 0; i < Math.min(3, carrers.size()); i++) {
            Carrer carrer = carrers.get(i);
            if (carrer.getJugador() != null) {
                int lloguer = carrerDAO.calcularLloguerCarrer(carrer);
                System.out.println(carrer.getNom() + " - Lloguer: " + lloguer + "€ " +
                                   "(Cases: " + carrer.getNombreCases() + ")");
            }
        }
        System.out.println();
    }
    
    private static void provarFerrocarrils(Jugador jugador) {
        List<Ferrocarril> ferrocarrils = ferrocarrilDAO.findAll();
        
        if (ferrocarrils.size() >= 2) {
            Ferrocarril f1 = ferrocarrils.get(0);
            Ferrocarril f2 = ferrocarrils.get(1);
            Ferrocarril f3 = ferrocarrils.get(2);
            Ferrocarril f4 = ferrocarrils.get(3);
            // Fer-los veïns
            ferrocarrilDAO.afegirVeins(f1, f2, f3, f4);
            System.out.println("✓ " + f1.getNom() + " i " + f2.getNom() + " ara són veïns");
            
            // Comprovar si són veïns
            boolean sonVeins = ferrocarrilDAO.isFerrocarrilVei(f1, f2);
            System.out.println("Són veïns? " + (sonVeins ? "SÍ" : "NO"));
            
            // Obtenir llista de veïns
            List<Ferrocarril> veinsF1 = ferrocarrilDAO.ferrocarrilsVeins(f1);
            System.out.println(f1.getNom() + " té " + veinsF1.size() + " veí(ns):");
            for (Ferrocarril vei : veinsF1) {
                System.out.println("  - " + vei.getNom());
            }
            
            // Calcular lloguer segons quantitat de ferrocarrils
            if (f1.getJugador() != null) {
                int lloguer = ferrocarrilDAO.calcularLloguerFerrocarril(f1);
                System.out.println("Lloguer de " + f1.getNom() + ": " + lloguer + "€");
            }
        }
        System.out.println();
    }
    
    private static void provarCompanyies(Jugador jugador) {
        List<CompanyiaServeis> companyies = companyiaDAO.findAll();
        
        // Simular tirada de daus
        int resultatDaus = 7;
        
        for (CompanyiaServeis companyia : companyies) {
            if (companyia.getJugador() != null) {
                int lloguer = companyiaDAO.calcularLloguerCompanyia(companyia, resultatDaus);
                System.out.println(companyia.getNom() + " - Lloguer amb daus=" + 
                                   resultatDaus + ": " + lloguer + "€");
            }
        }
        System.out.println();
    }
    
    private static void provarHipoteques(Jugador jugador) {
        List<Propietat> propietats = propietatDAO.getPropietatsByJugador(jugador.getId());
        
        if (!propietats.isEmpty()) {
            Propietat propietat = propietats.get(0);
            int dinersAntes = jugador.getDiners();
            
            // Hipotecar
            boolean hipotecada = propietatDAO.Hipotecar(jugador, propietat);
            System.out.println((hipotecada ? "✓" : "✗") + " Hipoteca de " + propietat.getNom());
            if (hipotecada) {
                System.out.println("  Diners abans: " + dinersAntes + "€");
                System.out.println("  Diners després: " + jugador.getDiners() + "€");
                System.out.println("  Guany: " + propietat.getPreuHipoteca() + "€");
            }
            
            // Deshipotecar
            boolean deshipotecada = propietatDAO.Deshipotecar(jugador, propietat);
            System.out.println((deshipotecada ? "✓" : "✗") + " Deshipoteca de " + propietat.getNom());
            if (deshipotecada) {
                System.out.println("  Diners finals: " + jugador.getDiners() + "€");
            }
        }
        System.out.println();
    }
    
    private static void provarPagamentLloguer(Jugador pagador, Jugador propietari) {
        // Buscar una propietat del propietari
        List<Propietat> propietats = propietatDAO.getPropietatsByJugador(propietari.getId());
        
        if (!propietats.isEmpty()) {
            Propietat propietat = propietats.get(0);
            
            int dinersPagadorAntes = pagador.getDiners();
            int dinersPropietariAntes = propietari.getDiners();
            
            boolean pagat = propietatDAO.PagarLloguer(pagador, propietat);
            
            System.out.println((pagat ? "✓" : "✗") + " " + pagador.getNom() + 
                               " paga lloguer a " + propietari.getNom());
            System.out.println("  Propietat: " + propietat.getNom());
            System.out.println("  " + pagador.getNom() + ": " + dinersPagadorAntes + 
                               "€ → " + pagador.getDiners() + "€");
            System.out.println("  " + propietari.getNom() + ": " + dinersPropietariAntes + 
                               "€ → " + propietari.getDiners() + "€");
        }
        System.out.println();
    }
    
    private static void provarModificarDiners(Jugador jugador) {
        int dinersAntes = jugador.getDiners();
        
        // Guanyar diners
        int dinersNous = jugadorDAO.ModificarDiners(jugador, 200);
        System.out.println("✓ " + jugador.getNom() + " guanya 200€");
        System.out.println("  Abans: " + dinersAntes + "€ → Després: " + dinersNous + "€");
        
        // Perdre diners
        dinersNous = jugadorDAO.ModificarDiners(jugador, -50);
        System.out.println("✓ " + jugador.getNom() + " perd 50€");
        System.out.println("  Ara té: " + dinersNous + "€");
        System.out.println();
    }
    
    private static void provarTiradaDaus(Jugador jugador) {
        int posicioAntes = jugador.getFitxa().getPosicio();
        int dinersAntes = jugador.getDiners();
        
        System.out.println(jugador.getNom() + " està a la casella " + posicioAntes);
        
        partidaDAO.Roll(jugador);
        
        int posicioDespres = jugador.getFitxa().getPosicio();
        int dinersDespres = jugador.getDiners();
        
        System.out.println("✓ Tirada de daus realitzada");
        System.out.println("  Nova posició: " + posicioDespres);
        
        if (dinersDespres > dinersAntes) {
            System.out.println("  ✓ Ha passat per SORTIDA! +" + (dinersDespres - dinersAntes) + "€");
        }
        
        // Comprovar si ha caigut en una propietat
        Propietat propietat = propietatDAO.getPropietatenCasella(posicioDespres);
        if (propietat != null) {
            System.out.println("  Ha caigut a: " + propietat.getNom());
            if (propietat.getJugador() == null) {
                System.out.println("  (Propietat disponible per comprar)");
            } else if (propietat.getJugador().getId() != jugador.getId()) {
                System.out.println("  (Propietat de " + propietat.getJugador().getNom() + ")");
            }
        }
        System.out.println();
    }
    
    private static void provarTransportFerrocarril(Jugador jugador) {
        List<Ferrocarril> ferrocarrils = ferrocarrilDAO.findAll();
        
        if (ferrocarrils.size() >= 2) {
            Ferrocarril origen = ferrocarrils.get(0);
            Ferrocarril desti = ferrocarrils.get(1);
            Ferrocarril origen2 = ferrocarrils.get(2);
            Ferrocarril desti2 = ferrocarrils.get(3);
            
            // Fer que siguin del jugador i veïns
            propietatDAO.Comprar(jugador, origen);
            propietatDAO.Comprar(jugador, desti);
            ferrocarrilDAO.afegirVeins(origen, desti, origen2, desti2);
            
            // Col·locar el jugador al ferrocarril origen
            jugador.getFitxa().setPosicio(origen.getPosicio());
            jugadorDAO.update(jugador);
            
            System.out.println(jugador.getNom() + " està a " + origen.getNom() + 
                               " (casella " + origen.getPosicio() + ")");
            
            boolean viatjat = ferrocarrilDAO.transportFerrocarril(jugador, desti);
            
            System.out.println((viatjat ? "✓" : "✗") + " Viatge a " + desti.getNom());
            if (viatjat) {
                System.out.println("  Nova posició: casella " + jugador.getFitxa().getPosicio());
            }
        }
        System.out.println();
    }
    
    private static void provarVendreCases(Jugador jugador) {
        List<Propietat> propietats = propietatDAO.getPropietatsByJugador(jugador.getId());
        
        for (Propietat p : propietats) {
            if (p instanceof Carrer) {
                Carrer carrer = (Carrer) p;
                if (carrer.getNombreCases() > 0) {
                    int dinersAntes = jugador.getDiners();
                    int casesAntes = carrer.getNombreCases();
                    
                    boolean venut = carrerDAO.vendreCases(jugador, carrer, 1);
                    
                    System.out.println((venut ? "✓" : "✗") + " Vendre 1 casa de " + carrer.getNom());
                    if (venut) {
                        System.out.println("  Cases: " + casesAntes + " → " + carrer.getNombreCases());
                        System.out.println("  Diners: " + dinersAntes + "€ → " + jugador.getDiners() + "€");
                    }
                    break; // Només provem amb un carrer
                }
            }
        }
        System.out.println();
    }
    
    private static void provarBancarrota(Jugador jugador) {
        // Posar el jugador en bancarrota
        jugadorDAO.ModificarDiners(jugador, -jugador.getDiners() - 100);
        
        System.out.println(jugador.getNom() + " té " + jugador.getDiners() + "€ (BANCARROTA!)");
        
        Jugador guanyador = partidaDAO.Reassignar();
        
        if (guanyador != null) {
            System.out.println("El jugador ha estat eliminat");
            System.out.println(" GUANYADOR: " + guanyador.getNom() + 
                               " (Victòries: " + guanyador.getVictories() + ")");
        } else {
            System.out.println("El jugador ha estat eliminat. La partida continua.");
        }
        System.out.println();
    }
    
    private static void provarPassarTorn() {
        Partida partida = partidaDAO.getPartidaActiva();
        List<Jugador> jugadors = jugadorDAO.getJugadorsByPartida(partida.getId());
        
        System.out.println("Ordre de joc actual:");
        for (Jugador j : jugadors) {
            if (j.isViu()) {
                System.out.println("  " + j.getOrdre() + ". " + j.getNom() + 
                                   (j.getId() == partidaDAO.getJugadorActiu().getId() ? " ← TORN ACTUAL" : ""));
            }
        }
        
        partidaDAO.PassarTorn();
        
        partida = partidaDAO.getPartidaActiva();
        System.out.println("\n✓ Torn passat. Ara juga: " + partidaDAO.getJugadorActiu().getNom());
        System.out.println();
    }
}