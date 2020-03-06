package fr.unice.polytech.isa.dd.utils;

import javax.ejb.Singleton;

@Singleton
public class Database {

    public Database() {
        flush();
    }

    public void flush() {
    }

}