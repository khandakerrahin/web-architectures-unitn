package unitn.webarchitecture.simplepreadsheet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unitn.ronchet.Spreadsheet.Cell;
import it.unitn.ronchet.Spreadsheet.SSEngine;
import unitn.webarchitecture.simplepreadsheet.utils.JsonEncoder;

/**
 * Servlet implementation class SpreadsheetCurrentState
 */
@WebServlet("/currentstate")
public class SpreadsheetCurrentState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpreadsheetCurrentState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentTimestamp = request.getParameter("currentTimestamp");
		System.out.println("currentTimestamp: " + currentTimestamp);
		
		String retval = "";
		JsonEncoder jsonEncoder = new JsonEncoder();
		try {
			SSEngine engine=SSEngine.getSSEngine();
			//System.out.println("SSEngine Response: " + engine.modifyCell(id, formula));
			
			
			
//			for (Cell cell: engine.modifyCell(id, formula)) {
//				jsonEncoder.addElement(cell.getId(), ""+cell.getValue());
//			}
			retval=jsonEncoder.buildJsonObject().toString();
			System.out.println("JSON: "+ retval);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("------- ERROR!---------DIVISION BY ZERO!");
			
			jsonEncoder.addElement(currentTimestamp, ""+0);
			
			retval=jsonEncoder.buildJsonObject().toString();
			System.out.println("JSON: "+ retval);
		}
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(retval);
        out.flush();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
