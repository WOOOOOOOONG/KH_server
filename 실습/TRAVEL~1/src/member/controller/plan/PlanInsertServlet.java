package member.controller.plan;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.service.PlanService;
import member.model.vo.MyPlan;

/**
 * Servlet implementation class PlanInsertServlet
 */
@WebServlet("/insert.pl")
public class PlanInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// int pId, String mId, String pName, Date date, String startTime, String endTime
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
		int result = new PlanService().insertPlan(myplan);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "게시글이 추가되었습니다.");
			response.sendRedirect(request.getContextPath());	
		}
		else {
			request.setAttribute("msg", "게시글 추가가 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
