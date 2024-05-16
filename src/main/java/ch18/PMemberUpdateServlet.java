package ch18;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch18/pmemberUpdate")
public class PMemberUpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PMemberMgr pMgr = new PMemberMgr();
		pMgr.updatePMember(request);
		HttpSession session = request.getSession();
		PMemberBean bean = pMgr.getPMember((String)session.getAttribute("idKey"));
		session.setAttribute("bean",bean);
		response.sendRedirect("login.jsp");
	}
}