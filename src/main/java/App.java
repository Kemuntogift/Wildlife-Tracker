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
//        get("/animal-form",(request, response) ->{
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "animal-form.hbs");
//        }, new HandlebarsTemplateEngine());


        //navigate to sighting form
        get("/sighting-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> allSights = Sightings.sightingsAll();
            model.put("allSights", allSights);
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        //Deals with posts from form and posts to sighting.hbs
        post("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animal");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String type = request.queryParams("type");

            NormalAnimal animal = new NormalAnimal(animalName, age);
            animal.save();
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,health,age);
            endangeredAnimal.save();
            Sightings newSighting = new Sightings(animalName,location,rangerName);
            newSighting.save();


            List<Sightings> allSightings = Sightings.sightingsAll();
            List<EndangeredAnimal> animals= EndangeredAnimal.endangeredAll();
            model.put("sightings", allSightings);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



    }
}