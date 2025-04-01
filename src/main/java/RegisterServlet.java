import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/RegisterServlet") 
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	
    	 // Retrieve form data front end
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        
        
        System.out.println("the data will stroed in the all variable");
        
        
      

        // Backend validation to check all data are filed or not
        if (fullname == null || username == null || email == null || password == null || address == null) {
            response.getWriter().println("Error: Missing required fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.getWriter().println("Error: Passwords do not match!");
            return;
        }

        // Log data (For debugging)
        System.out.println("Full Name: " + fullname);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
          
        
        int ager=Integer.parseInt(age);
        Conn c=new Conn();
        

        int res = c.add(fullname, username, email, ager, address, password, confirmPassword);
   

       
        response.sendRedirect("login.html");
    }
    public static void main(String[] args) {
		
	}
}
