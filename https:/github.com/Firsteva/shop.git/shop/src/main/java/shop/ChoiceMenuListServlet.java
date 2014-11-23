package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import shop.dao.MenuDao;
import shop.domain.Menu;

@WebServlet("/shop/menu/choicelist")
public class ChoiceMenuListServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	static final int PAGE_DEFAULT_SIZE = 3;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		int pageNo = 0;
		int pageSize = 0;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = PAGE_DEFAULT_SIZE;
		}

		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		RequestDispatcher rd = 
				request.getRequestDispatcher("/common/header");
		rd.include(request, response);

		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<h1>주문 목록</h1>");
		/*out.println("<p><a href='choicemenu-form.html' class='btn btn-primary'>새제품</a></p>");*/
		out.println("<table class='table table-hover'>");
		out.println("<tr>");
		out.println("  <th>음료명</th><th>가격</th><th>수량</th><th>선택</th>");
		out.println("</tr>");

		MenuDao menuDao = (MenuDao)this.getServletContext()
				.getAttribute("menuDao");

		for (Menu menu : menuDao.selectList(pageNo, pageSize)) {
			out.println("<tr>");
			/*out.println("  <td><a href='view?no=" + menu.getNo() + "'>" 
            + menu.getName() + "</a></td>");*/
			/*
       <div class='form-group'>
  <label for='price' class='col-sm-2 control-label'>가격</label>

			 */
			out.println("		<td>" + menu.getName() + "</td>");
			out.println("  <td>" + menu.getPrice() + "</td>");
			out.println("<td>");
			out.println("<input type='text' class='form-control input-sm' id='num' name='num' maxlength='2'>");
			out.println("</td>");
			out.println("<td><input type='checkbox' id='choice' name='choice'></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<div class='form-group'>");
		out.println("<div class='col-sm-offset-2 col-sm-10'>");
		out.println("  <button id='btnAdd' type='submit' class='btn btn-primary'>확정</button>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");

		out.println("<script src='../../js/jquery-1.11.1.js'></script>");

		rd = request.getRequestDispatcher("/common/footer");
		rd.include(request, response);

		out.println("</body>");
		out.println("</html>");
	}

}