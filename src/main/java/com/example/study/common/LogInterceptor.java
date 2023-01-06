package com.example.study.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/*
 *  HandlerMethod =>
 *  핸들러 정보는 어떤 핸들러 매핑을 사용하는가에 따라 달라짐 . 일반적으로 @Controller, @RequestMapping을 활용한 핸들러 매핑을 사용하는데
 *  이 경우 HandlerMethod가 넘어온다.
 *
 *  ResourceHttpRequestHanlder
 * @Controller가 아니라 / resource/static 와 같은 정적 리소스가 호출되는 경우 ResouceHttpRequestHandler 가 핸들러 정보로 넘어오기 떄문에
 * 타입에 딸라서 처리가 필요함.
 *
 * postHandle, afterCompletion
 * 종료 로그를 postHandle 이 아니라 afterCompletion에서 실행한 이유는 예외가 발생한 경우 postHandle 가 호출되지 않기 떄문이다
 * afterCompletion은 예외가 발생해도 호출되는 것을 보장함.
 * */




@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String Log_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(Log_ID, uuid);


        if (handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
        }

        log.info("REQUEST [{}] [{}] [{}]", uuid , requestURI, handler);
        return true; //false 는 진행 x

    }
    @Override
    public void postHandle(HttpServletRequest request , HttpServletResponse response, Object handler , ModelAndView modelAndView) throws Exception{
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        String requestURI = request.getRequestURI();
        String logId = (String)request.getAttribute(Log_ID);
        log.info("RESPONSE [{}] [{}]",logId, requestURI);
        if(ex != null){
            log.error("afterCompletion error!!!",ex);
        }
    }
}
