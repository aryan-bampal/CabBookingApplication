package com.capg.cba.repository;


	public class CustomerNotFoundException extends RuntimeException{
	    /**
		 * 
		 */
    private static final long serialVersionUID = 5993566510559691503L;

	public CustomerNotFoundException(String msg){
	super(msg);
	}

	 public CustomerNotFoundException(String msg,Throwable e){
	 super(msg,e);
	 }
	 }
