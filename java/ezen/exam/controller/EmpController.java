package ezen.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.exam.service.EmpService;
import ezen.exam.vo.EmpVO;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private EmpService empService;


	// 사원 등록 페이지 이동
	@GetMapping(value = "/write")
	public void writeGET() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 사원 등록 페이지 진입");
	}

	// 사원 등록
	@PostMapping(value = "/write")
	public String writePost(EmpVO empVO) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> write 진입");

		/* 사원 등록 실행 */
		empService.employeeJoin(empVO);

		return "redirect:/employee/list";
	}

	// 사원 목록 페이지
	@GetMapping(value = "/list")
	public String list(Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 목록 페이지 진입");

		List<EmpVO> empList = empService.getEmployeeList();
		model.addAttribute("empList", empList);

		return "/employee/list";
	}

	// 사원 정보 조회
	@GetMapping(value = "/read")
	public String read(@RequestParam("empno") Integer empNo, Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 사원 정보 조회");

		EmpVO empVO = empService.getEmployeeByEmpNo(empNo);
		model.addAttribute("empVO", empVO);

		return "/employee/read";
	}

	// 사원 정보 삭제
	@DeleteMapping(value = "/remove/{empno}")
	@ResponseBody
	public String remove(@PathVariable("empno") Integer empNo) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 사원 정보 삭제");

		empService.deleteEmployee(empNo);

		return "success";
	}


}
