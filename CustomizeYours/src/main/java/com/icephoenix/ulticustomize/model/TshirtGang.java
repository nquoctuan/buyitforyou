package com.icephoenix.ulticustomize.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TshirtGangs")
public class TshirtGang {

	@Id
	@JsonIgnore
	private String id;
	
	@Field
	private String title;
	
	@Field
	private String image;
	
	@Field
	private String styleId;
	
	@Field 
	private String color_id;
	
	@Field
	private String category_id;
}
