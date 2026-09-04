package com.crisisConnect.CrisisConnect.masterService.authService;

import com.crisisConnect.CrisisConnect.masterService.dtos.UserCacheDTO;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

@Component
public class JwtService {

    @Value("${jwtSecret}")
    private static String secretKey;

    @Value("${jwtExpiration}")
    private long jwtExpiryTime;

    private static SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }


    public static UserCacheDTO extractUserCache(HttpServletRequest request){

        String token = request.getHeader("Authorization").split("Bearer ")[1];
        Claims userClaims = Jwts.parser().decryptWith(getSecretKey())
                .build().parseSignedClaims(token).getPayload();

        UserCacheDTO cacheDTO = new UserCacheDTO();
        if(null != userClaims){
            cacheDTO.setUserId(Long.valueOf(userClaims.get("userId").toString()));
            cacheDTO.setUsername(userClaims.get("userName").toString());
            cacheDTO.setEmail(userClaims.get("email").toString());
            cacheDTO.setRoles(new Gson().fromJson(userClaims.get("role").toString(), Map.class));
        }

        return cacheDTO;
    }

}
