package shop;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shop.dao.MenuDao;

public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      MenuDao menuDao = new MenuDao();
      menuDao.setSqlSessionFactory(sqlSessionFactory);
      
      ctx.setAttribute("menuDao", menuDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}
