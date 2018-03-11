package com.rainea.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: CustomeExceptionResolver.java</p>
 * <p>Description: 自定义异常处理器类</p>
 * @author liulang
 * @date   Apr 15, 2017
 * @version 
 */
public class CustomeExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object,
            Exception exception) {
        CustomeException customeException = null;
        //自定义异常
        if (exception instanceof CustomeException) {
            customeException = (CustomeException)exception;
        } else {
            //系统异常
            customeException = new CustomeException("未知异常");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", customeException.getMessage());
        mv.setViewName("error");
        return mv;
    }

}
