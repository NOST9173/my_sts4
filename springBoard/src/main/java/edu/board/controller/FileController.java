package edu.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping(value="/file")
@Controller
public class FileController {

	
	
	
	@RequestMapping(value="/sample.do")
	public String sample() {
		
		
		return "file/sample";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {  // 파일은 매개변수를 MultipartFile 로 가져온다.
		/*
		 개발 환경에서 워크스페이스 안에 둔 프로젝트를 was로 실행시 실제 프로젝트 위치는 워크스페이스가 아니라
		 was가 실행하는 위치 어딘가에 프로젝트를 복사해서 사용하게 된다.
		 이때 업로드 파일 경로를 워크스페이스내의 프로젝트 절대 경로를 사용하게 되면 was가 바라보는 위치로
		 파일을 복사하기까지 시간차가 발생하므로 즉시 반영이 되지 못한다.
		 업로드 위치를 실제 톰캣이 사용하는 프로젝트의 리얼 경로를 사용하게 되면 시간차가 발생하지 않아 즉시 반영이 가능하다.
		 (개발 환경에서만 발생하는 문제점이다.)
		 
		 */
	//										getServletContext까지 시스템경로.
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		File dir = new File(path); // path가 존재하는지 여부 확인.	
		if(!dir.exists()) {
			dir.mkdirs(); // mkdirs <-- s까지 붙여줘야 한다. 위치가 존재하지 않는 경우 위치 생성.
		}
		 // 
		if(!file.getOriginalFilename().isEmpty()) { // 화면에서 넘어온 파일이 존재한다면 
			file.transferTo(new File(path,file.getOriginalFilename())); // 화면에서 넘어온 파일을 path위치에 새로 쓰는 로직 
			
		}else {
			System.out.println("업로드할 파일이 존재하지 않습니다.");
		}
		
		
		
		return "redirect:/file/sample.do";
		
	}
	
}














