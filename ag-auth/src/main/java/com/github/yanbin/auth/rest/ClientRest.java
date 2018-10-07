package com.github.yanbin.auth.rest;

import com.github.yanbin.auth.bean.ClientInfo;
import com.github.yanbin.auth.service.ClientService;
import com.github.yanbin.auth.util.ClientTokenUtil;
import com.github.yanbin.common.vo.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientRest {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ObjectRestResponse getAccessToken(String clientId,String secret) throws Exception {
        ClientInfo apply = clientService.apply(clientId,secret);
        return new ObjectRestResponse<String>().data(clientTokenUtil.generateToken(apply)) ;
    }
    @RequestMapping(value = "/myClient")
    public ObjectRestResponse getAllowClient(String serviceId, String secret){

        return new ObjectRestResponse<List<String>>().data(clientService.getAllowedClient(serviceId,secret));
    }
}
