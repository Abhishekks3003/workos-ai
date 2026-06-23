package com.abhishek.workos.auth.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;

    private String name;

    private String email;

    private String password;

    public User() {
        System.out.println("Constructor Called");
    }

    public void SetName(String name){
        this.name=name;
    }
    public String GetName(){
        return this.name;
    }

}
//User user=new User(); creating new user
//new User() ->allocate memory in ram all varibale will have null values
//User user=reference variable stores(memoryaddess) allocated in stack
//heap ->actual memory address where object is created