import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //landing page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //get request....animal-form
        get("/animal-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());


        //navigate to sighting form
        get("/sighting-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get request for normal and endangered animals
        get("/sighting/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("normalAnimals",NormalAnimal.all());
            model.put("endangeredAnimals",EndangeredAnimal.all());
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());


    }}