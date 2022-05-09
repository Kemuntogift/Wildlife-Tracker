import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
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


        //get animal-form
        get("/animal-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get animal view/animals
        get("/animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());
    }
}