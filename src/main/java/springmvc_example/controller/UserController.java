package springmvc_example.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springmvc_example.model.User;
import springmvc_example.service.UserService;
@RestController
@RequestMapping("project")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users/", method=RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody List getListUser(){
        List users = userService.getListUser();

        return users;
    }

    @RequestMapping(value="/users/{id}",method =RequestMethod.GET,headers = "Accept=application/json")
    public @ResponseBody User getUser(@PathVariable("id") int id){
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping(value="/add/", method=RequestMethod.POST)
    public @ResponseBody User add(@RequestBody User user){
        java.sql.Date ourJavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        user.setDate(ourJavaDateObject);
        userService.saveOrUpdate(user);
        return user;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public @ResponseBody User update(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        userService.saveOrUpdate(user);

        return user;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public @ResponseBody User delete(@PathVariable("id") int id){
        User user = userService.findUserById(id);
        userService.deleteUser(id);
        return user;
    }

}