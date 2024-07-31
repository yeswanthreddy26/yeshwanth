package com.example.spring1.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="international_orgs")
public class InternationalOrg
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sno;
	private String OrgsName;
	private String HeadOffice;
	private String category;
	private int members;
	
	@Column(columnDefinition="TEXT")
	private Date createdAt;
	private String imageFileName;
	public int getsno() {
		return sno;
	}
	public void setsno(int sno) {
		this.sno = sno;
	}
	public String getOrgsName() {
		return OrgsName;
	}
	public void setOrgsName(String OrgsName) {
		this.OrgsName = OrgsName;
	}
	public String getHeadOffice() {
		return HeadOffice;
	}
	public void setHeadOffice(String HeadOffice) {
		this.HeadOffice = HeadOffice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getmembers() {
		return members;
	}
	public void setmembers(int members) {
		this.members = members;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public InternationalOrg(int sno, String OrgsName, String HeadOffice, String category, int members, Date createdAt,
			String imageFileName) {
		super();
		this.sno = sno;
		this.OrgsName = OrgsName;
		this.HeadOffice = HeadOffice;
		this.category = category;
		this.members = members;	
		this.createdAt = createdAt;
		this.imageFileName = imageFileName;
	}
	public InternationalOrg() 
	{
		super();
		
	}
	@Override
	public String toString() {
		return "InternationalOrgs [sno=" + sno + ", OrgsName=" + OrgsName + ", HeadOffice=" + HeadOffice + ", category=" + category + ",  members="
				+  members + ",  createdAt=" + createdAt + ", imageFileName="+ imageFileName + "]";
	}
	

}
