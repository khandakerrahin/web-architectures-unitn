package unitn.webarchitecture.flaggame.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unitn.webarchitecture.flaggame.resources.Player;
import unitn.webarchitecture.flaggame.utils.FlagGameServletContextListener;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("psw");
		
		try {
			if(uname.equals("admin") && pass.equals("nimda")) {
				HttpSession session = request.getSession();
				//session.setMaxInactiveInterval(10*60);
				
				session.setAttribute("username", uname);
				session.setAttribute("isAdmin", "1"); // 0=not admin; 1=admin
				// fetching user score
				response.sendRedirect("Admin.jsp");
			} else if(FlagGameServletContextListener.pdb.checkUser(uname)) {
				Player p = FlagGameServletContextListener.pdb.getPlayerDetails(uname);
				
				if(p.getPassword().equals(pass)) {
					HttpSession session = request.getSession();
					//session.setMaxInactiveInterval(10*60);
					
					session.setAttribute("username", uname);
					session.setAttribute("isAdmin", "0"); // 0=not admin; 1=admin
					// fetching user score
					session.setAttribute("score", p.getScore());
					
					response.sendRedirect("Home.jsp");
				} else {
					response.sendRedirect("Login.jsp");
				}
				
			} else {
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("Login.jsp");
		}
	}

}
