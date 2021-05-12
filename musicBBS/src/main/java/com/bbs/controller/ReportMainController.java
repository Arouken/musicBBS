package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.service.ReportMainService;

@Controller
@RequestMapping("/ReportMain")
public class ReportMainController {
	
	@Autowired
	private ReportMainService reportMainService;

}
