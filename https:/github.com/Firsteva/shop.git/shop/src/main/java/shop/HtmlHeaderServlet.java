package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* Include에 사용할 서블릿 
 * => HTML 페이지의 헤더 부분의 출력을 맡는다.
 */

@WebServlet("/common/header")
public class HtmlHeaderServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    
    String webAppPath = 
        this.getServletContext().getContextPath();
    
    PrintWriter out = response.getWriter();
    
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath
        + "/css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath
        + "/css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='" + webAppPath
        + "/css/common.css'>");
  }

}











