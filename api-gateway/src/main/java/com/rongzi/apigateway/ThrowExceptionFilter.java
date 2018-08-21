package com.rongzi.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

// 过滤器的异常处理

@Component
public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

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
    public Object run() throws ZuulException {

        log.info("This is a pre filter, it will throw a RuntimeException");

        //异常处理： try ... catch ...
        RequestContext ctx = RequestContext.getCurrentContext();

//        try {
            doSomething();
//        }
//        catch (Exception e){
//            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ctx.set("error.exception", e);
//        }

        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors ... ");
    }
}
