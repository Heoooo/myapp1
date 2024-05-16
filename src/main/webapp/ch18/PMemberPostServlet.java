package ch18;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch18/pmemberPost")
public class PMemberPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PMemberMgr pMgr = new PMemberMgr();
        
        if (pMgr.insertPMember(request)) {
            response.sendRedirect("login.jsp");
        } else {
            request.getSession().setAttribute("msg", "회원가입에 실패하였습니다");
            response.sendRedirect("pregister.jsp");
        }
    }
}
