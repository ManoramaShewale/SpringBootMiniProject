package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import java.util.Optional;
//import java.util.Scanner;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.demorepo;

@Service
public class demoService {

    @Autowired
    demorepo rep;

    public void Add(User use) {
        rep.save(use);
    }

    public List<User> show() {
        return rep.findAll();
    }

    public void delete(Integer id) {
        rep.deleteById(id);
    }

    public User getById(int id) {
        Optional<User> table = rep.findById(id);
        if (table.isPresent()) {
            return table.get();
        } else {
            return null;
        }
    }

    // public void show() {
    // List<User> ll = rep.findAll();
    // for (User use : ll) {
    // System.out.println(use.toString());
    // }
    // }

    // public void delet() {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("enter the id");
    // int id = sc.nextInt();
    // rep.deleteById(id);
    // }

    // public void change(User uu) {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("enter the id where u want to change");
    // int id = sc.nextInt();
    // Optional<User> ll = rep.findById(id);

    // if (ll.isPresent()) {
    // User data = ll.get();

    // System.out.println("eneter the new name");
    // String name = sc.next();
    // sc.nextLine();
    // System.out.println("enter the emailid");
    // String email = sc.next();

    // data.setName(name);
    // data.setEmail(email);

    // rep.save(data);
    // System.out.println("updated Succesfully");

    // } else {
    // System.out.println("id is not found");
    // }

}
