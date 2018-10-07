package com.github.yanbin.uc.rpc;

import com.github.yanbin.common.vo.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("ag-auth")
public interface ClientAuthRpc {
    @RequestMapping(value = "/client/myClient")
    public ObjectRestResponse<List<String>> getAllowClient(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);
}
