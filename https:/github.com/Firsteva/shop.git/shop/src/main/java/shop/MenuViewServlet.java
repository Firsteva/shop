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

@WebServlet("/shop/menu/view")
public class MenuViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    MenuDao menuDao = (MenuDao)this.getServletContext()
                                         .getAttribute("menuDao");
    Menu menu = menuDao.selectOne(no);
    
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
    out.println("<h1>메뉴 정보</h1>");
    
    out.println("<form class='form-horizontal' role='form' "
        + "action='update' method='post'>");
    out.println("<div class='form-group'>");
    out.println("  <label for='no' class='col-sm-2 control-label'>번호</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' readonly ");
    out.println("        id='no' name='no' value='" + menu.getNo() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='name' class='col-sm-2 control-label'>음료명</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='name' name='name' value='" + menu.getName() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='price' class='col-sm-2 control-label'>가격</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='price' name='price' value='" + menu.getPrice() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='reg_date' class='col-sm-2 control-label'>등록일시</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='reg_date' name='reg_date' value='" + menu.getReg_date() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <div class='col-sm-offset-2 col-sm-10'>");
    out.println("    <button id='btnUpdate' type='submit' class='btn btn-primary'>변경</button>");
    out.println("    <button id='btnDelete' type='button' class='btn btn-primary'>삭제</button>");
    out.println("    <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("</form>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    out.println("<script>");
    out.println("  $('#btnCancel').click(function(){");
    out.println("    history.back();");
    out.println("  });");
    
    out.println("  $('#btnDelete').click(function(){");
    out.println("    if (window.confirm('삭제하시겠습니까?')) {");
    out.println("      location.href = 'delete?no=" +  menu.getNo() + "'");
    out.println("    }");
    out.println("  });");
    
    out.println("  $('#btnUpdate').click(function(){");
    out.println("    if ( $('#name').val().length == 0) {");
    out.println("      alert('음료명은 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#price').val().length == 0) {");
    out.println("      alert('가격은 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#reg_date').val().length == 0) {");
    out.println("      alert('등록일시는 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    out.println("  });");
    
    out.println("</script>");
    
    rd = request.getRequestDispatcher("/common/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }
  
}
