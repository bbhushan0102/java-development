package org.studyeasy.hibernate_original_prj.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name="users")

public class Users {
    @Id
    @Column(name="user_id")
    int user_id;

    @Column (name="username")
    String username;

    @Column (name="email")
    String email;

    public Users(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Users() {

    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
