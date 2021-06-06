package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date timesTamp;
	private String details;
	private String message;
	
	public ExceptionResponse(Date timesTamp, String details, String message) {
		this.timesTamp = timesTamp;
		this.details = details;
		this.message = message;
	}
	
	public Date getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Date timesTamp) {
		this.timesTamp = timesTamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
