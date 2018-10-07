package com.github.yanbin.auth.service.impl;

import com.github.yanbin.auth.bean.ClientInfo;
import com.github.yanbin.auth.entity.Client;

import com.github.yanbin.auth.mapper.ClientMapper;
import com.github.yanbin.auth.service.ClientService;
import com.github.yanbin.common.exception.auth.ClientInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBClientService implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientInfo apply(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if(client==null||!client.getSecret().equals(secret)){
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return new ClientInfo(client.getCode(),client.getName(),client.getId().toString());
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        ClientInfo info = this.apply(clientId, secret);
        return clientMapper.selectAllowedClient(info.getId());
    }
}
