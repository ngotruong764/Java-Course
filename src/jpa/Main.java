package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jpa.music.Artist;

public class Main {
    public static void main(String[] args) {
        try (
                // this method create a persistent context that establishes database connections,
                // and manage connection pool for efficient resource usage.
                var sessionFactory =
                        Persistence.createEntityManagerFactory("dev.lpa.music");
                // Once we have the factory class, we can get an EntityManager from that object
                EntityManager entityManager = sessionFactory.createEntityManager()) {
            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 208);
            // this will save new name directly to the database
            artist.setArtistName("John");
//            entityManager.persist(new Artist("John"));
//            entityManager.remove(artist);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
