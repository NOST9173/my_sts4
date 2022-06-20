package edu.board.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import edu.board.service.UserService;
import edu.board.service.UserServiceImple;
import edu.board.vo.UserVO;

@RequestMapping(value="/user")  // --> 질문해야할 것. 나는 왜 /user 없어도 되는건지 /6월16일 해결 . 
@Controller
public class UserController {
	
	// 컨트롤러는 화면에 데이터를 받고 주는 역할만 하는 것일 뿐 
	
	
	@Autowired
	UserService userService;
	
	
	
	
	
	@RequestMapping(value="/register.do" , method=RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	@RequestMapping(value="/register.do" , method=RequestMethod.POST)
	public String register(UserVO vo, Model model) {
		/*
		 	파라미터를 메소드로 전달 받는 방법은 매개변수의 명을 파라미터 키와 맞추는 방법과 
		 	매개변수 VO의 필드 명을 맞추는 방법이 있다.
		 */
		
		
//		model.addAttribute("name",name);
//		model.addAttribute("age", age);
//		model.addAttribute("addr", addr);
//		model.addAttribute("phone", phone);
		
		model.addAttribute("vo",vo);
		
		return "user/info";
		
	}
	
	// 링크는 무조건 get 방식이라 먼저 호출된다. 회원가입 링크를 클릭 했을 때 
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	// 회원가입에서 회원가입 버튼을 누르면 post방식이기에 아래 메서드로 넘어온다.
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserVO vo) {
		
		
		int result = userService.insertUser(vo);
		
		if(result == 1) {
			System.out.println("회원가입 성공 ");
		}else {
			System.out.println("회원가입 실패");
		}
		
		// 포워딩으로 하는거기에 url이 join.do 이고 화면은 메인이면 안되니까
		// redirect: 쓰고 경로값을 적으면 된다.
		return "redirect:/"; //리다이렉트 할때는 리턴 문자열에 redirect: 키워드 뒤로 url 경로 값을 준다.
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST )
	public String login(UserVO vo, HttpServletRequest request, HttpSession session) {
		
		UserVO user = userService.selectByLogin(vo);
		
		if(user != null) {
			
			session = request.getSession();
			
			
			// 세션에 담을 로그인 객체 생성해서 가져오기 
			UserVO login = new UserVO();
			login.setMidx(user.getMidx());
			login.setId(user.getId());
			login.setName(user.getName());
			
			session.setAttribute("login", login);
			
			
			return "redirect:/";
			
		}else {
			
			return "redirect:/user/login.do";
		}
		
		
		
	}
	
										// 뒤에 메서드 정의 안하면 get, post 모든 방식이 이쪽으로 들어온다.
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request, HttpSession session) {
		
		session = request.getSession();
		session.invalidate();		
		
		
		/*
		UserVO vo = (UserVO)session.getAttribute("login");
		int midx = vo.getMidx();
		*/
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/mypage.do")
	public String myPage(HttpServletRequest request, HttpSession session, Model model) {
		
		// 세션을 꺼내오는 것은 매개변수에 getSession으로 
		session = request.getSession();
		
		// 로그인 객체를 꺼내오는 
		UserVO login = (UserVO)session.getAttribute("login");
		
		// 로그인 객체의 상세정보 추출해오는 
		UserVO vo = userService.selectByMypage(login.getMidx());
		
		// 이 정보를 보내기 위해 모델을 사용하는데 모델은 디스팩처에서 가져올 수 있다. 
		model.addAttribute("vo", vo);
		
		
		return "user/mypage";
		
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modify(int midx, Model model) {
		
		// mypage에서 만들어놓은거 그대로 사용하기 // 네이밍을 신경써서 만들어줘야 한다.
		UserVO vo = userService.selectByMypage(midx);
		
		model.addAttribute("vo",vo);
		
		return "/user/modify";
		
		
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify(UserVO vo) {
		
		
		int result = userService.modify(vo);
		
		
		return "redirect:/user/mypage.do";
	}
	
	
	
	
	
	
}


















