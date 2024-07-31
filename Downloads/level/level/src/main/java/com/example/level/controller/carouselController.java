package com.example.level.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.level.model.item;
import com.example.level.services.itemRepository;


@Controller

@RequestMapping("/carousel")
public class carouselController 
{
	@Autowired

	private itemRepository repo;
	
	@GetMapping({"","/"})

	public String showproductList(Model model)

	{

	List<item> item = repo.findAll();

		model.addAttribute("item",item);

		return "carousel/home";

	}
}
