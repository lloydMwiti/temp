package models;

public class RangerModel {
    private int id;
    private String name, email, badge;

    public void RangerModel(String name, String email, String badge) {
        this.name = name;
        this.email = email;
        this.badge = badge;
    }

//getter methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBadge() {
        return badge;
    }
}
