package com.example.bikram.realmproject;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealHelper {

    Realm realm;

    public RealHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final ModelClass model) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ModelClass m = realm.copyToRealm(model);

            }
        });

    }


    public ArrayList<String> getData() {


        ArrayList<String> names = new ArrayList<>();
        RealmResults<ModelClass> namesRealmResults = realm.where(ModelClass.class).findAll();


        for (ModelClass model : namesRealmResults
                ) {

            names.add(model.getName());


        }

        return names;

    }

}
