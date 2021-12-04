package com.capg.cba.repository;

public class CabNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 691444232083205662L;

	public CabNotFoundException(String msg){
	        super(msg);
	    }

	    public CabNotFoundException(String msg,Throwable e){
	        super(msg,e);
	    }
	}


