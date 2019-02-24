package ru.chabanov.spring.web.ajax;

import java.util.List;


import ru.chabanov.spring.model.Ad;

public class ArticlesAjax {
	
	
	private List<Ad> ads;

	public List<Ad> getArticles() {
		return ads;
	}

	public void setArticles(List<Ad> ads) {
		this.ads = ads;
	}
	
	
	

}
