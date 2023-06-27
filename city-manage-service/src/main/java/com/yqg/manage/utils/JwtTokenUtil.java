package com.yqg.manage.utils;

import com.yqg.manage.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//JwtToken工具类
@Component
@Slf4j
public class JwtTokenUtil {
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    private long expiration = Constants.EXPIRATION_TIME;//一个小时

    public long getExpiration(){
        return expiration;
    }

    /**
     * 根据用户信息生成token
     * 包含信息有 userName userId pharmacyId account createTime
     * @param user 对象
     * @return 返回token
     */
    public String generateToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName",user.getUsername());
        claims.put("UserId",user.getId());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
     * 通过key从token的claims中获取指定值
     *
     * @param token
     * @param key
     * @return 返回结果，如果没有获取到则返回空
     */
    public <T> T getValueFormClaims(String token,String key,Class<T> cla){
        T res;
        try{
            Claims claims = getClaimsFromToken(token);
            res = claims.get(key,cla);
        }catch(Exception e){
            res=null;
        }
        return res;
    }

    /**
     * 判断token是否可以被刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token){
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }



    /**
     * 从token中获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return claims;
    }

    /**
     * 根据荷载生成JWT token
     * @param claims
     * @return
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 生成token失效时间
     * @return
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
}
