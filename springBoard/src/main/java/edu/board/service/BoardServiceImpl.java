package edu.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.board.dao.BoardDAO;
import edu.board.vo.BoardVO;
import edu.board.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	
	@Override
	public List<BoardVO> list(SearchVO searchVO) {
		return boardDao.selectAll(searchVO);
	}


	@Override
	public int insert(BoardVO vo) {
		return boardDao.insert(vo);
	}


	@Override
	public BoardVO selectOne(int bidx) {
		return boardDao.selectOne(bidx);
	}

	
	

}
