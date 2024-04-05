package Controller;
import Dao.studentDao;
import Dao.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/stumServlet")
public class  StudentManagementServlet extends HttpServlet {
    public studentDao studentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDao = new studentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "delete":
                    String username = request.getParameter("username");
                    studentDao.deleteStudentByName(username);
                    System.out.println("删除"+username);
                    break;
                default:
                    break;
            }
        }
        List<Student> students = null;
        students = studentDao.getAllStudents();
        System.out.println(students);
        request.setAttribute("students", students);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String id = request.getParameter("id");
        String birthdate = request.getParameter("birthdate");
        String idCard = request.getParameter("idCard");

       Student student = new Student();
        student.setId(id);
        student.setName(username);
        student.setBirthdate(birthdate);
        student.setIdCard(idCard);
        studentDao.add(student);
        List<Student> students = null;
        students = studentDao.getAllStudents();
        System.out.println(students);
        request.setAttribute("students", students);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }
}
