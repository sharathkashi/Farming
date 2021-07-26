package com.exam.boot.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "tbl_farmer")
public class FarmerEntity implements Serializable {

	private static final long serialVersionUID = 6325307718376939175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private Long farmerId;

	/*
	 * @Column(name = "file_name") private String fileName;
	 * 
	 * @Column(name = "fileType") private String fileType;
	 * 
	 * @Lob private byte[] data;
	 */
	@Column(name = "farmer_name")
	private String farmerName;

	@Column(name = "password")
	private String password;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "location")
	private String address;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "reg_date")
	private Date regDate;

	public FarmerEntity(Long farmerId, String farmerName, String password, String userName, String emailId,
			String mobileNumber, String address, String productName, String productImage, Date regDate) {
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.password = password;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.productName = productName;
		this.productImage = productImage;
		this.regDate = regDate;

	}

	/*
	 * public FarmerEntity(String fileName, String fileType, byte[] data) { super();
	 * this.fileName = fileName; this.fileType = fileType; this.data = data; }
	 * 
	 * public String getFileName() { return fileName; }
	 * 
	 * public void setFileName(String fileName) { this.fileName = fileName; }
	 * 
	 * public String getFileType() { return fileType; }
	 * 
	 * public void setFileType(String fileType) { this.fileType = fileType; }
	 * 
	 * public byte[] getData() { return data; }
	 * 
	 * public void setData(byte[] data) { this.data = data; }
	 */
	public FarmerEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FarmerEntity [farmerId=" + farmerId + ", farmerName=" + farmerName + ", password=" + password
				+ ", userName=" + userName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", productName=" + productName + ", productImage=" + productImage + ", regDate=" + regDate
				+ "]";
	}

	/*
	 * @Override public String toString() { return "FarmerEntity [farmerId=" +
	 * farmerId + ", fileName=" + fileName + ", fileType=" + fileType + ", data=" +
	 * Arrays.toString(data) + ", farmerName=" + farmerName + ", password=" +
	 * password + ", userName=" + userName + ", emailId=" + emailId +
	 * ", mobileNumber=" + mobileNumber + ", address=" + address + ", productName="
	 * + productName + ", productImage=" + productImage + ", regDate=" + regDate +
	 * "]"; }
	 */

}
