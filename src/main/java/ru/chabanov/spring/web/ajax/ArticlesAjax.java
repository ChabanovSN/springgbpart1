package ru.chabanov.spring.web.ajax;

import java.util.List;


import ru.chabanov.spring.model.Ad;

public class ArticlesAjax {
	
	
	private List<Ad> ads;

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
}
