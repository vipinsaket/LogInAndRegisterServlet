import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Cgpa")

public class Cgpa extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first=req.getParameter("sem1");
		String second=req.getParameter("sem2");
		String third=req.getParameter("sem3");
		String four=req.getParameter("sem4");
		String five=req.getParameter("sem5");
		String six=req.getParameter("sem6");
		String seven=req.getParameter("sem7");
		String eight=req.getParameter("sem8");
		
		double s1=Double.parseDouble(first);
		double s2=Double.parseDouble(second);
		double s3=Double.parseDouble(third);
		double s4=Double.parseDouble(four);
		double s5=Double.parseDouble(five);
		double s6=Double.parseDouble(six);
		double s7=Double.parseDouble(seven);
		double s8=Double.parseDouble(eight);
		
		double cgpa=(s1+s2+s3+s4+s5+s6+s7+s8)/8;
		PrintWriter pr=resp.getWriter();
		pr.print("<html><body> CGPA is :"+String.format("%.2f", cgpa)+"</body></html>");
		
		
		
		
		
	}

}
