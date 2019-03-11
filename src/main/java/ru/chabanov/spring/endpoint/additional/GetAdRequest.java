package ru.chabanov.spring.endpoint.additional;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id"
})
@XmlRootElement(name = "getAdRequest")
public class GetAdRequest {
    @Getter
    @Setter
    @XmlElement(required = true)
    protected Integer id;
}
