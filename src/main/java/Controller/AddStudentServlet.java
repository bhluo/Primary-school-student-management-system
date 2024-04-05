package Controller;

import Dao.studentDao;
import Dao.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id =request.getParameter("id");
        // 获取表单参数
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        String idCard = request.getParameter("idCard");

        // 创建学生对象

        Student student = new Student(id,name,birthdate,idCard);

        // 调用学生管理服务添加学生
        studentDao studentDao = new studentDao();
        studentDao.add(student);

        // 重定向到学生列表页面
        response.sendRedirect(request.getContextPath() + "/studentList");
    }

}
