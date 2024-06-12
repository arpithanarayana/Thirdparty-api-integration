package com.te.tp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.tp.service.PostSeervice;


@RestController
@RequestMapping(path = "/api")
public class PostsController {
	@Autowired
	private PostSeervice postSeervice;
	
	@GetMapping(path = "/getPosts")
	public List<Map<String, Object>> getAllPosts(){
		return postSeervice.getPosts();
	}
	
	@GetMapping(path = "/getPostById/{id}")
	public Map<String, Object> getPostById(@PathVariable int id){
		return postSeervice.getPostById(id);
	}
	
	@PostMapping(path = "/insertPosts")
	public Map<String, Object> insertPost(@RequestBody Map<String, Object> map){
		return postSeervice.insertPost(map);
	}
	
	@PutMapping(path = "/updatePost/{id}")
	public Map<String, Object> updatePost(@RequestBody Map<String, Object> map, @PathVariable int id){
		return postSeervice.updatePost(map, id);
	}
	
	@DeleteMapping(path = "deletePostById/{id}")
	public Map<String, Object> deletePostById(@PathVariable int id){
		return postSeervice.deletePost(id);
	}
 
}
