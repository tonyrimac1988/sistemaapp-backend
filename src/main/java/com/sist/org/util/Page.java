package com.sist.org.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class Page<T> {
	
	private List<T>  content = new ArrayList<>();
	private int totalElements  ;
	
	
	
	
}
