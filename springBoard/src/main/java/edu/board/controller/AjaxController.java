package edu.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.board.service.BoardService;
import edu.board.service.UserService;
import edu.board.vo.BoardVO;
import edu.board.vo.SearchVO;
import edu.board.vo.UserVO;


@RequestMapping(value="/ajax")
@Controller
public class AjaxController {
	
	@Autowired
	UserService userService;
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value="/sample.do")
	public String sample() {
		
		
		return "ajax/sample";
	}
	
	@ResponseBody													// charset=utf-8 -> 한글이 깨지니까 써주는 것.
	@RequestMapping(value="/userInfo.do", produces = "application/json;charset=utf-8")
	public UserVO userInfo(HttpServletRequest request, HttpSession session) {
		
		
		
		
		session = request.getSession();
		UserVO login = (UserVO)session.getAttribute("login");
		
		UserVO vo = userService.selectByMypage(login.getMidx());
		
		
		
		
		/*
		String result =  "유저정보 => id : "+vo.getId()
						+", password : "+vo.getPassword()
						+", name : "+vo.getName()
						+", midx : "+vo.getMidx();
		
		return  result;
		*/
		
		return vo;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/goText.do", produces = "application/text;charset=utf-8")
	public String goText(String text) {
		
		
		
		return text+"_ajax";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/boardList.do", produces = "application/json;charset=utf-8")
	public List<BoardVO> boardList(SearchVO vo){
		
		return boardService.list(vo);
		
		
	}

	
	@ResponseBody
	@RequestMapping(value="/boardView.do", produces = "application/json;charset=utf-8")
	public BoardVO boardView(int bidx) {
		
		return boardService.selectOne(bidx);		
	}
	
	
	
}













