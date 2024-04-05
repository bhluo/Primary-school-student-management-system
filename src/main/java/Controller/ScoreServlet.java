package Controller;

import Dao.ScoreDao;
import Dao.Score;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/scoreServlet")
public class ScoreServlet extends HttpServlet {
    private ScoreDao scoreDao;

    @Override
    public void init() throws ServletException {
        super.init();
        scoreDao = new ScoreDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    String id = request.getParameter("id");
                    scoreDao.deleteScoreById(id);
                    System.out.println("删除"+id);
                    break;
                default:
                    break;
            }
        }
        List<Score> scores = scoreDao.getAllScores();
        request.setAttribute("Scores", scores);
        request.getRequestDispatcher("score.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String term = request.getParameter("term");
        int chinese = Integer.parseInt(request.getParameter("chinese"));
        int math = Integer.parseInt(request.getParameter("math"));
        int english = Integer.parseInt(request.getParameter("english"));
        Score score = new Score();
        score.setId(id);
        score.setTerm(term);
        score.setChinese(chinese);
        score.setMath(math);
        score.setEnglish(english);

        scoreDao.addScore(score);

        List<Score> scores = scoreDao.getAllScores();
        request.setAttribute("Scores", scores);
        request.getRequestDispatcher("score.jsp").forward(request, response);
    }
}
