package ip.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	
	
	@RequestMapping("/toStudent")
	public String toStudent(){
		return "student";
	}
	@RequestMapping("/findStudent")
	public String findStudent(int id){
		//Student st = serivceImpl.findStudentById(id);
		return "success";
	}
}
