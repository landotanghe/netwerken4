/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boeken;

import data.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Lando Tanghe
 */
public class BoekenDao {
    
    private SessionFactory factory;
    private Session sessie;
    
    /**
     *sets up the configuration
     */
    public BoekenDao(){
        //v4.3
        Configuration config=new Configuration();
        config.configure();
        ServiceRegistry reg =  new StandardServiceRegistryBuilder().applySettings(
            config.getProperties()).build();
        /*
        //school: v4.0 à v4.2
        ServiceRegistry reg =  new ServiceRegistryBuilder().applySettings(
            config.getProperties()).buildServiceRegistry();
        
        */
        factory = config.buildSessionFactory(reg);
    }
    
    /**
     *opens the session and begins transaction 
     */
    public void open(){
        sessie = factory.openSession();
        sessie.beginTransaction();
    }
    
    /**
     *commmits your changes and closes the connection
     */
    public void close(){
        sessie.getTransaction().commit();
        sessie.close();
    }
    
    /**
     *
     * @param persoon
     */
    public void addPersoon(Persoon persoon){
        sessie.save(persoon);
    }
    
    private void addWithIterator(Iterator it){
        while(it.hasNext()){
            sessie.save(it.next());
        }
    }
    
    /**
     *
     * @param personen
     */
    public void addPersonen(Iterable<Persoon> personen){
        addWithIterator(personen.iterator());
    }
    
    /**
     *
     * @param auteurs
     */
    public void addAuteurs(Iterable<Auteur> auteurs){
        addWithIterator(auteurs.iterator());
    }
    
    /**
     *voegt uitgeverij toe, inclusief bijhorend adres
     * @param uitgeverij
     * @param adres
     */
    public void addUitgeverij(Uitgeverij uitgeverij){
        sessie.save(uitgeverij);
    }
    
    /**
     *
     * @return alle uitgeverijen
     */
    public List<Uitgeverij> getUitgeverijen(){
        return sessie.createQuery("from Uitgeverij").list();
    }
    
    
}
