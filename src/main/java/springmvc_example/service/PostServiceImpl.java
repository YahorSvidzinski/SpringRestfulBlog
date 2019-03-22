package springmvc_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_example.dao.PostDao;
import springmvc_example.model.Post;
import springmvc_example.model.User;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }


    public List<Post> findAll() {
        return postDao.findAll();

    }


    public Post findById(int id) {
        /*return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);*/
        return postDao.findById(id);
    }




    public void saveorupdate(Post post) {
       /* post.setId((int) (this.posts.stream().mapToLong(
                        p -> p.getId()).max().getAsLong() + 1));
        this.posts.add(post);
        return post;*/
       postDao.saveorupdate(post);
    }


    //public Post edit(Post post) {
       /* for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found: " + post.getId());*/
   // }


    public void deleteById(int id) {
        /*for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), id)) {
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }*/
        postDao.deleteById(id);
    }
}
