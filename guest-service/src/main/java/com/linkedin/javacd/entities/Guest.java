package com.linkedin.javacd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GUEST")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GUEST_ID")
	private Long guestId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="IS_LOYALTY_MEMBER")
	private boolean isLoyaltyMember;

	public Guest() {
		
	}

	public Guest(Long guestId, String firstName, String lastName, boolean isLoyaltyMember) {
		super();
		this.guestId = guestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isLoyaltyMember = isLoyaltyMember;
	}

	public final Long getGuestId() {
		return guestId;
	}

	public final void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final boolean isLoyaltyMember() {
		return isLoyaltyMember;
	}

	public final void setLoyaltyMember(boolean isLoyaltyMember) {
		this.isLoyaltyMember = isLoyaltyMember;
	}
	
}
