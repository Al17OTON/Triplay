package com.triplay.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.member.service.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"*"}, maxAge = 60000)
public class MemberController {
	@Autowired
	private MemberService memberSer;
	
	
}
