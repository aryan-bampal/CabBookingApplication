package com.capg.cba.exception;


	public class CustomerNotFoundException extends RuntimeException{
	    /**
		 * 
		 */
    private static final long serialVersionUID = 5993566510559691503L;

	public CustomerNotFoundException(String string){
	super(string);
	}

	 public CustomerNotFoundException(String string,Throwable e){
	 super(string,e);
	 }
	 }


