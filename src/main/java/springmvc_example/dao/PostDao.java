package springmvc_example.dao;

import springmvc_example.model.Post;

import java.util.List;

public interface PostDao {
    public List findAll();
    public Post findById(int id);
    public void saveorupdate(Post post);
    public void deleteById(int id);
}
