package com.direct.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.direct.entity.ClassInfo;
import com.direct.entity.StudentInfo;
import com.direct.service.IClassService;
import com.direct.service.IStudentService;
import com.direct.util.PageModel;
import com.github.pagehelper.Page;

@Controller
@RequestMapping(value = "/stuC")
public class StudentController {
	private Logger log=LoggerFactory.getLogger(StudentController.class);
	
	//定义service层的接口属性
	@Autowired
	@Qualifier("stuService")
	private IStudentService istuService;
	@Autowired
	@Qualifier("classService")
	private IClassService iclaService;
	
//	@GetMapping(value = "/stu")
//	public ModelAndView showStu() {
//		ModelAndView mav=new ModelAndView("show");
//		mav.addObject("slist", istuService.queryStu());
//		return mav;
//	}
	
	@GetMapping(value = "/stu")
	public ModelAndView showStu(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo) {
		ModelAndView mav=new ModelAndView("show");
		Page<StudentInfo> pg = istuService.queryStu(pageNo, 2);
		log.info("当前页："+pg.getPageNum());
		log.info("显示条数："+pg.getPageSize());
		log.info("总页数："+pg.getPages());
		log.info("总条数："+pg.getTotal());
		mav.addObject("pageNum", pg.getPageNum());
		mav.addObject("pages", pg.getPages());
		mav.addObject("total", pg.getTotal());
		mav.addObject("pageStu", pg);
		return mav;
	}
	
//	@GetMapping(value = "/stu")
//	public ModelAndView showStu(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo) {
//		ModelAndView mav=new ModelAndView("show");
//		PageModel<StudentInfo> pm = istuService.queryStu1(pageNo, 2);
//		mav.addObject("pageNum", pm.getCurrentPage());
//		mav.addObject("pages", pm.getSumPage());
//		mav.addObject("total", pm.getSumCount());
//		mav.addObject("pageStu", pm.getList());
//		return mav;
//	}
	
	//添加
	@GetMapping(value = "/change")
	public ModelAndView to_add() {
		ModelAndView mav=new ModelAndView("add");
		//查询班级信息
		List<ClassInfo> clist = iclaService.queryClass();
		mav.addObject("clist", clist);
		return mav;
	}
	@PostMapping(value = "stu")
	public ModelAndView add(StudentInfo stu) {
		ModelAndView mav=new ModelAndView("redirect:/stuC/stu");
		boolean flag = istuService.addStu(stu);
		if(!flag) {
			mav.setViewName("fail");
			mav.addObject("msg", "添加学生信息失败");
		}
		return mav;
	}
}
