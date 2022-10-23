package unitn.webarchitecture.flaggame.web;

import java.io.IOException;
import java.util.Enumeration;
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
 * Servlet implementation class ScoreUpdater
 */
@WebServlet("/scoreupdater")
public class ScoreUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	String ans_1 = session.getAttribute("ans_1").toString();
    	String ans_2 = session.getAttribute("ans_2").toString();
    	String ans_3 = session.getAttribute("ans_3").toString();
    	
    	String user_ans_1 = request.getParameter("user_ans_1");
    	String user_ans_2 = request.getParameter("user_ans_2");
    	String user_ans_3 = request.getParameter("user_ans_3");
		
    	System.out.println(ans_1 + " - " + ans_2 + " - " + ans_3);
    	System.out.println(user_ans_1 + " - " + user_ans_2 + " - " + user_ans_3);
    	
		try {
			Player p = FlagGameServletContextListener.pdb.getPlayerDetails((String)session.getAttribute("username"));
			
			if(ans_1.equals(user_ans_1) && ans_2.equals(user_ans_2) && ans_3.equals(user_ans_3)) {
				p.setScore(p.getScore()+3);
			} else {
				p.setScore(p.getScore()-1);
			}
			
			session.setAttribute("score", p.getScore());
			response.sendRedirect("Home.jsp");
			
		} catch (Exception e) {
			response.sendRedirect("Login.jsp");
			e.printStackTrace();
		}
	}
}
