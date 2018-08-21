package com.rongzi.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    // 过滤器的类型，决定过滤器在请求的哪个生命周期中执行
    // pre 表示在请求被路由之前执行
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序， 当存在多个过滤器时使用这个方法
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断该过滤器是否应该被执行， 可以用来指定过滤器的有效范围
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send() request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null){
            log.warn("access token is null");

            //不对请求进行路由
            ctx.setSendZuulResponse(false);

            ctx.setResponseStatusCode(401);
            return null;
        }

        log.info("access token ok");
        return null;
    }
}
