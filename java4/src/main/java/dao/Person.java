package dao;

import models.ListAll;
import models.RangerModel;
import models.connect;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.time.LocalDateTime;
import java.util.List;

public class Person implements connect {


    private final Sql2o sql2o;
    private int id;
    public Person(Sql2o sql2o){
        this.sql2o=sql2o;

    }

    public void AddPerson(String ranger,String name,String health,String age,String endangered,String region){
        String sql="INSERT INTO people (ranger ,name ,health, age, endangered,date,region) VALUES (:ranger ,:name ,:health, :age, :endangered,:date,:region)";
        LocalDateTime date=LocalDateTime.now();
        try(Connection con=this.sql2o.open()){
             con.createQuery(sql,true)
                    .addParameter("ranger",ranger)
                    .addParameter("name",name)
                    .addParameter("health",health)
                    .addParameter("age",age)
                    .addParameter("endangered",endangered)
                    .addParameter("date", date)
                    .addParameter("region",region)
                    .executeUpdate()
                     .getKey();
        }catch(Sql2oException e){
            System.out.println("failed");
            System.out.println(e);
        }
    }

    @Override
    public List<ListAll> getAll(){
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM people")
                    .executeAndFetch(ListAll.class);
        }
    }

    @Override
    public List<RangerModel> All() {
        return null;
    }

    @Override
    public void add(ListAll list) {

    }

    public int getId(){ return id;}


}
