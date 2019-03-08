//Шаблон для размещения описания статьи в списке
var articleBody="<div class='post_section'>"+"<h2><a class='article__title' href='' ></a></h2>"+"<strong>Дата: </span></strong><span class='article__date'></span>|<strong>Компания: </strong><span class='article__author'></span>"
    +"<p><div class='article__content' style='word-wrap: break-word;'></div>"
    +"<div class='cleaner'></div>"
    +"<p><div class='category'>Категория: <span class='article__category'></span></div> <div class='button float_r'><a href=' ' class='more'>Читать далее</a></div>"+"<div class='cleaner'></div>"
    +"</div><div class='cleaner_h40'></div>";
//данные, которые передаются на сервер
//количество страниц
var number=4;
//порядок сортировки
var order="DESC";
//поле для сортировки
var orderBy="publishedDate";
//счетчик страниц(блоков)
var pageCounter=0;

//функция для размещения полученных данных на странице
function renderingArticles(ads){

	ads.forEach(function(ad){


		var test = $(articleBody).find(".article__title").attr("href",contextPath+"/articles/"+ad["id"]).html(ad["name"])
			.end().find(".article__date").html(ad["publishedDate"])
			.end().find(".article__author").html(ad["company"]["name"])
			.end().find(".article__content").html(ad["content"].substring(0,110)+"...")
			.end().find(".article__category").html(ad["categories"].name)
			.end().find(".more").attr("href",contextPath+"/articles/"+ad["id"])
			.end().appendTo("#templatemo_content");
          console.log(test);
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

				alert("Пусто");

			}else{
				console.log(articlesResponsive);
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