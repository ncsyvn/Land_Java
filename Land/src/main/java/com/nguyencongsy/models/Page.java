package com.nguyencongsy.models;

import java.util.List;

public class Page<T> {
	public int PageNumber;
	public int PageSize;
	public int TotalNumberOfPages;
	public int TotalNumberOfRecords;
	public List<T> Results;
	
	public Page() {}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public List<T> getResults() {
		return Results;
	}
	public void setResults(List<T> results) {
		Results = results;
	}
	public int getTotalNumberOfPages() {
		return TotalNumberOfPages;
	}
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		TotalNumberOfPages = totalNumberOfPages;
	}
	public int getTotalNumberOfRecords() {
		return TotalNumberOfRecords;
	}
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		TotalNumberOfRecords = totalNumberOfRecords;
	}
	
	
}
