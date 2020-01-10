package member.controller.plan;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.PlanService;
import member.model.vo.MyPlan;

/**
 * Servlet implementation class PlanUpdateServlet
 */
@WebServlet("/update.pl")
public class PlanUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pId = Integer.parseInt(request.getParameter("pId"));
		String mId = request.getParameter("mId");
		String pName = request.getParameter("pName");
		String dateStr = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String content = request.getParameter("content");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyPlan myplan = new MyPlan(pId, mId, pName, date, startTime, endTime, content);
		
		MyPlan updatePlan = new PlanService().updatePlan(myplan);
		
		if(updatePlan != null) {
			request.getSession().setAttribute("msg", "계획을 성공적으로 수정하였습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "계획 수정을 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
