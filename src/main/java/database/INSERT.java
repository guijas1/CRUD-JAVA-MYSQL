package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class INSERT {
    public void addUser(String name, String email) {
        String sql = "INSERT INTO users_crud (name, email) VALUES (?, ?)";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getUsers(){
        String sql = "SELECT * FROM users_crud";
        try(Connection conn = DBconnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("----------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateTable(int id, String name, String email){
        String sql = "UPDATE users_crud SET name =?, email=? where id =?";

        try(Connection conn = DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users_crud WHERE id = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário deletado com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

