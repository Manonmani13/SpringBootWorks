package net.javaguides.springboot.web.dto;

public class ReminderDto {
private String name;
	
	private String date;
	
	private String message;
	
	private Long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ReminderDto(String name, String date, String message, Long userId) {
		super();
		this.name = name;
		this.date = date;
		this.message = message;
		this.userId = userId;
	}

	public ReminderDto() {
		super();
	}
	
}
