/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boeken;

import data.Adres;
import data.Auteur;
import data.Boek;
import data.Persoon;
import data.Uitgeverij;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author vongenae
 */
public final class Boeken {

    Random random;

    
    private Boeken() {
        random = new Random();
        
        BoekenDao dao = new BoekenDao();
        dao.open();
        
        //1  Eén persoon toevoegen. Als je een persoon bewaart, dan wordt ook zijn adres bewaard.
        dao.addPersoon(maakPersoon());
        
        //2  Een verzameling van personen toevoegen.
        dao.addPersonen(maakPersonen());
        
        //3  Een verzameling van auteurs toevoegen. Hoe kan je hierbij de vorige methode hergebruiken? gemeenschappelijke private methode die een iterator gebruikt
        dao.addAuteurs(maakAuteurs());
        
        //4  Eén uitgeverij met bijhorend adres toevoegen.
        Uitgeverij uitgeverij=maakUitgeverij();
        Adres adres = maakAdres();
        uitgeverij.setAdres(adres);
        dao.addUitgeverij(uitgeverij);
        
        //5  Een lijst van uitgeverijen opvragen. Test deze methode uit in een testprogramma. 
        //Welke eigenschappen kan je gebruiken of uitschrijven in je testprogramma? 
        //Waarom zijn sommige eigenschappen niet ingevuld en geven ze een foutmelding?
        dao.close();
        dao.open();
        System.out.println("Uitgeverijen:");
        List<Uitgeverij> uitgeverijen = dao.getUitgeverijen();
        for(Uitgeverij u:uitgeverijen){
            System.out.println(u);
            System.out.println("");
        }
        
        //6 Zorg ervoor dat de gebruiker enkel eigenschappen kan oproepen die automatisch geladen worden en dat hij geen eigenschappen kan 
        //  aanpassen, m.a.w. beperk de interface van de teruggegeven objecten. Gebruik hiervoor refactoring.
        
        //7  Een lijst van auteurs opvragen. Ook hier zorg je ervoor dat de gebruiker enkel de beschikbare eigenschappen kan oproepen.
     /*   System.out.println("Auteurs:");
        List<Auteur> auteurs = dao.getAuteurs();
        for(Auteur aut: auteurs){
            System.out.println(aut);
        }
        
        //8  Eén boek met bijhorende auteurs toevoegen. Je mag hierbij veronderstellen dat geen enkele auteur reeds ingegeven is in de databank.
        Boek boek = maakBoek();
        for (Auteur schrijver : maakAuteurs()) {
            schrijver.add(boek);
        }
        dao.addBoekAndAuthors(boek);
       */ 
        //9  Eén boek toevoegen. In dit geval heeft het boek één auteur waarvan de unieke identificatie wordt meegegeven aan de methode.
        //int id=auteurs.get(0).getId();
        
        //10 Een lijst van boeken van één uitgeverij, gekenmerkt door zijn naam, ophalen. Voor een boek zijn ook al zijn auteurs en de uitgeverij gekend.
        
        //11 Een lijst van boeken waarvan de naam van één van de auteurs een opgegeven naam is. Gebruik hiervoor een SQLQuery (Meer info). Test eerst de select-opdracht uit in een "SQL Command" en voeg hem dan pas toe aan je javacode.
        
        dao.close();
        System.out.println("closed");
        System.exit(0);
    }
    

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boeken b = new Boeken();
        System.out.println("ended");
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
        String[] namen = {"De eenhoorn", "De bezige bij", "Lannoo", "O'reilly","Dupuis"};
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

    private Iterable<Persoon> maakPersonen() {
        int aantal = 1 + random.nextInt(5);
        ArrayList<Persoon> personen = new ArrayList<>();
        for(int i=0;i<aantal;i++){
            personen.add(maakPersoon());
        }
        return personen;
    }

    private Uitgeverij maakUitgeverij() {
        Uitgeverij uitgeverij = new Uitgeverij();
        int i=random.nextInt(namenUitgeverijen().length);
        uitgeverij.setNaam(namenUitgeverijen()[i]);
        
        
        return uitgeverij;
    }

    private Boek maakBoek(){
        Boek boek=new Boek();
        String isbn="";
        for(int i=0;i<10;i++){
            isbn+= random.nextInt(10);
        }
        boek.setIsbn(isbn);
        boek.setTitel(maakTitel());
        return boek;
    }
}
