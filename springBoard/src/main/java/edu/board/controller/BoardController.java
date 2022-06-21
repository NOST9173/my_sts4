package edu.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.board.service.BoardService;
import edu.board.vo.BoardVO;
import edu.board.vo.SearchVO;
import edu.board.vo.UserVO;


// 여기 가상경로를 들어오려고하면 무조건 board 가 경유 되는 것이다.
@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model, SearchVO searchVO) {
		
		 System.out.println(searchVO);
		
		List<BoardVO> list = boardService.list(searchVO);
		
						// 첫번째 값은 , 두번째 값은 데이터.
		model.addAttribute("list", list);
		model.addAttribute("searchVO",searchVO);
		
		
		return "board/list";
	}
	
	
	
	
	
	
	@RequestMapping(value="/write.do" , method=RequestMethod.GET)
	public String write() {
		
		
		return "board/write";
	}

	
	@RequestMapping(value="write.do" , method=RequestMethod.POST)         // request와 session 가져온 것은 로그인 때문에 가져온 것.		
	public void write(BoardVO vo,HttpServletResponse response ,HttpServletRequest reqeust, HttpSession session) throws IOException {
		
		// 로그인 객체 가져 옴 
		session = reqeust.getSession();
		
		UserVO login = (UserVO)session.getAttribute("login");
		// 여기까지
		
		
		vo.setMidx(login.getMidx());
		
		
		int result = boardService.insert(vo); // 
		
		
		// 
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter(); // 화면에 html을 사용 가능 
		if(result <= 0) {
			// 등록이 제대로 이루어지지 않음.
			
			
			pw.append("<script>alert('등록되지 않았습니다');location.href='list.do'</script>"); // 다른페이지로 넘어가야하기에 redirect는 먹히지 않기에 list.do로 보내라.
			pw.flush(); //화면에 쓰는 곳이다.
			
		}else {
			pw.append("<script>alert('등록이 완료되었습니다');location.href='view.do?bidx="+vo.getBidx()+"'</script>");
			pw.flush();
		}
		
	
		
//		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/view.do") // 상세페이지를 가져와 출력해주는?
	public String view(int bidx, Model model) {
		
		BoardVO vo = boardService.selectOne(bidx);
		model.addAttribute("vo",vo);
		
		return "board/view";
	}
	
	
	
	
	
	
	
	
	

}
