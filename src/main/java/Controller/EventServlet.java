package Controller;

import Dao.EventDao;
import Dao.Event;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/eventServlet")
public class EventServlet extends HttpServlet {
    private EventDao eventDao;

    @Override
    public void init() throws ServletException {
        super.init();
        eventDao = new EventDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    String id = request.getParameter("id");
                    eventDao.deleteEventById(id);
                    System.out.println("删除"+id);
                    break;
                default:
                    break;
            }
        }
        List<Event> events = eventDao.getAllEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("event.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String event_date=request.getParameter("date");
        String event_type=request.getParameter("type");
        String detail=request.getParameter("detail");

        Event event = new Event();
        event.setId(id);
        event.setEvent_date(event_date);
        event.setEvent_type(event_type);
        event.setDetail(detail);
        eventDao.addEvent(event);
        List<Event> events = eventDao.getAllEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("event.jsp").forward(request, response);
    }
}
