/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lando Tanghe
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="MENSEN")
@DiscriminatorColumn(name = "ROL")
public class Persoon implements Serializable{
    private int id;
    private String rijksregisternummer;
    private String naam;
    private String voornaam;
    
    private Adres adres;

    public Persoon(String rijksregisternummer, String naam, String voornaam, Adres adres) {
        this.rijksregisternummer = rijksregisternummer;
        this.naam = naam;
        this.voornaam = voornaam;
        this.adres = adres;
    }

    public Persoon(){
        
    }


    @Id
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getRijksregisternummer() {
        return rijksregisternummer;
    }

    private void setRijksregisternummer(String rijksregisternummer) {
        this.rijksregisternummer = rijksregisternummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    
    @OneToOne
    @MapsId
    @JoinColumn(name="ADRES")
    public Adres getAdres(){
        return adres;
    }
    
    public void setAdres(Adres adres){
        this.adres=adres;
    }
    
}
