package com.test.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.IMoocJSONResult;

@ControllerAdvice
public class IMoocExceptionHandler {
	
	public static final String TEST_ERROR_VIEW ="error";
	
//	@ExceptionHandler(value = Exception.class)
//  public Object errorHandler(HttpServletRequest reqest, 
//  		HttpServletResponse response, Exception e) throws Exception {
//  	
//  	e.printStackTrace();
//  	
//		ModelAndView mav = new ModelAndView();
//      mav.addObject("exception", e);
//      mav.addObject("url", reqest.getRequestURL());
//      mav.setViewName(TEST_ERROR_VIEW);
//      return mav;
//  }
	
	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	//e.printStackTrace(); //后台输出异常
    	
    	if (isAjax(reqest)) {
    		return IMoocJSONResult.errorException(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(TEST_ERROR_VIEW);
            return mav;
    		}
	
		}

public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
		}
	}
