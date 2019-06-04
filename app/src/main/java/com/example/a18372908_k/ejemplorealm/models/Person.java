package com.example.a18372908_k.ejemplorealm.models;

import com.example.a18372908_k.ejemplorealm.application.MyApplication;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Person extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Name;
    private RealmList<Dog> Dogs;

    public Person(){}

    public Person(String name){
        Id = MyApplication.PersonId.incrementAndGet();
        Name = name;
        Dogs = new RealmList<Dog>();
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

    public RealmList<Dog> getDogs() {
        return Dogs;
    }
}
