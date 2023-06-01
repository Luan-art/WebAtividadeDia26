package dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import model.Tarefa;

public class TarefaDao {
	 
	public int registerTask( String titulo, String descrcao) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO tarefas" +
	            "  (titulo, descricao) VALUES " +
	            " (?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)) {
	        	preparedStatement.setString(1, titulo);
	            preparedStatement.setString(2, descrcao);
	   

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }




	public Tarefa getId(int id) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (id) FROM tarefas" +
	        		" WHERE id=?";

		   Tarefa task = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setInt(1, id);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		task = new Tarefa();
	            		task.setId(id);
	            		task.setTitulo(resultSet.getString("titulo"));
	            		task.setDescriacao(resultSet.getString("descricao"));
	            		task.setData_criacao(resultSet.getString("data_craicao"));
	            		task.setData_conclusao(resultSet.getString("data_conclusao"));
	            		task.setStatus(resultSet.getString("status"));


	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return task;
	}
	
	public List<Tarefa> buscarPorIdUser(int id) throws ClassNotFoundException {
		String SELECT_TAREFA = "SELECT id, titulo, descricao, data_criacao, data_conclusao, status, id_usuario FROM tarefas" +
								" WHERE idUser=?;";
		
		List<Tarefa> tarefas = null;
		Tarefa tarefa = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = (Connection) DriverManager
		    .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "root");
		
		    // Step 2:Create a statement using connection object
		    PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(SELECT_TAREFA)) {
		    preparedStatement.setInt(1, id);
		
		    System.out.println(preparedStatement);
		    // Step 3: Execute the query or update query
		    try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
		    	tarefas = new ArrayList<>();
		    	while (resultSet.next()) {
		    		tarefa = new Tarefa();
		    		tarefa.setId(resultSet.getInt("id"));
		    		tarefa.setTitulo(resultSet.getString("titulo"));
		    		tarefa.setDescriacao(resultSet.getString("descricao"));
		    		tarefa.setData_criacao(resultSet.getString("data_criacao"));
		    		tarefa.setData_conclusao(resultSet.getString("data_conclusao"));
		    		tarefa.setStatus(resultSet.getString("status"));
		    		tarefa.setIdUser(resultSet.getInt("idUser"));
		    		tarefas.add(tarefa);
		    	}
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
		
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		return tarefas;
	}
	
	public int deletarTarefa(int id_tarefa) throws ClassNotFoundException {
		String REMOVE_TAREFA = "DELETE FROM tarefas" +
				" WHERE id=?;";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "root");
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(REMOVE_TAREFA)) {
				preparedStatement.setInt(1, id_tarefa);
				
				System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
	}
	
	
}
