//функция для размещения полученных данных на странице
function renderingArticles(articles){

	articles.forEach(function(article){

		var test = $(articleBody).find(".article__title").attr("href",contextPath+"/articles/"+article["id"]).html(article["name"])
			.end().find(".article__date").html(article["publishedDate"])
			.end().find(".article__author").html(article["company"]["name"])
			.end().find(".article__content").html(article["content"].substring(0,110)+"...")
			.end().find(".article__category").html(article["categories"].name)
			.end().find(".more").attr("href",contextPath+"/articles/"+article["id"])
			.end().appendTo("#templatemo_content");

	});
}

//функция для осуществления асинхронного GET запроса
function loadArticles(){

	//формирование строки с данными, которые необходимо передать на сервер в метод listAjax
	var data="pageCounter="+pageCounter+"&"+"order="+order+"&"+"orderBy="+orderBy+"&"+"number="+number;

	$.ajax({
		url:url,
		type: 'GET',
		data:data,
		cache:false,
		success: function(articlesResponsive){

			if(articlesResponsive==0){



			}else{

				//если ответ содержит данные, то они размещаются на странице
				//а счетчик страниц(блоков) увеличивается на единицу
				renderingArticles(articlesResponsive["ads"]);
				pageCounter++;
			}
		},
	});
}

$(document).ready(function(){
	//первая страница(блок) статей подгружается при загрузке страницы
	loadArticles();

	$(".btn_load").click(function(){

		//остальные страницы подгружаются при нажатии на кнопку "Загрузить еще"
		loadArticles();

	})
});