package com.guestbook.dev.GuestBook;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Temporal;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class GuestBookEntity {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String guestName;
    /*@Basic(optional = false)
    @Column(name = "created_date", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;*/
    private String comment;
/*	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
*//*	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
*//*	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
*/    
}