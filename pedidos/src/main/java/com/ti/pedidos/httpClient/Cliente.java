package com.ti.pedidos.httpClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ti.pedidos.model.Burguer;

@FeignClient("burguer")
public interface Cliente {

    @RequestMapping(method = RequestMethod.GET, value = "/burguers/{id}")
    Burguer obter(@PathVariable String id);
    
}
