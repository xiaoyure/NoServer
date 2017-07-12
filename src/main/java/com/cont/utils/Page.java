package com.cont.utils;

import java.util.List;

public class Page<T> {

	private int results;
	private List<T> rows;
	
	public Page(int results, List<T> rows) {
		super();
		this.results = results;
		this.rows = rows;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
