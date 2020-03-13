package fr.unice.polytech.isa.dd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {




    private Database() {

    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }



}