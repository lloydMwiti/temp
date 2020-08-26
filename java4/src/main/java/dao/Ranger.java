package dao;

import models.ListAll;
import models.RangerModel;
import models.connect;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Ranger implements connect {
    private Sql2o sql2o;
    private String name,email,badge;

    public Ranger(Sql2o sql2o){
        this.sql2o=sql2o;
    }
    public void addRanger(String name ,String email,String badge){
        String sql="INSERT INTO ranger (name,email,badge) VALUES (:name,:email,:badge)";
        try(Connection con=this.sql2o.open()){
            con.createQuery(sql,true)
                    .addParameter("name",name)
                    .addParameter("email",email)
                    .addParameter("badge",badge)
                    .executeUpdate()
                    .getKey();
        }catch(Sql2oException e){
            System.out.println("failed ,check if you have the correct compiles in the build.gradle and have a postgres db ->see readme.md");
            System.out.println(e);
        }

    }
    @Override
    public List<ListAll> getAll() {
        return null;
    }

    @Override
    public List<RangerModel> All() {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM ranger")
                    .executeAndFetch(RangerModel.class);
        }
    }

    @Override
    public void add(ListAll list) {

    }
    public Sql2o getSql2o() {
        return sql2o;
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
