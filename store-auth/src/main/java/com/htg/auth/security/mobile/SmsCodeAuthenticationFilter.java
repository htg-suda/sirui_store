package com.htg.auth.security.mobile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//短信验证码拦截器
@Slf4j
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private boolean postOnly = true;

    // 手机号参数变量
    private String mobileParameter = "mobile";
    private String smsCode = "smsCode";

    public SmsCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher("/mobile/login", "POST"));
    }

    /**
     * 添加未认证用户认证信息，然后在provider里面进行正式认证
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        log.info("==========> /mobile/token");
        if (postOnly && !httpServletRequest.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + httpServletRequest.getMethod());
        }

        String mobile = obtainMobile(httpServletRequest);
        String smsCode = obtainSmsCode(httpServletRequest);

        log.info("=======> mob :{} , code: {}", mobile, smsCode);
        //todo:验证短信验证码2
        if (mobile == null) {
            mobile = "";
        }

        mobile = mobile.trim();

        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile, smsCode);
        // Allow subclasses to set the "details" property
        setDetails(httpServletRequest, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 获取手机号
     */
    private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }

    private String obtainSmsCode(HttpServletRequest request) {
        return request.getParameter(smsCode);
    }

    private void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        Object details = authenticationDetailsSource.buildDetails(request);
        authRequest.setDetails(details);
    }

    public void setMobileParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.mobileParameter = usernameParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getMobileParameter() {
        return mobileParameter;
    }
}
