package com.example.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class NewsScraper {
	private Long Authorid;
    private String Authorname;
    private String AuthorDescription;
    
    @Id
    @Generated(value = { "" })
	public Long getAuthorid() {
		return Authorid;
	}
	public void setAuthorid(Long authorid) {
		Authorid = authorid;
	}
	/**
	 * @return the authorname
	 */
	public String getAuthorname() {
		return Authorname;
	}
	/**
	 * @param authorname the authorname to set
	 */
	public void setAuthorname(String authorname) {
		Authorname = authorname;
	}
	/**
	 * @return the authorDescription
	 */
	public String getAuthorDescription() {
		return AuthorDescription;
	}
	/**
	 * @param authorDescription the authorDescription to set
	 */
	public void setAuthorDescription(String authorDescription) {
		AuthorDescription = authorDescription;
	}
    

}
