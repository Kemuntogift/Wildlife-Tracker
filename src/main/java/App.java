import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {


    public static void main(String[] args) {
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

        //get request....animal view/animals
        get("/animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());



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

        //follows through post method on form
        post("/sighting/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            int location_id= Integer.parseInt(request.queryParams("location"));
            int ranger_id= Integer.parseInt(request.queryParams("ranger"));
            int animal_id= Integer.parseInt(request.queryParams("animal"));

            Sightings sighting=new Sightings(location_id,ranger_id,animal_id);
            sighting.save();
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        //get sightings shown on sighting.hbs
        get("/sightings",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            List<Sightings> sightings=Sightings.all();
            ArrayList<String> animals=new ArrayList<String>();
            ArrayList<String> types=new ArrayList<String>();
            for (Sightings sighting : sightings){
                String animal_name=EndangeredAnimal.find(sighting.getAnimal_id()).getName();
                String animal_type=EndangeredAnimal.find(sighting.getAnimal_id()).getType();
                animals.add(animal_name);
                types.add(animal_type);
            }
            model.put("sightings",sightings);
            model.put("animals",animals);
            model.put("types",types);
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());


    }}