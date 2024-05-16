package ch18;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch18/pmemberLogin")
public class PMemberLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PMemberMgr pMgr = new PMemberMgr();
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String url = "login.jsp";
        
        if(pMgr.loginPMember(id, pwd)) {
            request.getSession().setAttribute("idKey", id);
            PMemberBean bean = pMgr.getPMember(id);
            request.getSession().setAttribute("bean", bean);
        } else {
            request.getSession().setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다.");
        }
        response.sendRedirect(url);
    }
}

