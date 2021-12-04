package com.capg.cba.repository;

public class DriverNotFoundException extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904296442365875528L;

	public DriverNotFoundException(String msg){
	        super(msg);
	    }

	    public DriverNotFoundException(String msg,Throwable e){
	        super(msg,e);
	    }
	}

