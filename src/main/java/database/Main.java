package database;

public class Main {
    public static void main(String[] args) {
        INSERT userDAO = new INSERT();


        /* userDAO.addUser("João Silva", "joao.silva@example.com"); */


        userDAO.getUsers();


        /* userDAO.updateTable(1, "João Silva Atualizado", "joao.silva2@example.com"); */


        /* userDAO.deleteUser(2); */
    }
}
