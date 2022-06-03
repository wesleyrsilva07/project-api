package com.projetofinal.config.swagger;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiParam;

public class SwaggerPageable {
	
	@ApiParam(value = "Amount", example = "3")
	@Nullable
	private Integer size;
	
	@ApiParam(value = "Ordenation")
	@Nullable
	private String sort;
	
	@ApiParam(value = "Page", example = "0")
	@Nullable
	private Integer page;
	
	public String getSort() {
		return sort;
	}

	public Integer getPage() {
		return page;
	}
	
	public Integer getSize() {
		return size;
	}

	
	

}
