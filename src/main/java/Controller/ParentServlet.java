package Controller;
import Dao.ParentDao;
import Dao.Parent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/parentServlet")
public class ParentServlet extends HttpServlet {
    private ParentDao parentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        parentDao = new ParentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    String id = request.getParameter("id");
                    parentDao.deleteParentById(id);
                    System.out.println("删除"+id);
                    break;
                default:
                    break;
            }
        }
        List<Parent> Parents = parentDao.getAllParents();
        System.out.println(Parents);
        request.setAttribute("Parents", Parents);
        request.getRequestDispatcher("parentInfo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String parent_name = request.getParameter("parent_name");
        String relationship = request.getParameter("relationship");
        String phone = request.getParameter("phone");
        Parent parent = new Parent();
        parent.setId(id);
        parent.setParent_name(parent_name);
        parent.setPhone(phone);
        parent.setRelationship(relationship);

        parentDao.addParent(parent);

        List<Parent> parents = parentDao.getAllParents();
        request.setAttribute("Parents", parents);
        request.getRequestDispatcher("parentInfo.jsp").forward(request, response);
    }
}
