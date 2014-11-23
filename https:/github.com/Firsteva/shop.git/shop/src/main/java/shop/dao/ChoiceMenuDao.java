package shop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shop.domain.ChoiceMenu;

@Component
public class ChoiceMenuDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ChoiceMenuDao() {}

	public ChoiceMenu selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(
					"shop.ChoiceMenuDao.selectOne", 	no);
		} finally {
			sqlSession.close();
		}
	}

	public void update(ChoiceMenu choiceMenu) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
					"shop.ChoiceMenuDao.update", choiceMenu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"shop.ChoiceMenuDao.delete", no);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<ChoiceMenu> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"shop.ChoiceMenuDao.selectList", paramMap);
		} finally {
			sqlSession.close();
		}
	}

	public void insert(ChoiceMenu choiceMenu) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"shop.ChoiceMenuDao.insert", choiceMenu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
