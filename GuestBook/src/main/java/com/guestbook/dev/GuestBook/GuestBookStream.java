package com.guestbook.dev.GuestBook;

import java.util.Date;

public class GuestBookStream {

    private String guestName;
    private Date createdDate;
    private String comment;
    
	public GuestBookStream(String guestName, Date createdDate, String comment) {
		super();
		this.guestName = guestName;
		this.createdDate = createdDate;
		this.comment = comment;
	}
	
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
