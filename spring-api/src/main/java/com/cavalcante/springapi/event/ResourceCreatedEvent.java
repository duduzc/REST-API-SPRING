package com.cavalcante.springapi.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

/**
 * @author Paulo Eduardo
 * @date 16/04/20
 * @version 0.0.1
 */

public class ResourceCreatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = -5992105042799465506L;
	
	private HttpServletResponse response;
	private Long id;

	public ResourceCreatedEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getId() {
		return id;
	}
}