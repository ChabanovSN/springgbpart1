package ru.chabanov.spring.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.service.CategoryService;


@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model uiModel){
		List<Category> categories = categoryService.getAll();
		uiModel.addAttribute("categories",categories);

		return "home/main";
		
	}	
		
}
