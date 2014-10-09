package com.avalon.ftp.web.controllers.CustomException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.avalon.ftp.beans.exception.CustomExceptionMsg;


@ControllerAdvice
@EnableWebMvc
public class CustomExceptionController {
	
	protected static final Logger logger = Logger
			.getLogger(CustomExceptionController.class);	
	
	 		@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	 	    public ModelAndView  handleIOException(Exception exception,HttpServletRequest request){
		 	logger.info("handleIOException - Catching: " + exception.getClass().getSimpleName());
		 	ModelAndView model = new ModelAndView("CustomError");
		 	//Model model = null;
		 	model.addObject("msg","IoException");
	 	       // return "CustomError";
		 	return model;
	 	    }
	 
	 	    @ExceptionHandler(value=SQLException.class)
	 	    public ModelAndView handleSQLException(SQLException exception,HttpServletRequest request){
	 	    	logger.info("handleSQLException - Catching: " + exception.getClass().getSimpleName());
	 	    	ModelAndView model = new ModelAndView("CustomError");
	 	    	model.addObject("extype",exception.getClass().getSimpleName());
	 	    	//model.addObject("errcode",exception.getErrMsg());
	 	    	model.addObject("msg",exception.getMessage());
	 	        return model;
	 	    }
	 	    
	 	   @ExceptionHandler(NullPointerException.class)
	 	    public ModelAndView handleNullPointerException(NullPointerException exception,HttpServletRequest request){
	 		  logger.info("handleNullPointerException - Catching: " + exception.getClass().getName());
	 		  	ModelAndView model = new ModelAndView("CustomError");
	 		  	model.addObject("extype",exception.getClass().getSimpleName());
	 	    	//model.addObject("errcode",exception.getClass().getName());
	 	    	model.addObject("msg",exception.getMessage());
	 	        return model;
	 	    }
	 	   
	 	   @ExceptionHandler(CustomExceptionMsg.class)
	 	   public ModelAndView handleCustomException(CustomExceptionMsg exception,HttpServletRequest request){
	 		  logger.info("handleCustomException - Catching: " + exception.getErrCode());
	 		  	ModelAndView model = new ModelAndView("CustomError");
	 		  	model.addObject("extype",exception.getClass().getSimpleName());
	 	    	model.addObject("msg",exception.getErrMsg());
	 	    	model.addObject("errcode",exception.getErrCode());
	 	        return model;
	 	   }
	 

}
