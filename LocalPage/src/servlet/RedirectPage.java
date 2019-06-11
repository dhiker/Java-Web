package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Check;

/**
 * Servlet implementation class redirectpage
 */
@WebServlet("/redirectpage")
public class RedirectPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("index.jsp").forward(request, response);		//send to login page
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	//set encoding to utf8
		
		String id= request.getParameter("id");	//get input data from web form
        String pw= request.getParameter("pw");
        
        Check c= new Check();						//call account check service
        boolean accountConfirme= false;
        accountConfirme= c.checkAccount(id, pw);
        
        if(accountConfirme) {														//send to main page if pass check or return to login page with message
        	request.setAttribute("id", id);
        	request.getRequestDispatcher("mpg.jsp").forward(request, response);
        }else {
        	request.setAttribute("msg", "username/password incorrect");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */

}
