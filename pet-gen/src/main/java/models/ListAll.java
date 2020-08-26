package models;

import java.util.ArrayList;

public class ListAll {
    private int id;

    private String ranger;
    private String name;
    private String health;
    private String age;
    private String endangered;


    public void ListAll(String ranger,String name ,String health,String age ,String endangered){
        this.ranger=ranger;
        this.name=name;
        this.health=health;
        this.age=age;
        this.endangered=endangered;

    }

//getter methods

    public String getRanger() {
        return ranger;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getEndangered() {
        return endangered;
    }

    public int getId() {
        return id;
    }
}
