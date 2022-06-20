package edu.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.board.dao.UserDAO;
import edu.board.vo.UserVO;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	
	@Override
	public int insertUser(UserVO vo) {
		int result = userDao.insert(vo);
		
		return result;
	}


	@Override
	public UserVO selectByLogin(UserVO vo) {
		return userDao.selectByLogin(vo);
	}


	@Override
	public UserVO selectByMypage(int midx) {
		return userDao.selectByMypage(midx);
	}


	@Override
	public int modify(UserVO vo) {
		return userDao.modify(vo);
	}



}
