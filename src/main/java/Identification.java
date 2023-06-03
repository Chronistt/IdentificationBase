import java.util.Collection;
import java.util.Scanner;

public class Identification {
    private static Scanner scanner = new Scanner(System.in);
    private static PersonsDAOImpl personsDAO = new PersonsDAOImpl();
    private static RoleDAOImpl roleDAO = new RoleDAOImpl();

    public static void main(String[] args) {

        System.out.println("==============DataBase Identification============");
        RoleType roleType = RoleType.ANALYST;
        Persons persons = new Persons("Петр Иванов","Ivanov","erok", roleType.ordinal());
        PersonsDAOImpl personsDAO1 = new PersonsDAOImpl();
        personsDAO1.createUsers(persons);

      /*  while (true) {
            try {
                printMenu();
                int i = scanner.nextInt();
                if (i == 1) {
                    createUsersRole();
                } else if (i == 2) {
                    System.out.println("+===========Введите id пользователя===========+\n");
                    int id = scanner.nextInt();
                    PersonsDAOImpl personWithRole = getUserWithRoles(id);
                    System.out.println(personWithRole);
                } else if (i == 3) {
                    System.out.println("+===========Введите номер роли пользователя===========+\n");
                    int roleId = scanner.nextInt();
                    RoleType role = RoleType.valueOf(roleId);
                    Collection<PersonsDAOImpl> personsRole = getUsersByRole(role);
                    System.out.println(personsRole);
                } else if (i == 4) {
                    System.out.println("+===========Введите id пользователя===========+\n");
                    int id = scanner.nextInt();
                    deleteUser(id);
                } else if (i == 5) {
                    Collection<PersonsDAOImpl> personsNoRole = getAllUsersNoRole();
                    System.out.println(personsNoRole);
                } else if (i == 6) {
                    updateUser(personsDAO);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("НЕВЕРНЫЙ ВВОД");
                scanner.nextLine();
                 }

        }*/
    }

    private static void printMenu() {
        System.out.println("1 - Добавлять нового пользователя в БД;");
        System.out.println("2 - Получать определенного пользователя (с его ролями) из БД;");
        System.out.println("3 - Получать список пользователей по определенной роли;");
        System.out.println("4 - Удалять пользователя из БД;");
        System.out.println("5 - Получать список пользователей из БД без ролей;");
        System.out.println("6 - Редактировать существующего пользователя в БД.");

    }

    //    1 Добавлять нового пользователя с ролями в БД;

    private static void createUsersRole() {
        System.out.println("+===Создать пользователя===+\n");

        System.out.println("Имя пользователя\n");
        String name = scanner.nextLine();

        System.out.println("Login пользователя\n");
        String login = scanner.toString();

        System.out.println("Password пользователя\n");
        String password = scanner.toString();

        System.out.println("Роль пользователя\n");
        int i = 1;
        for (RoleType element : RoleType.values()) {
            System.out.println(element.getRoleType());
            i++;
        }
        RoleType roleType = RoleType.valueOf(Integer.valueOf(scanner.nextLine()));
        Persons persons = new Persons(name,login,password, roleType.ordinal());
        System.out.println(name+""+login+""+password);
    }


    //    2 Получать конкретного пользователя (с его ролями) из БД;
    private static PersonsDAOImpl getUserWithRoles(int id) {
        personsDAO.getUsersById(id);
        return personsDAO;
    }
//    3 Получать список пользователей по конкретной роли;

    private static Collection<PersonsDAOImpl> getUsersByRole(RoleType role) {
        return null;
    }

    //    4 Удалять пользователя в БД;
    private static void deleteUser (int id) {

        personsDAO.deleteUsers(id);
        }

    //    5 Получать список пользователей из БД (без ролей);
    private static Collection<PersonsDAOImpl> getAllUsersNoRole() {
        Collection<PersonsDAOImpl> personsList = personsDAO.getAllUsers();

        return personsList;
    }
    //    6 Редактировать существующего пользователя в БД.

    private static void updateUser(PersonsDAO personsDAO) {
        Scanner scanner = null;
        System.out.println("Id пользователя");
        int id = scanner.nextInt();

        System.out.println("Имя пльзователя\n");
        String name = scanner.nextLine();

        System.out.println("Login пльзователя\n");
        String login = scanner.nextLine();

        System.out.println("Password пльзователя\n");
        String password = scanner.nextLine();

        personsDAO.updateUsers(new Persons(name,login,password, id));

    }

}


