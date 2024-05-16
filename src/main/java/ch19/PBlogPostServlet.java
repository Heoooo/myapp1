package ch19;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch19/pBlogPost")
public class PBlogPostServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PBlogMgr pMgr = new PBlogMgr();
		pMgr.insertPBlog(request);
		response.sendRedirect("home.jsp");
	}
}
