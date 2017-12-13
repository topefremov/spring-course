package org.efremov.daotest.domain;

import java.io.Serializable;
import java.sql.Date;

public class Singer implements Serializable {
	
	private static final long serialVersionUID = -5940821473581929372L;
	Long id;
	String firstName;
	String lastName;
	Date birthData;
	
	public Singer() {
		super();
	}

	public Singer(Long id, String firstName, String lastName, Date birthData) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthData = birthData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthData() {
		return birthData;
	}

	public void setBirthData(Date birthData) {
		this.birthData = birthData;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthData == null) ? 0 : birthData.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Singer other = (Singer) obj;
		if (birthData == null) {
			if (other.birthData != null)
				return false;
		} else if (!birthData.equals(other.birthData))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthData=" + birthData
				+ "]";
	}
	
}
