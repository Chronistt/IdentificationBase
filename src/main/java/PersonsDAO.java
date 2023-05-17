
import java.util.Collection;

public interface PersonsDAO {
    Collection<Persons>getAllUsers();
    Persons getUsersById(int id);
    void createUsers (Persons persons);
    void updateUsers(Persons persons);

    void deleteUsers(int id);
}