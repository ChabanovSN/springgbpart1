package ru.chabanov.spring.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;


import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.model.Category;
import ru.chabanov.spring.model.Company;
import ru.chabanov.spring.service.AdService;
import ru.chabanov.spring.service.CategoryService;
import ru.chabanov.spring.web.ajax.ArticlesAjax;

@Controller
public class ArticleController {
	
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Метод перенаправляет клиента с адреса https://localhost:8080/lesson6/articles
	 * на https://localhost:8080/lesson6 (необходим для следования стилю REST)
	 * 
	 */
	@RequestMapping(value = "/articles",method=RequestMethod.GET)
	public String list(){
		
		 return "redirect:/";
		
	}
	
	/**
	 * 
	 * @param id - идентификатор статьи
	 * @param uiModel - данные 
	 * @return путь к странице отображения статьи
	 */
	
	@RequestMapping(value="/articles/{id}", method=RequestMethod.GET)
	public String view(@PathVariable("id") Integer id,Model uiModel){
		
		Ad article = adService.get(id);
		uiModel.addAttribute("article", article);
		return "article/view";
		
	}
	
	@RequestMapping(value="/articles/add", method= RequestMethod.GET)
	public String addForm(Model uiModel){
		//создание пустого объекта
		Ad article = new Ad();
		article.setPublishedDate(new Date());
		article.setCompany(new Company());
		//получение списка всех категорий для возможности выбора категории, к которо будет принадлежать создаваемая статья
		List<Category> categories = categoryService.getAll();
		//связывание объекта статьи с формой и добавление списка категорий на страницу
		uiModel.addAttribute("article", article).addAttribute("categories", categories);
		return "article/add";
		
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public String add(@ModelAttribute("article") Ad ad, BindingResult bindingResult, @RequestParam("categoryId") Integer categoryId){
		
		Category category = categoryService.get(categoryId);
		if(bindingResult.hasErrors() || category==null){
			
			return "redirect:/articles/add";
			
		}
		ad.setCategories(category);
		adService.save(ad);
		return "redirect:/";
	}

	/**
	 * Метод обрабатывающий асинхронный запрос 
	 */
	@RequestMapping(value="/articles/articles_ajax",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	/**
	 * @param pageCounter-текущая страница(блок из number статей)
	 * @param number - количество статей в одном блоке
	 * @param order - порядок сортировки(ASC-прямая, DESC-обратная)
	 * @param orderBy - поле по которому происходит сортировка
	 * @return объект класса ArticlesAjax, который содержит список статей, 
	 * данный объект преобразовывается в JSON-формат
	 */
	public ArticlesAjax listAjax(@RequestParam("pageCounter") Integer pageCounter, @RequestParam("number") Integer number, @RequestParam("order") String order, @RequestParam("orderBy") String orderBy){
		
		//объект, который будет содержать информацию о сортировке
		Sort sort = null;
		
		if(order.equalsIgnoreCase("DESC")){
			//конструктор Sort принимает в качестве параметров тип сортировки и поле,
			//по которому будет происходить соритровка
			sort = new Sort(Sort.Direction.DESC, orderBy);
			
		}else{
			
			
			sort = new Sort(Sort.Direction.ASC, orderBy);
		}
		//конструктор принимает полную информацию о текущем блоке,количестве статей и сортировке
		PageRequest pageable = new PageRequest(pageCounter,number, sort);
		
		Page<Ad> articlePage = adService.getAll(pageable);
		
		ArticlesAjax responsive =new  ArticlesAjax();
		//из объекта Page возвращаем итератор и с помощью библиотеки google guava создаем списочный массив
		responsive.setAds(Lists.newArrayList(articlePage.iterator()));
		System.out.println("ArticleController");
		responsive.getAds().forEach(System.out::println);
		return responsive;

     }
}
