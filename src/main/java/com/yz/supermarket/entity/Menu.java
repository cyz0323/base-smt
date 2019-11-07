package com.yz.supermarket.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer parentId;
	private String menuCode;
	private String menuName;
	private String menuNameUs;
	private String menuUrl;
	private Integer menuType;
	private String icon;
	private Integer sort;
	private String note;
	private Date createDate;
	private String createPerson;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuNameUs() {
		return menuNameUs;
	}
	public void setMenuNameUs(String menuNameUs) {
		this.menuNameUs = menuNameUs;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", parentId=" + parentId + ", menuCode=" + menuCode + ", menuName=" + menuName
				+ ", menuNameUs=" + menuNameUs + ", menuUrl=" + menuUrl + ", menuType=" + menuType + ", icon=" + icon
				+ ", sort=" + sort + ", note=" + note + ", createDate=" + createDate + ", createPerson=" + createPerson
				+ "]";
	}
}
