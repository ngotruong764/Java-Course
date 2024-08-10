package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jpa.music.Artist;

import java.util.List;

public class MainQuery {
    public static void main(String[] args) {
        List<Tuple> artists = null;
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev.lpa.music");
            EntityManager em = emf.createEntityManager();){
            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistJPQL(em, "");
            artists.forEach(System.out::println);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static List<Tuple> getArtistJPQL(EntityManager em, String matchedValue){
        // Select base on entity class, not table
        String jpql = "SELECT a.artistId, a.artistName from Artist a "
                + "WHERE a.artistName LIKE ?1";
        var query = em.createQuery(jpql, Tuple.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();
    }
}
