package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import model.Usuario;

public class UserDao {

	 public int registerUser( Usuario user) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO usuarios" +
	            "  (id, login, senha, nome, email) VALUES " +
	            " (?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, user.getLogin());
	            preparedStatement.setString(3, user.getNome());
	            preparedStatement.setString(4, user.getSenha());
	            preparedStatement.setString(5, user.getEmail());
	   

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }




	public Usuario getUser(String username) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (login) FROM usuarios" +
	        		" WHERE login=?";

		   Usuario user = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setString(1, username);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		user = new Usuario();
	            		user.setLogin(resultSet.getString("login"));
	            		user.setSenha(resultSet.getString("senha"));
	            		user.setNome(resultSet.getString("nome"));
	            		user.setEmail(resultSet.getString("email"));

	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return user;
	}
	
	public Usuario getPassword(String password) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (senha) FROM usuarios" +
	        		" WHERE senha=?";

		   Usuario user = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setString(1, password);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		user = new Usuario();
	            		user.setLogin(resultSet.getString("login"));
	            		user.setNome(resultSet.getString("nome"));
	            		user.setSenha(resultSet.getString("senha"));
	            		user.setEmail(resultSet.getString("email"));

	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return user;
	}
	
	
}
