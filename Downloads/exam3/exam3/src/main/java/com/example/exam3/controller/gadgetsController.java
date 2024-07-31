package com.example.exam3.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.exam3.model.gadgets;
import com.example.exam3.model.gadgetsDto;
import com.example.exam3.services.gadgetsRepository;

import jakarta.validation.Valid;

@Controller

@RequestMapping("/gadgets")
public class gadgetsController 
{

	@Autowired

	private gadgetsRepository repo;

	

	@GetMapping({"","/"})

	public String showproductList(Model model)

	{

		List<gadgets> gadgets = repo.findAll();

		model.addAttribute("gadgets",gadgets);

		return "gadgets/index";

}
	@GetMapping({"/carousel"})

	public String carousel(Model model)

	{

	List<gadgets> gadgets = repo.findAll();

		model.addAttribute("gadgets",gadgets);

		return "gadgets/carousel";

	}
	
	@GetMapping("/create")

	public String showCreatePage(Model model)

	{

		gadgetsDto gadgetsDto = new gadgetsDto(); 

		model.addAttribute("gadgetsDto", gadgetsDto);

		return "gadgets/Creategadgets";

		

	}

	@PostMapping("/create")

	public String creategadgets(

			@Valid @ModelAttribute gadgetsDto gadgetsDto,

			BindingResult result			

			)

	{

		try {

			if(gadgetsDto.getImageFile().isEmpty())

			{

				result.addError(new FieldError("gadgetsDto","imageFile","The image file is required"));

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		

		if(result.hasErrors())

		{

			return "gadgets/Creategadgets";

		}

		

		MultipartFile image = gadgetsDto.getImageFile();

		

		Date createdAt = new Date();

		String storageFileName = createdAt.getTime()+"_"+image.getOriginalFilename();

		

		try

	{

			String uploadDir = "public/imagess/";

			Path uploadPath = Paths.get(uploadDir);

			

			if(!Files.exists(uploadPath))

			{

				Files.createDirectories(uploadPath);

				

			}

			

		try(InputStream inputStream = image.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName),

					StandardCopyOption.REPLACE_EXISTING);

		}			

	}catch(Exception ex)

		{

		

			System.out.println("Exception : " +ex.getMessage());

			

		}

		

		gadgets gadgets = new gadgets();

		gadgets.setName(gadgetsDto.getName());

		gadgets.setBrand(gadgetsDto.getBrand());

		gadgets.setCategory(gadgetsDto.getCategory());

		gadgets.setPrice(gadgetsDto.getPrice());

		
		gadgets.setImageFileName(storageFileName);

		

		repo.save(gadgets);

		

		return "redirect:/gadgets";

		

	}
	
	
}
