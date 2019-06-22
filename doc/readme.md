#### spring oauth2 的相关文档

* spring oauth2 的配置:

[spring oauth2 的授权的的uri](https://www.cnblogs.com/austinspark-jessylu/p/8065248.html)
```yaml
# oauth2 的文件的配置
security:
  oauth2: 
    client:
      # 指定OAuth2 client ID.
      clientId: resource1
      #客户端验证的密码
      clientSecret: secret
      # 获取验证码的 uri
      userAuthorizationUri: http://localhost:9005/oauth/authorize
      # 指定获取资源的access token的授权类型
      grant-type: password
      # 权限范围为read
      scope: read
      #指定获取access token的URI.
      access-token-uri: http://localhost:9005/oauth/token
 
    resource:
      #token解码的URI.
      token-info-uri: http://localhost:9005/oauth/check_token
      #user-info-uri原理是在授权服务器认证后将认证信息Principal通过形参绑定的方法通过URL的方式获取用户信息
      user-info-uri: http://localhost:9005/user
    authorization:
      check-token-access: http://localhost:9005/oauth/check_token

```