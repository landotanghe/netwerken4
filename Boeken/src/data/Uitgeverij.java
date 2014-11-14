/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
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

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    public boolean add(Boek boek){
        return false;
    }
}
