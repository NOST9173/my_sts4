package edu.board.service;

import edu.board.vo.UserVO;

public interface UserService {
	int insertUser(UserVO vo);
	UserVO selectByLogin(UserVO vo);
	UserVO selectByMypage(int midx);
	int modify(UserVO vo);
}
