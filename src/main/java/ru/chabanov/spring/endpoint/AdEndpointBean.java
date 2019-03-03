package ru.chabanov.spring.endpoint;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.service.AdService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class AdEndpointBean {

    @Autowired
    private AdService adService;
    //@RequestParam("pageCounter") Integer pageCounter,
    // @RequestParam("number") Integer number,
    // @RequestParam("order") String order, @RequestParam("orderBy") String orderBy)
    @WebMethod
    public List<Ad> getAll(@WebParam(name = "pageCounter") Integer pageCounter,
                           @WebParam(name = "number") Integer number,
                           @WebParam(name = "order")  String order,
                           @WebParam(name = "orderBy")  String orderBy){
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
        return Lists.newArrayList(articlePage.iterator());

    }

    @WebMethod
    public Ad get( @WebParam(name = "id") Integer id){
      return adService.get(id);
    }

    @WebMethod
    public void save( @WebParam(name = "ad") Ad ad){
        adService.save(ad);
    }

    @WebMethod
    public List<Ad> getByCategoryId(@WebParam(name = "id") Integer id,
                                    @WebParam(name = "pageCounter") Integer pageCounter,
                                    @WebParam(name = "number") Integer number,
                                    @WebParam(name = "order")  String order,
                                    @WebParam(name = "orderBy")  String orderBy){

        Sort sort = null;
        if(order.equalsIgnoreCase("DESC")){

            sort = new Sort(Sort.Direction.DESC, orderBy);

        }else{
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        PageRequest pageable = new PageRequest(pageCounter,number, sort);
        Page<Ad> adPage = adService.getByCategoryId(id, pageable);

        return Lists.newArrayList(adPage.iterator());
    }
}
