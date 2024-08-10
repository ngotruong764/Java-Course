package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jpa.music.Artist;

public class Main {
    public static void main(String[] args) {
        try(var sessionFactory = Persistence.createEntityManagerFactory("dev.lpa.music");
                EntityManager entityManager = sessionFactory.createEntityManager()){
            var tranction = entityManager.getTransaction();
            tranction.begin();
            entityManager.persist(new Artist("Muddy Water"));
            tranction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
