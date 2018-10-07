package com.github.yanbin.auth.service;

import com.github.yanbin.auth.bean.ClientInfo;

import java.util.List;

public interface ClientService {
    public ClientInfo apply(String clientId, String secret);
    public List<String> getAllowedClient(String serviceId, String secret);
}
