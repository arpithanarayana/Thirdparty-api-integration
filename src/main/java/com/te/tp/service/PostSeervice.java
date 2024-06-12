package com.te.tp.service;

import java.util.List;
import java.util.Map;

public interface PostSeervice {
	
	List<Map<String, Object>> getPosts();
	
	Map<String, Object> getPostById(int id);
	
	Map<String, Object> insertPost(Map<String, Object> map);
	
	Map<String, Object> updatePost(Map<String, Object> map, int id);
	
	Map<String, Object> deletePost(int id);

}
