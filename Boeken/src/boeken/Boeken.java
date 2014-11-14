/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boeken;

import data.Adres;
import data.Auteur;
import data.Persoon;
import data.Uitgeverij;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author vongenae
 */
public class Boeken {

    Random random;

    private Boeken() {
        random = new Random();
        
        Configuration config=new Configuration();
        config.configure();
        ServiceRegistry reg =  new ServiceRegistryBuilder().applySettings(
            config.getProperties()).buildServiceRegistry();
        SessionFactory factory = config.buildSessionFactory(reg);
        Session sessie = factory.openSession();
        sessie.beginTransaction();
        
        
        //testPersoon(sessie);
        //testAuteurs(sessie);
        testUitgeverij(sessie);
        
        sessie.getTransaction().commit();
        sessie.close();
    }
    
    private void testPersoon(Session sessie){
        sessie.save(maakPersoon());
    }

    private void testAuteurs(Session sessie) {
        Set<Auteur> auteurs = maakAuteurs();
        Iterator it = auteurs.iterator();
        while(it.hasNext()){
            sessie.save(it.next());
        }
    }
    
    private void testUitgeverij(Session sessie){
        Uitgeverij uit = new Uitgeverij();
        uit.setNaam(namenUitgeverijen()[random.nextInt(4)]);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Boeken();
    }

    private Adres maakAdres() {
        String[] straten = {"Sportstraat", "Dorpsplein", "Kerkstraat", "Schoolstraat"};
        String[] nummers = {"3", "347B", "32/78", "35"};
        int[] postcodes = {9000, 1000, 2000, 8500};
        String[] gemeentes = {"Gent", "Brussel", "Antwerpen", "Kortrijk"};
        int gemeente = random.nextInt(postcodes.length);
        Adres adres = new Adres();
        adres .setGemeente(gemeentes[gemeente]);
        adres .setHuisnummer(nummers[random.nextInt(nummers.length)]);
        adres .setPostcode(postcodes[gemeente]);
        adres.setStraat(straten[random.nextInt(straten.length)]);
        return adres;
    }

    private Persoon maakPersoon() {
        String[] voornamen = {"Els", "Koen", "Betty", "Diane", "Emmy", "Raf"};
        String[] namen = {"De Smedt", "Janssens", "De Moor", "Driesen", "Leemans", "Dierick"};
        Persoon persoon = new Persoon(Integer.toString(random.nextInt()),
                namen[random.nextInt(namen.length)],
                voornamen[random.nextInt(voornamen.length)],
                maakAdres());
        return persoon;
    }

    public Set<Auteur> maakAuteurs() {
        Set<Auteur> auteurs = new HashSet<>();

        int aantal = 1 + random.nextInt(5);
        for (int i = 0; i < aantal; i++) {
            Persoon persoon = maakPersoon();
            Auteur auteur = new Auteur(persoon.getRijksregisternummer(),
                    persoon.getNaam(),
                    persoon.getVoornaam(),
                    persoon.getAdres());
            auteur.setBibliografie(maakBibliografie());
            auteurs.add(auteur);
        }
        return auteurs;
    }

    private String maakBibliografie() {
        int aantal = 1 + random.nextInt(10);
        StringBuilder tekst = new StringBuilder("bla");
        for (int i = 0; i < aantal; i++) {
            tekst.append("bla");
        }
        return tekst.toString();
    }

    private String[] namenUitgeverijen() {
        String[] namen = {"De eenhoorn", "De bezige bij", "Lannoo", "O'reilly"};
        return namen;
    }


    private String maakTitel() {
        int aantal = 1 + random.nextInt(4);
        StringBuilder tekst = new StringBuilder("titel");
        for (int i = 0; i < aantal; i++) {
            tekst.append(" woord");
        }
        return tekst.toString();
    }

}
