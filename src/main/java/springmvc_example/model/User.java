package springmvc_example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.PreparedStatement;
import java.util.Date;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable=true)
    private String name;

    @Column(name="surname",nullable = true)
    private String surname;

    @Column(name="password",nullable = true)
    private String password;

    @Column(name="email",nullable = true)
    private String email;

    @Column(name = "created_at",nullable = true)
    private Date date;




}