package com.example.spring1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring1.model.InternationalOrg;
import com.example.spring1.services.Servicess;

@Controller

@RequestMapping("/international_orgs")

public class Controlller
{
	@Autowired

	private Servicess repo;

	

	@GetMapping({"","/"})

	public String showInternationalOrgList(Model model)

	{

	List<InternationalOrg>  international_orgs= repo.findAll();

		model.addAttribute("international_orgs",international_orgs);

		return "international_orgs/index";

}
}