package com.te.tp.service;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.val;

@Service
public class PostServiceImpl implements PostSeervice{

	String baseUrl = "https://jsonplaceholder.typicode.com/";
	
	StringBuilder stringBuilder = new StringBuilder(baseUrl);
	String POST = "/posts";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	@Override
	public List<Map<String, Object>> getPosts() {
		HttpEntity<Void> httpEntity = new HttpEntity<Void>(getHeaders());
		String url = stringBuilder.append(POST).toString();
		val response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> getPostById(int id) {
		HttpEntity<Void> httpEntity = new HttpEntity<Void>(getHeaders());
		String url = stringBuilder.append(POST).append("/" + id).toString();
		val response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> insertPost(Map<String, Object> map) {
		HttpEntity<Map> httpEntity = new HttpEntity<>(map,getHeaders());
		String url = stringBuilder.append(POST).toString();
		val response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> updatePost(Map<String, Object> map, int id) {
		HttpEntity<Map> httpEntity = new HttpEntity<>(map,getHeaders());
		String url = stringBuilder.append(POST).append("/"+id).toString();
		val response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> deletePost(int id) {
		HttpEntity<Map> httpEntity = new HttpEntity<>(getHeaders());
		String url = stringBuilder.append(POST).append("/"+id).toString();
		val response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);
		return response.getBody();
	}
	
	

}
