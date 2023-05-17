
import java.util.Collection;

public interface PersonsDAO {
    Collection<PersonsDAOImpl> getAllUsers();
    Persons getUsersById(int id);
    void createUsers (Persons persons);
    void updateUsers(Persons persons);

    void deleteUsers(int id);
}