package shop;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import shop.dao.MenuDao;
import shop.domain.Menu;

@WebServlet("/shop/menu/add")
public class MenuAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    
    Menu menu = new Menu();
    menu.setName(request.getParameter("name"));
    menu.setPrice(Integer.parseInt(request.getParameter("price")));
    menu.setReg_date(request.getParameter("reg_date"));
    MenuDao menuDao = (MenuDao)this.getServletContext()
                                         .getAttribute("menuDao");
    try {
      menuDao.insert(menu);
      
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}