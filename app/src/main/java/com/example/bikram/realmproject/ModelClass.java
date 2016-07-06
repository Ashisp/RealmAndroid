package com.example.bikram.realmproject;

import io.realm.RealmObject;

/**
 * Created by bikram on 7/1/16.
 */

public class ModelClass extends RealmObject {


private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
