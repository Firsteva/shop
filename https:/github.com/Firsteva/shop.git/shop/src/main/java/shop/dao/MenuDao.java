package shop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shop.domain.Menu;

@Component
public class MenuDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public MenuDao() {}

	public Menu selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(
					"shop.MenuDao.selectOne", 	no);
		} finally {
			sqlSession.close();
		}
	}

	public void update(Menu menu) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
					"shop.MenuDao.update", menu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"shop.MenuDao.delete", no);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Menu> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"shop.MenuDao.selectList", paramMap);
		} finally {
			sqlSession.close();
		}
	}

	public void insert(Menu menu) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"shop.MenuDao.insert", menu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
