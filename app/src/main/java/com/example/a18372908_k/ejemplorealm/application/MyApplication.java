package com.example.a18372908_k.ejemplorealm.application;

import android.app.Application;

import com.example.a18372908_k.ejemplorealm.models.Dog;
import com.example.a18372908_k.ejemplorealm.models.Person;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {
    public static AtomicInteger PersonId = new AtomicInteger();
    public static AtomicInteger DogId = new AtomicInteger();

    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getInstance(config);
        PersonId = setAtomicId(realm, Person.class);
        DogId = setAtomicId(realm, Dog.class);

        realm.close();
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("Id").intValue()) : new AtomicInteger();
    }
}
