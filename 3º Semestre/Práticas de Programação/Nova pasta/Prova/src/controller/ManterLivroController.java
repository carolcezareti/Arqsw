package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Livro;
import service.LivroService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterLivroController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pNome = request.getParameter("nome");
        String pAutor = request.getParameter("autor");
        String pAno = request.getParameter("ano");
        
        //instanciar o javabean
        Livro livro = new Livro();
        livro.setNome(pNome);
        livro.setAutor(pAutor);
        livro.setAno(pAno);
        
        //instanciar o service
        LivroService cs = new LivroService();
        cs.criar(livro);
        livro = cs.carregar(livro.getId());
        
        //enviar para o jsp
        request.setAttribute("livro", livro);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Livro.jsp");
        view.forward(request, response);
        
    }
    
}

