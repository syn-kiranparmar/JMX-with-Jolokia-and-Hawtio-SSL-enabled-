import java.io.IOException;

import javax.management.MalformedObjectNameException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pExecRequest;


public class ClientServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regionName = req.getParameter("region");
		
		System.out.println("doPost called with Region name : " + regionName);
		
		J4pClient j4pClient = new J4pClient("http://127.0.0.1:7777/jolokia/");
		J4pExecRequest execReq = null;
		try {
			execReq = new J4pExecRequest("VeriTrans:type=RegionBean", "update", regionName);
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	try {
			j4pClient.execute(execReq);
		} catch (J4pException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
