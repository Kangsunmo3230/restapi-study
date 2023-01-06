package com.example.study.config;

import com.example.study.common.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration //설정파일을 만들기 위한 어노테이션 or Bean을 등록하기 위한 어노테이션
public class WebConfig implements WebMvcConfigurer {
    /*
     *  WebMvcConfigurer가 제공하는 addInterceptors()를 사용해서 인터셉터를 등록할 수 있다.
     *  registry.addIntercepto(new LogInterceptor()) : 인터셉터를 등록한다.
     *  order(1) : 인터셉터의 호출 순서를 지정한다. 낮을수록 먼저 호출.
     *  addPathPatterns("/**") : 인터셉터를 적용할 url 패턴을 지정함.
     *  excludePathPatterns(): 인터셉터에서 제외할 패턴을 지정함.
     *
     * */


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico","/error");
    }

}
