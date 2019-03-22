package springmvc_example.service;

import springmvc_example.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public Post findById(int id);
    public void saveorupdate(Post post);
    public void deleteById(int id);
}
