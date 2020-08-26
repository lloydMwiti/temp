import models.ListAll;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[]args){
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/animals";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "chowder");
        Person taskDao = new Person(sql2o);

        get("/",(request,response)->{
         Map<String,Object> model =new HashMap<String,Object>();
         return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/all",(request, response) -> {
            Map<String ,Object> model =new HashMap<String,Object>();
            List<ListAll> prs = taskDao.getAll();
            model.put("person",prs);
            return new ModelAndView(model,"entered.hbs");
        },new HandlebarsTemplateEngine());

        post("/from/new",(request,response) -> {
            Map<String,Object> model=new HashMap<String,Object>();
            Person person = new Person(sql2o);
            String ranger=request.queryParams("ranger");
            String name=request.queryParams("name");
            String health=request.queryParams("health");
            String age=request.queryParams("age");
            String endangered=request.queryParams("endangered");
            taskDao.AddPerson(ranger,name,health,age,endangered);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());


    }
}
