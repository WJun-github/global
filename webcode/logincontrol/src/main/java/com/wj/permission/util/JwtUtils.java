package com.wj.permission.util;

import com.wj.permission.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/25 0025
 * @description
 */
public class JwtUtils {

  public static final String TOKEN_HEADER = "Authorization";

  public static final String TOKEN_PREFIX = "Bearer ";

  public static final String SUBJECT = "permission";

  public static final long EXPIRE = 1000 * 60 * 60;

  public static final String APP_SECRET_KEY = "permission_secret";

  private static final String ROLE_CLAIMS = "role";

  public static String generateJsonWebToken(User user) {

    if (user.getId() == null || user.getUserName() == null || user.getPassword() == null) {
      return null;
    }

    Map<String, Object> map = new HashMap<>(16);
    map.put(ROLE_CLAIMS, "role");

    String token =
        Jwts.builder()
            .setSubject(SUBJECT)
            .setClaims(map)
            .claim("id", user.getId())
            .claim("name", user.getUserName())
            .claim("password", user.getPassword())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, APP_SECRET_KEY)
            .compact();
    return token;
  }

  /**
   * 生成token
   *
   * @param username
   * @param role
   * @return
   */
  public static String createToken(String username, String role) {

    Map<String, Object> map = new HashMap<>(16);
    map.put(ROLE_CLAIMS, role);

    String token =
        Jwts.builder()
            .setSubject(username)
            .setClaims(map)
            .claim("username", username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, APP_SECRET_KEY)
            .compact();
    return token;
  }

  public static Claims checkJWT(String token) {
    try {
      final Claims claims =
          Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
      return claims;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 获取用户名
   *
   * @param token
   * @return
   */
  public static String getUsername(String token) {
    Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
    return claims.get("username").toString();
  }

  /**
   * 获取用户角色
   *
   * @param token
   * @return
   */
  public static String getUserRole(String token) {
    Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
    return claims.get("role").toString();
  }

  /**
   * 是否过期
   *
   * @param token
   * @return
   */
  public static boolean isExpiration(String token) {
    Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
    return claims.getExpiration().before(new Date());
  }
}
