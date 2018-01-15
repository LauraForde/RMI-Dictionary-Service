package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dicServlet")
public class DicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueueService q;
	private String answer;
	
	public DicServlet(){
		super();
	}
	
	// Trying to get the result
	protected void doGet(HttpServletRequest req, HttpServletResponse res, String ans) throws ServletException, IOException{
		res.getWriter().append(ans);
		res.sendRedirect("index.jsp?answer="+ans);
	}
	
	// Trying to post the result of the search
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		// Get from the queue
		q = new QueueService(req.getParameter("word"));
		new Thread(q).start();
		
		try{
			// Sleep
			Thread.sleep(1000);
			// Call the respone method
			String ans = q.response();
			System.out.println("The meaning: " + ans);
			// Passing parameters to the doGet method
			doGet(req, res, ans);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
