package com.pack.data;

import java.util.HashMap;

public class Data {
    private HashMap<String, String> idName = new HashMap<>();
    private HashMap<String,Integer> idClass = new HashMap<>();

    public HashMap<String, String> getIdData() {
        idName.put("103A","Anup");
        idName.put("103B","Bibek");
        idName.put("103C","Ramesh");
        idName.put("103D","Sagar");
        idName.put("103E","Sanjay");
        idName.put("103F","Ram");
        return idName;
    }

    public HashMap<String, Integer> getIdClass() {
        idClass.put("103A",1);
        idClass.put("103B",7);
        idClass.put("103C",8);
        idClass.put("103D",9);
        idClass.put("103E",6);
        idClass.put("103F",2);
        return idClass;
    }
}
