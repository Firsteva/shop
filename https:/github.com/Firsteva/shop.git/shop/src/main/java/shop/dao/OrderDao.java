package shop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shop.domain.Order;

@Component
public class OrderDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public OrderDao() {}

	public Order selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(
					"shop.OrderDao.selectOne", 	no);
		} finally {
			sqlSession.close();
		}
	}

	public void update(Order order) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
					"shop.OrderDao.update", order);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"shop.OrderDao.delete", no);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Order> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"shop.OrderDao.selectList", paramMap);
		} finally {
			sqlSession.close();
		}
	}

	public void insert(Order order) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"shop.OrderDao.insert", order);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
