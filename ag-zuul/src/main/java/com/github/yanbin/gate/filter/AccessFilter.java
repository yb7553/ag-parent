package com.github.yanbin.gate.filter;


import com.alibaba.fastjson.JSON;
import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.util.jwt.IJWTInfo;
import com.github.yanbin.common.vo.BaseResponse;
import com.github.yanbin.gate.jwt.JWTUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;


@Component
public class AccessFilter extends ZuulFilter {

    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request =  ctx.getRequest();
        if(request.getRequestURI().substring("/api".length()).startsWith("/auth/jwt"))
               return null;
        String token = request.getHeader("access-token");
        try {
            IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);

            assertEquals(infoFromToken.getUniquename(),"admin");

        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE,"Token error or Token is Expired")));
            e.printStackTrace();
        }
        return null;
    }
}
