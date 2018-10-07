package com.github.yanbin.uc.interceptor;

import com.github.yanbin.common.exception.auth.ClientForbiddenException;
import com.github.yanbin.common.util.jwt.IJWTInfo;
import com.github.yanbin.common.vo.BaseResponse;
import com.github.yanbin.common.vo.ObjectRestResponse;
import com.github.yanbin.uc.jwt.ClientTokenUtil;
import com.github.yanbin.uc.rpc.ClientAuthRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
public class ClientInterceptor extends HandlerInterceptorAdapter {
    private Logger logger= LoggerFactory.getLogger(ClientInterceptor.class);
    @Value("${client.token-header}")
    private  String tokenHeader;
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSectet;

    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private ClientAuthRpc clientAuthRpc;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("client interceptor.....");
        String token = request.getHeader(tokenHeader);
        IJWTInfo infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniquename = infoFromToken.getUniquename();

        BaseResponse resp = clientAuthRpc.getAllowClient(clientId,clientSectet);
        if(resp.getStatus()==200){
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            for(String client:allowedClient.getData()){
                if(client.equals(uniquename)){
                    return super.preHandle(request, response, handler);
                }
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
