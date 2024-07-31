package com.example.level.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.level.model.item;
import com.example.level.model.itemDto;
import com.example.level.services.itemRepository;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/item")
public class itemController 
{
	@Autowired

	private itemRepository repo;
	
	@GetMapping({"","/"})

	public String showproductList(Model model)

	{

	List<item> item = repo.findAll();

		model.addAttribute("item",item);

		return "item/index";

	}
	
	@GetMapping("/create")

	public String showCreatePage(Model model)

	{

		itemDto itemDto = new itemDto();

		model.addAttribute("itemDto", itemDto);

		return "item/Createitem";

		

	}

	

	@PostMapping("/create")

	public String createproduct(

			@Valid @ModelAttribute itemDto itemDto,

			BindingResult result			

			)

	{

		try {

			if(itemDto.getImageFile1().isEmpty())

			{

				result.addError(new FieldError("itemDto","imageFile1","The image file is required"));

			}
			if(itemDto.getImageFile2().isEmpty())

			{

				result.addError(new FieldError("itemDto","imageFile2","The image file is required"));

			}
			if(itemDto.getImageFile3().isEmpty())

			{

				result.addError(new FieldError("itemDto","imageFile3","The image file is required"));

			}
			if(itemDto.getImageFile4().isEmpty())

			{

				result.addError(new FieldError("itemDto","imageFile4","The image file is required"));

			}
			if(itemDto.getImageFile5().isEmpty())

			{

				result.addError(new FieldError("itemDto","imageFile5","The image file is required"));

			}



		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		

		if(result.hasErrors())

		{

			return "item/Createitem";

		}

		

		MultipartFile item1 = itemDto.getImageFile1();
		MultipartFile item2 = itemDto.getImageFile2();
		MultipartFile item3 = itemDto.getImageFile3();
		MultipartFile item4 = itemDto.getImageFile4();
		MultipartFile item5 = itemDto.getImageFile5();

		

		

		String storageFileName1 = item1.getOriginalFilename();
		String storageFileName2 = item2.getOriginalFilename();
		String storageFileName3 = item3.getOriginalFilename();
		String storageFileName4 = item4.getOriginalFilename();
		String storageFileName5 = item5.getOriginalFilename();

		

		try

	{

			String uploadDir = "public/iimages/";

			Path uploadPath = Paths.get(uploadDir);

			

			if(!Files.exists(uploadPath))

			{

				Files.createDirectories(uploadPath);

				

			}

			

		try(InputStream inputStream = item1.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName1),

					StandardCopyOption.REPLACE_EXISTING);

		}	
		try(InputStream inputStream = item2.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName2),

					StandardCopyOption.REPLACE_EXISTING);

		}			
		try(InputStream inputStream = item3.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName3),

					StandardCopyOption.REPLACE_EXISTING);

		}			
		try(InputStream inputStream = item4.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName4),

					StandardCopyOption.REPLACE_EXISTING);

		}			
		try(InputStream inputStream = item5.getInputStream())

		{

			Files.copy(inputStream, Paths.get(uploadDir + storageFileName5),

					StandardCopyOption.REPLACE_EXISTING);

		}			

	}catch(Exception ex)

		{

		

			System.out.println("Exception : " +ex.getMessage());

			

		}

		

		item item = new item();

		



		item.setImageFileName1(storageFileName1);
		item.setImageFileName2(storageFileName2);
		item.setImageFileName3(storageFileName3);
		item.setImageFileName4(storageFileName4);
		item.setImageFileName5(storageFileName5);

		

		repo.save(item);

		

		return "redirect:/item";

		

	}
	
	@GetMapping("/edit")
	public String showEditPage(
			Model model,
			@RequestParam int id
			) {
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item",item);
			
			itemDto itemDto = new itemDto();
			
		
			model.addAttribute("itemDto", itemDto);
			
		}
		catch(Exception e) {
			System.out.println("Exception : " +e.getMessage());
			return "redirect:/item";
			
		}
	return "item/Edititem";	
	}
	
	@PostMapping("/edit")
	public String updateitem(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute itemDto itemDto,
			BindingResult result
			) {
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item", item);
			
			if(result.hasErrors()) {
				return "item/Edititem";
			}
			
			if(!itemDto.getImageFile1().isEmpty()) {
				//for deleting the old images
				String uploadDir = "public/iimage/";
				Path oldImagePath = Paths.get(uploadDir  + item.getImageFileName1());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception e) {
					System.out.println("Exception: " +e.getMessage());
				}
				
				//save the new image
				MultipartFile item1 = itemDto.getImageFile1();
				
				String storageFileName1 =item1.getOriginalFilename();
				
				try(InputStream inputStream = item1.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName1),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
					((com.example.level.model.item) item).setImageFileName1(storageFileName1);
					
				}
			
			
			repo.save(item);
			

		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
			
		}
		
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item", item);
			
			if(result.hasErrors()) {
				return "item/Edititem";
			}
			
			if(!itemDto.getImageFile2().isEmpty()) {
				//for deleting the old images
				String uploadDir = "public/iimage/";
				Path oldImagePath = Paths.get(uploadDir  + item.getImageFileName2());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception e) {
					System.out.println("Exception: " +e.getMessage());
				}
				
				//save the new image
				MultipartFile item2 = itemDto.getImageFile2();
				
				String storageFileName2 =item2.getOriginalFilename();
				
				try(InputStream inputStream = item2.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName2),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
					((com.example.level.model.item) item).setImageFileName2(storageFileName2);
					
				}
			
			
			repo.save(item);
			

		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
			
		}
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item", item);
			
			if(result.hasErrors()) {
				return "item/Edititem";
			}
			
			if(!itemDto.getImageFile3().isEmpty()) {
				//for deleting the old images
				String uploadDir = "public/iimage/";
				Path oldImagePath = Paths.get(uploadDir  + item.getImageFileName3());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception e) {
					System.out.println("Exception: " +e.getMessage());
				}
				
				//save the new image
				MultipartFile item3 = itemDto.getImageFile3();
				
				String storageFileName3 =item3.getOriginalFilename();
				
				try(InputStream inputStream = item3.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName3),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
					((com.example.level.model.item) item).setImageFileName3(storageFileName3);
					
				}
			
			
			repo.save(item);
			

		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
			
		}
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item", item);
			
			if(result.hasErrors()) {
				return "item/Edititem";
			}
			
			if(!itemDto.getImageFile4().isEmpty()) {
				//for deleting the old images
				String uploadDir = "public/iimage/";
				Path oldImagePath = Paths.get(uploadDir  + item.getImageFileName4());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception e) {
					System.out.println("Exception: " +e.getMessage());
				}
				
				//save the new image
				MultipartFile item4 = itemDto.getImageFile4();
				
				String storageFileName4 =item4.getOriginalFilename();
				
				try(InputStream inputStream = item4.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName4),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
					((com.example.level.model.item) item).setImageFileName4(storageFileName4);
					
				}
			
			
			repo.save(item);
			

		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
			
		}
		try {
			item item = repo.findById(id).get();
			model.addAttribute("item", item);
			
			if(result.hasErrors()) {
				return "item/Edititem";
			}
			
			if(!itemDto.getImageFile5().isEmpty()) {
				//for deleting the old images
				String uploadDir = "public/iimage/";
				Path oldImagePath = Paths.get(uploadDir  + item.getImageFileName5());
				try {
					Files.delete(oldImagePath);
				}
				catch(Exception e) {
					System.out.println("Exception: " +e.getMessage());
				}
				
				//save the new image
				MultipartFile item5 = itemDto.getImageFile5();
				
				String storageFileName5 =item5.getOriginalFilename();
				
				try(InputStream inputStream = item5.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName5),
							StandardCopyOption.REPLACE_EXISTING);
					
				}
					((com.example.level.model.item) item).setImageFileName5(storageFileName5);
					
				}
			
			
			repo.save(item);
			

		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
			
		}
		
		
		
		return "redirect:/item";
		
	}
	
	@GetMapping("/delete")
	public String deleteProduct(
			@RequestParam int id
			) {
		try {
			item item = repo.findById(id).get();
			
			//for deleting the product image
			Path imagePath1 = Paths.get("public/iimage/" + item.getImageFileName1());
			Path imagePath2 = Paths.get("public/iimage/" + item.getImageFileName2());
			Path imagePath3 = Paths.get("public/iimage/" + item.getImageFileName3());
			Path imagePath4 = Paths.get("public/iimage/" + item.getImageFileName4());
			Path imagePath5 = Paths.get("public/iimage/" + item.getImageFileName5());
			
			try {
				Files.delete(imagePath1);
				Files.delete(imagePath2);
				Files.delete(imagePath3);
				Files.delete(imagePath4);
				Files.delete(imagePath5);
			}
			
			catch(Exception e) {
				System.out.println("Exception: " +e.getMessage());
				
			}
			
			//to delete the product
			
			repo.delete(item);
		}
		catch(Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
		return "redirect:/item";
	}
}
