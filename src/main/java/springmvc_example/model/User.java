package springmvc_example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.*;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="username", nullable=true)
    private String username;

    @Column(name="password",nullable = true)
    private String password;

    @Column(name="email",nullable = true)
    private String email;

    @Column(name = "created_at",nullable = true)
    private Date date;
    @JsonManagedReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();
}