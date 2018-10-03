package com.myapp.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
public class LoggingFilter extends ZuulFilter {
    Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    /*public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info(String.format("Method: %s Host: %s Path: %s QueryParams: %s",exchange.getRequest().getMethod(),
        exchange.getRequest().getURI().getHost(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getQueryParams()));
        return chain.filter(exchange);
    }*/

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("Method: %s, %s request to %s", request.getMethod(), request.getMethod(), request.getRequestURL().toString()));
        return null;
    }

}
