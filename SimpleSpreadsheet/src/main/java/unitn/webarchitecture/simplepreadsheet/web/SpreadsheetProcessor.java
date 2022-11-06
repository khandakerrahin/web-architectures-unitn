package unitn.webarchitecture.simplepreadsheet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unitn.ronchet.Spreadsheet.Cell;
import it.unitn.ronchet.Spreadsheet.SSEngine;
import unitn.webarchitecture.simplepreadsheet.utils.JsonEncoder;

/**
 * Servlet implementation class SpreadsheetProcessor
 */
@WebServlet("/processor")
public class SpreadsheetProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map <String,String> cells = new HashMap<String, String>();
	private static Timestamp lastUpdatedTimestamp = new Timestamp(System.currentTimeMillis());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpreadsheetProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String formula = request.getParameter("formula");
		String action = request.getParameter("action");
		
		System.out.println("id: " + id);
		System.out.println("formula: " + formula);
		System.out.println("action: " + action);
		System.out.println();
		String retval = "";
		JsonEncoder jsonEncoder = new JsonEncoder();
		
		SSEngine engine=SSEngine.getSSEngine();
		
		try {
			switch(action) {
				case "modifycell":
					for (Cell cell: engine.modifyCell(id, formula)) {
						jsonEncoder.addElement(cell.getId(), ""+cell.getValue());
						cells.put(cell.getId(), ""+cell.getValue());
					}
					lastUpdatedTimestamp = new Timestamp(System.currentTimeMillis());
					
					jsonEncoder.addElement("lastModified", ""+lastUpdatedTimestamp);
					
					retval=jsonEncoder.buildJsonObject().toString();
					System.out.println("JSON: "+ retval);
					break;
				case "currentstate":
					String lastModified = request.getParameter("lastModified");
					
					if(lastModified.equals(""+lastUpdatedTimestamp)) {
						
					}
					for (Map.Entry<String, String> set : cells.entrySet()) {
			            jsonEncoder.addElement(set.getKey(), set.getValue());
			        }
					retval=jsonEncoder.buildJsonObject().toString();
					System.out.println("JSON: "+ retval);
					break;
				case "getvalue":
					//Cell cell = new Cell;
					retval=jsonEncoder.buildJsonObject().toString();
					System.out.println("ENGINE: "+ engine.toString());
					break;
				default:
			    // code block
			}
		} catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("------- ERROR!---------DIVISION BY ZERO!");
			
			jsonEncoder.addElement(id, ""+0);
			
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
