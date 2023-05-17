import javax.persistence.*;
import java.util.Collection;


public class PersonsDAOImpl implements PersonsDAO {

    private final String user = "postgres";
    private final String password = "dom881738";
    private final String url = "jdbc:postgresql://localhost:5432/persons";

    @Override
    public Collection<Persons> getAllUsers() {
        EntityManager entityManager = startEntityManager();
        Query query = entityManager.createNativeQuery("SELECT*FROM person", Persons.class);
        return query.getResultList();
    }

    @Override
    public Persons getUsersById(int id) {
        EntityManager entityManager = startEntityManager();
        Persons persons = entityManager.find(Persons.class, id);
        return persons;
    }

    @Override
    public void createUsers(Persons persons) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUsers(Persons persons) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(persons);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUsers(int id) {
        Persons persons;
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        persons = startEntityManager().find(Persons.class,id);
        entityManager.remove(persons);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private static EntityManager startEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();

    }
}