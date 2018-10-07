package com.github.yanbin.common.util.jwt;

import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.util.KeyHelper;
import com.github.yanbin.common.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

public class JWTHelper {
    //密钥加密token
    public static String generateToken(IJWTInfo jwtInfo,String priKeyPath,int expire) throws Exception {

        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniquename())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    //公钥解析token
    public static Jws<Claims> parserToken(String token,String pubKeyPath) throws Exception {

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;


    }
    //获取token中的用户信息
    public static IJWTInfo getInfoFromToken(String token,String pubKeyPath) throws Exception {

        Jws<Claims> claimsJws = parserToken(token,pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)));

    }
}
