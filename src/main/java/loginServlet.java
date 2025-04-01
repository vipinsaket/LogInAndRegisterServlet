import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String user=req.getParameter("username");
			String password=req.getParameter("password");
			
			
			
			Conn c = new Conn();
	        boolean isValidUser = c.validateUser(user, password);
	        
	        
	        
	        
	        

//	        if (isValidUser) {
//	        	System.out.println("Login Success: Redirecting to home.html");
//	            resp.sendRedirect("home.html"); 
//	            RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
//	            dispatcher.forward(req, resp);
//	        }
	        
	        if(isValidUser) {
	        	HttpSession sessoin=req.getSession();
	        	sessoin.setAttribute("user", user);
	        	sessoin.setAttribute("password", password);
	        	System.out.println("sesson is created");
//	        	RequestDispatcher dispatcher = req.getRequestDispatcher("/home.html");
//	        	dispatcher.forward(req, resp);
//	        	PrintWriter pr=resp.getWriter();
//	        	pr.print("<h1>welcome</h1>");
	        	resp.sendRedirect("home.html");
	        }
	        else {
	          
	            req.setAttribute("errorMessage", "Invalid username or password.");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
	            PrintWriter pr=resp.getWriter();
	            pr.print("<html><body>");
	            pr.print("<h4>invalid user name or password</h4>");
	            pr.print("</body></html>");
	            
	            dispatcher.include(req, resp);
	            System.out.println("Invalid user name or password");
	        }
			
			
			
			
			
			
			
			
			
			
			
			
//			if("vipin".equals(user) && "Vipin@123".equals(password)) {
//				RequestDispatcher dispatcher=  req.getRequestDispatcher("/home.html");
//				dispatcher.forward(req, resp);
//				System.out.println("helell");
//				System.out.println(user);
//				System.out.println(password);
//			}
//			else {
//				System.out.println("user name and password is not match");
//			}
		}
}
