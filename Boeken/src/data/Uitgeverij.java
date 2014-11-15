/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Lando Tanghe
 */
@Entity
@Table(name="UITGEVERIJEN")
public class Uitgeverij implements Serializable{
    private int id;
    private String naam;
    
    private Adres adres;
    private List<Boek> boeken=new ArrayList();

    /**
     *
     */
    public Uitgeverij() {
    }

    /**
     * de id is gekoppeld aan een adres,
     * daarom wordt de id-kolom hier ook
     * ADRES genoemd.
     * @return
     */
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    /**
     *
     * @param boek
     * @return
     */
    public boolean add(Boek boek){
        boolean succes = boeken.add(boek);
        boek.setUitgeverij(this);
        return succes;
    }

    /**
     * de id is gekoppeld aan een adres,
     * daarom wordt de id-kolom hier ook
     * ADRES genoemd.
     * @return
     */
    @OneToOne()
    @MapsId
    @JoinColumn(name = "ADRES")
    public Adres getAdres() {
        return adres;
    }

    /**
     *
     * @param adres
     */
    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @OneToMany(mappedBy = "uitgeverij")
    private List<Boek> getBoeken() {
        return boeken;
    }

    private void setBoeken(List<Boek> boeken) {
        this.boeken = boeken;
    }
    
    public String toString(){
            String s= getNaam()+"\n"+
                getAdres()+"\n";
            for(Boek boek:getBoeken()){
                s+="\t"+boek+"\n";
            }
            return s;
    }
        
    public Iterator<Boek> getBoekIterator(){
        return boeken.iterator();
    }
    
}
