package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;



@WebServlet("/login")

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserDao usuarioDAO = new UserDao();


	public LoginServlet() {
        // TODO Auto-generated constructor stub
		
		super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        
        Usuario user = null;
        Usuario user1 = null;
        
        
        try {
        	user = usuarioDAO.getUser(login);
            user1= usuarioDAO.getPassword(senha);
            
            System.out.println(user.getNome());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(user == user1) {
            request.setAttribute("usuario", user);
            
            
            ListTaskServelet des = new ListTaskServelet();
            
            des.doGet(request, response);
        }
    
    }
	
	
	
}