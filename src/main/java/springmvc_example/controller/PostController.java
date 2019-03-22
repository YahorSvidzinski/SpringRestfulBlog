package springmvc_example.controller;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springmvc_example.model.Post;
import springmvc_example.model.User;
import springmvc_example.service.NotificationService;
import springmvc_example.service.PostService;
import springmvc_example.service.UserService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("project")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notifyService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/posts/view/{id}",method = RequestMethod.GET,headers = "Accept=application/json")
    public @ResponseBody Post view(@PathVariable("id") int id){
        Post post = postService.findById(id);
        if (post == null){
            notifyService.addErrorMessage("Cannot find post #"+id);
        }
        return post;
    }
    @RequestMapping(value = "/users/post/",method = RequestMethod.POST)
    public @ResponseBody Post add(@RequestBody Post post){
        postService.saveorupdate(post);
        return post;
   }

}
