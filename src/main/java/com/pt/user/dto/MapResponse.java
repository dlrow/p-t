package com.pt.user.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Purpose:-
 * This  class holds ResponseMap to be sent to AA client.
 *
 * @author Abhijeet Raj
 * @version 1.0
 * @since   2019-07-28
 */
public class MapResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Map<String,String> response;

	public Map<String, String> getResponse() {
		return response;
	}

	public void setResponse(Map<String, String> response) {
		this.response = response;
	}

	public MapResponse() {
		super();
		response = new LinkedHashMap<>();
	}
	
	
    
}

