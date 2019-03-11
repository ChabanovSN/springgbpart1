package ru.chabanov.spring.endpoint;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.chabanov.spring.endpoint.additional.GetAdRequest;
import ru.chabanov.spring.endpoint.additional.GetAdResponse;
import ru.chabanov.spring.model.Ad;
import ru.chabanov.spring.service.AdService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AdEndpointBean {

    @Autowired
    private AdService adService;

    @PayloadRoot(namespace = "http://chabanov.ru/spring",
            localPart = "getAdRequest")
    @ResponsePayload
    public GetAdResponse getUserRequest(@RequestPayload GetAdRequest request) {
        GetAdResponse response = new GetAdResponse();
        response.setAd(adService.get(request.getId()));
        return response;
    }

}
