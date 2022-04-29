package web.dto;

import java.util.Date;

public class Goods {

	private int gdsNum;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private int gdsStock; //상품 수량
	private String gdsDes; //설명
	private Date gdsDate; //등록날짜
	
	private String ImgOriginName; //이미지 원본이름
	private String ImgStoredName; //이미지 저장이름
	@Override
	public String toString() {
		return "Goods [gdsNum=" + gdsNum + ", gdsName=" + gdsName + ", cateCode=" + cateCode + ", gdsPrice=" + gdsPrice
				+ ", gdsStock=" + gdsStock + ", gdsDes=" + gdsDes + ", gdsDate=" + gdsDate + ", ImgOriginName="
				+ ImgOriginName + ", ImgStoredName=" + ImgStoredName + "]";
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getGdsStock() {
		return gdsStock;
	}
	public void setGdsStock(int gdsStock) {
		this.gdsStock = gdsStock;
	}
	public String getGdsDes() {
		return gdsDes;
	}
	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}
	public Date getGdsDate() {
		return gdsDate;
	}
	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	public String getImgOriginName() {
		return ImgOriginName;
	}
	public void setImgOriginName(String imgOriginName) {
		ImgOriginName = imgOriginName;
	}
	public String getImgStoredName() {
		return ImgStoredName;
	}
	public void setImgStoredName(String imgStoredName) {
		ImgStoredName = imgStoredName;
	}
	
	

	
	
	
	
	
	
}
