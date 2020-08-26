import models.ListAll;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class Person implements connect{


    private final Sql2o sql2o;
    private int id;
    public Person(Sql2o sql2o){
        this.sql2o=sql2o;

    }

    public void AddPerson(String ranger,String name,String health,String age,String endangered){
        String sql="INSERT INTO people (ranger ,name ,health, age, endangered) VALUES (:ranger ,:name ,:health, :age, :endangered)";
        try(Connection con=this.sql2o.open()){
             con.createQuery(sql,true)
                    .addParameter("ranger",ranger)
                    .addParameter("name",name)
                    .addParameter("health",health)
                    .addParameter("age",age)
                    .addParameter("endangered",endangered)
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
    public void add(ListAll list) {

    }

    public int getId(){ return id;}


}
