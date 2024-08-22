package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpa.music.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainQuery {
    public static void main(String[] args) {
        List<Tuple> artists = null;
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev.lpa.music");
            EntityManager em = emf.createEntityManager();){
            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistJPQL(em, "%Stev%");
            artists.forEach(System.out::println);

            Stream<Tuple> names = getArtistName(em, "%Greatist%");
            // we can get element from the tuple by using index, or name
            // and specific class
            names.map(e -> new Artist(
                    e.get("id", Integer.class),
                    e.get("name", String.class)));
            System.out.println("-".repeat(40));
            Stream<Artist> sartists = getArtistBuilder(em, "");
            var map = sartists.limit(10)
                            .collect(Collectors.toMap(Artist::getArtistName,
                                    (a) -> a.getArtistName()));
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

    private static Stream<Tuple> getArtistName(EntityManager em, String matchedValue){
        // Select base on entity class, not table
        String jpql = "SELECT a.artistId as id, a.artistName as name from Artist a "
                + "WHERE a.artistName LIKE ?1";
        var query = em.createQuery(jpql, Tuple.class);
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }

    private static Stream<Artist> getArtistBuilder(EntityManager em, String matchedValue){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
        // root like the "FROM" in SQL
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root)
                .where(builder.like(root.get("artistName"), matchedValue))
                .orderBy(builder.asc(root.get("artistName")));
        return em.createQuery(criteriaQuery).getResultStream();
    }

    private static Stream<Artist> getArtistsSQL(EntityManager em, String matchedValue){
        var query = em.createNativeQuery(
                "SELECT * FROM music.artist WHERE artist_name like ?1", Artist.class);
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }
}
