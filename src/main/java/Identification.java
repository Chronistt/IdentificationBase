import java.util.Collection;
import java.util.Scanner;

public class Identification {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("==============DataBase Identification============");

        while (true) {
            try {
                printMenu();
                int i = scanner.nextInt();
                if (i == 1) {
                    createUsersRole();
                } else if (i == 2) {
                    Collection<Persons> personsRole = getAllUsersWithRoles();
                } else if (i == 3) {
                    Collection<Persons> personsRole = getUsersByRole();
                } else if (i == 4) {
                    int idUsers = scanner.nextInt();
                    deleteUser(idUsers);
                } else if (i == 5) {
                    Collection<Persons> personsNoRole = getAllUsersNoRole();
                } else if (i == 6) {
                    updateUser();
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("НЕВЕРНЫЙ ВВОД");
                scanner.nextLine();
            }

        }
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
    private static Collection<Persons> getAllUsersWithRoles() {
        return null;
    }
//    3 Получать список пользователей по конкретной роли;

    private static Collection<Persons> getUsersByRole() {
        return null;
    }

    //    4 Удалять пользователя в БД;
    private static void deleteUser (int id) {

    }

    //    5 Получать список пользователей из БД (без ролей);
    private static Collection<Persons> getAllUsersNoRole() {
        return null;
    }
    //    6 Редактировать существующего пользователя в БД.

    private static void updateUser() {

    }

}


