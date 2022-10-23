package unitn.webarchitecture.flaggame.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unitn.webarchitecture.flaggame.resources.Player;
import unitn.webarchitecture.flaggame.utils.FlagGameServletContextListener;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("psw");
		String rpass = request.getParameter("rpsw");
		
		try {
			if(rpass.equals(pass) && !FlagGameServletContextListener.pdb.checkUser(uname)) {
				Map <String, Player> players = FlagGameServletContextListener.pdb.getPlayerDB()==null?new HashMap<String, Player>():FlagGameServletContextListener.pdb.getPlayerDB();
				players.put(uname, new Player(uname, pass, 0, false));
				
				FlagGameServletContextListener.pdb.setPlayerDB(players);
				
				HttpSession session = request.getSession();
				//session.setMaxInactiveInterval(10*60);
				
				session.setAttribute("username", uname);
				session.setAttribute("isAdmin", "0"); // 0=not admin; 1=admin
				// fetching user score
				session.setAttribute("score", 0);
				
				response.sendRedirect("Home.jsp");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Login.jsp");
		}
	}
}
