package com.cafe24.shoppingmall.vo;

public class CategoryVo {
	private Long no;
	private int groupNo;
	private String code;
	private String name;
	private int sortNo;
	private int depth;
	private Long parentCategoryNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Long getParentCategoryNo() {
		return parentCategoryNo;
	}

	public void setParentCategoryNo(Long parentCategoryNo) {
		this.parentCategoryNo = parentCategoryNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", groupNo=" + groupNo + ", code=" + code + ", name=" + name + ", sortNo="
				+ sortNo + ", depth=" + depth + ", parentCategoryNo=" + parentCategoryNo + "]";
	}

}
