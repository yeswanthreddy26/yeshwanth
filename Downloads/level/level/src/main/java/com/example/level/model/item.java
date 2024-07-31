package com.example.level.model;

import jakarta.persistence.*;


@Entity
@Table(name="item")
public class item
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition="TEXT")
	private String imageFileName1;
	private String imageFileName2;
	private String imageFileName3;
	private String imageFileName4;
	private String imageFileName5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageFileName1() {
		return imageFileName1;
	}
	public void setImageFileName1(String imageFileName1) {
		this.imageFileName1 = imageFileName1;
	}
	public String getImageFileName2() {
		return imageFileName2;
	}
	public void setImageFileName2(String imageFileName2) {
		this.imageFileName2 = imageFileName2;
	}
	public String getImageFileName3() {
		return imageFileName3;
	}
	public void setImageFileName3(String imageFileName3) {
		this.imageFileName3 = imageFileName3;
	}
	public String getImageFileName4() {
		return imageFileName4;
	}
	public void setImageFileName4(String imageFileName4) {
		this.imageFileName4 = imageFileName4;
	}
	public String getImageFileName5() {
		return imageFileName5;
	}
	public void setImageFileName5(String imageFileName5) {
		this.imageFileName5 = imageFileName5;
	}
	public item(int id, String imageFileName1, String imageFileName2, String imageFileName3, String imageFileName4,
			String imageFileName5) {
		super();
		this.id = id;
		this.imageFileName1 = imageFileName1;
		this.imageFileName2 = imageFileName2;
		this.imageFileName3 = imageFileName3;
		this.imageFileName4 = imageFileName4;
		this.imageFileName5 = imageFileName5;
	}
	public item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "item [id=" + id + ", imageFileName1=" + imageFileName1 + ", imageFileName2=" + imageFileName2
				+ ", imageFileName3=" + imageFileName3 + ", imageFileName4=" + imageFileName4 + ", imageFileName5="
				+ imageFileName5 + "]";
	}
	
	
}
