package Controller;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import Dao.Admin;
import Dao.AdminDao;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gb2312");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//	创建JavaBean
        Admin bean = new Admin();
        bean.setUsername(username);
        bean.setPassword(password);
        AdminDao service = new AdminDao();
//	判断是否登录成功
        if (service.checkLogin(bean) == 1) {
            RequestDispatcher dis = req.getRequestDispatcher("welcome.jsp");
            dis.forward(req, resp);
        } else if (service.checkLogin(bean) == 2) {
            resp.setContentType("text/html");
            // 获取输出流
            PrintWriter out = resp.getWriter();
            // 输出JavaScript代码
            out.println("<script type=\"text/javascript\">");
            out.println("alert('PassWordError,Try Agin');");
            out.println("</script>");
            out.close();
            resp.sendRedirect("login.jsp");
//		重定向
            //  resp.sendRedirect("login.jsp");
        } else if (service.checkLogin(bean) == 0) {
            resp.setContentType("text/html");
            // 获取输出流
            PrintWriter out = resp.getWriter();
            // 输出JavaScript代码
            out.println("<script type=\"text/javascript\">");
            out.println("alert('UsernameNotFoundError,Try Agin');");
            out.println("</script>");

            out.close();
//		重定向
            //
            resp.sendRedirect("register.jsp");
        }
        else {
            resp.setContentType("text/html");
            // 获取输出流
            PrintWriter out = resp.getWriter();
            // 输出JavaScript代码
            out.println("<script type=\"text/javascript\">");
            out.println("alert('数据库连接失败');");
            out.println("</script>");

            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
