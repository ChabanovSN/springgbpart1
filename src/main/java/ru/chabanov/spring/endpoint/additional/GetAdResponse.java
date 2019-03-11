package ru.chabanov.spring.endpoint.additional;

import lombok.Getter;
import lombok.Setter;
import ru.chabanov.spring.model.Ad;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ad"
})
@XmlRootElement(name = "getAdResponse")
public class GetAdResponse {
    @Getter
    @Setter
    @XmlElement(required = true)
    protected Ad ad;
}
