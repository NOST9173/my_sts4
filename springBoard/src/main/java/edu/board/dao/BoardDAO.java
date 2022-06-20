package edu.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.board.vo.BoardVO;
import edu.board.vo.SearchVO;


// DAO는 외부에서 접근하는 것이기에. 외부와 소통하기 위한 것이기에. Repository를 사용한다.
@Repository
public class BoardDAO {
	
	
	
	private static final String namespace = "edu.Board.mapper.boardMapper";
	
	
	
	@Autowired
	SqlSession sqlSession;
	
	public List<BoardVO> selectAll(SearchVO searchVO){
		return sqlSession.selectList(namespace+".selectAll",searchVO);
	}
	
	public int insert(BoardVO vo) {
		
		
		return sqlSession.insert(namespace+".insert",vo);
	}
	
	public BoardVO selectOne(int bidx) {
		
		return sqlSession.selectOne(namespace+".selectOne",bidx);
	}
	
	
	
	
	
}
