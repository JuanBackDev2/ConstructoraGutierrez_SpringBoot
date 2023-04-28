package com.constructora.gutierrez.helpers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class Helpers {

	public static ModelMapper modelmapper() {
		return new ModelMapper();
		
	}
	
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> Helpers.modelmapper().map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	
	public static <S, T> Page<T> mapPage(Page<S> source, Class<T> targetClass) {
	    List<T> targetList = source.getContent()
	        .stream()
	        .map(element -> Helpers.modelmapper().map(element, targetClass))
	        .collect(Collectors.toList());

	    return new PageImpl<>(targetList, source.getPageable(), source.getTotalElements());
	}
	
}
