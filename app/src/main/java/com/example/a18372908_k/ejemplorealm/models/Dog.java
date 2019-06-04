package com.example.a18372908_k.ejemplorealm.models;

import com.example.a18372908_k.ejemplorealm.application.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Dog extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Name;

    public Dog(){}

    public Dog(String name){
        Id = MyApplication.DogId.incrementAndGet();
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
