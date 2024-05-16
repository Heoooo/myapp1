package ch03;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//@WebServlet(urlpatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>MyServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파이팅 코리아!!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}


