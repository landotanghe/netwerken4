/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lando Tanghe
 */
@Entity
@Table(name="AUTEURS")
@PrimaryKeyJoinColumn(name="ID")
public class Auteur extends Persoon implements Serializable{
    private String bibliografie;

    public Auteur() {
    }

    public Auteur(String rijksregisternummer, String naam, String voornaam, Adres adres) {
        super(rijksregisternummer,naam,voornaam,adres);
    }

    public String getBibliografie() {
        return bibliografie;
    }

    public void setBibliografie(String bibliografie) {
        this.bibliografie = bibliografie;
    }
    
    public boolean add(Boek boek){
        return false;
    }
}
