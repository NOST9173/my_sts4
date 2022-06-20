package edu.board.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.board.vo.UserVO;


// DAO는 왜 Repository인가? -> 외부의 자원에 연결하기 때문에 Repository를 사용한다.
@Repository
public class UserDAO {
	
	
	// 컴포넌트와 빈으로 설정한 것이 객체화 할 때 불러들인다.? 
	@Autowired
	SqlSession sqlSession;
	
	
	public int insert(UserVO vo) {
		 
					//sql세션에 있는 insert는 명을 바꿀 수 없다.
		int result = sqlSession.insert("edu.Board.mapper.UserMapper.insert",vo);
		
		return result;
		
	}
	
	public UserVO selectByLogin(UserVO vo) {
		
							//electOne 은 단 한건의 sql 구문만 있을 때? 사용이 가능하다. 여러개는 안한다.?
		return sqlSession.selectOne("edu.Board.mapper.UserMapper.selectByLogin", vo);
		
		
	}
	
	
	public UserVO selectByMypage(int midx) {
																				//usermapper에 매개변수를 midx로 만들었기에
		return sqlSession.selectOne("edu.Board.mapper.UserMapper.selectByMypage", midx);
	}
	
	
	public int modify(UserVO vo) {
		
		return sqlSession.update("edu.Board.mapper.UserMapper.modify", vo);
		
		
	}
	
}











