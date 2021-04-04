package com.bbs.utils;

import java.util.List;

/**
 * 分页工具类
 * @author admin
 *
 */

public class PageTool<T> {
	
	private Integer page;
	private Integer limit;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
