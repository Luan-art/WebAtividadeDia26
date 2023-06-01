package controller;

import java.io.IOException;


import model.Tarefa;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastroDeTarefa")
public class CadTaskServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TarefaDao tarefaDAO = new TarefaDao();

    /**
     * Default constructor. 
     */
    public CadTaskServelet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/CadastroDeTarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        
        try {
        	 tarefaDAO.registerTask(titulo,descricao);
        	 } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/CadastroDeTarefa.jsp");
		dispatcher.forward(request, response);
    }
	

}