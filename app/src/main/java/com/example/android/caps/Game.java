package com.example.android.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db;

    public Game()
    {
        this.db = new CountryDB();
    }

    public String qa()
    {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (n * Math.random());
        String c = capitals.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        String country = ref.getName();
        String capital = ref.getCapital();
        String x;

        if(Math.random() < 0.5)
        {
             x = "What is the capital of " + country + "?" + "\n" + capital;
        }
        else
        {
            x = capital + " is the capital of? " + "\n" + country;
        }
        return x;
    }

    public static void main(String[] args) {
        Game game = new Game();
        String y = game.qa();
        System.out.println(y);
    }
}
