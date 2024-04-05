package Controller;

import Dao.AdminDao;
import Dao.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminManagementServlet")
public class AdminManagementServlet extends HttpServlet {
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        super.init();
        adminDao = new AdminDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    String username = request.getParameter("username");
                    adminDao.deleteAdminByName(username);
                    System.out.println("删除"+username);
                    break;
                default:
                    break;
            }
        }
        List<Admin> admins = adminDao.getAllAdmins();
        System.out.println(admins);
        request.setAttribute("admins", admins);
        request.getRequestDispatcher("adminManagement.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        adminDao.addAdmin(admin);

        List<Admin> admins = adminDao.getAllAdmins();
        request.setAttribute("admins", admins);
        request.getRequestDispatcher("adminManagement.jsp").forward(request, response);
    }
}
