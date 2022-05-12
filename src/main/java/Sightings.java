import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private int animalId;
    private String animalName;
    private String rangerName;
    private String location;

    private Timestamp lastSeen;


    public Sightings(String animal, String location, String rangerName) {
        this.animalName = animal;
        this.location = location;
        this.rangerName = rangerName;



    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    //method to save sightings
    public void save() {

        if (this.animalName == "" || this.location == "" || this.rangerName == "") {
            //throw exception if fields are empty
            throw new IllegalArgumentException("Please fill all form fields");
        }
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalName, location, rangerName, lastSeen) VALUES (:animalName, :location, :rangerName, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();


        }

    }

    //gets list of all saved
    public static List<Sightings> sightingsAll() {
        try (Connection con = DB.sql2o.open()) {
            String sql = ("SELECT * FROM sightings");
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);

        }
    }

    //find by id assigned in database
    public static Sightings find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id &&
                location == sightings.location &&
                rangerName == sightings.rangerName &&
                animalId == sightings.animalId;
    }
    public static List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<Object>();

        try(Connection connection = DB.sql2o.open()) {
            String sqlNormal = "SELECT * FROM animals WHERE id=:id AND type='normal';";
            List<NormalAnimal> normalAnimals = connection.createQuery(sqlNormal)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimal.class);
            allAnimals.addAll(normalAnimals);

            String sqlEndangered = "SELECT * FROM animals WHERE id=:id AND type='endangered-animal';";
            List<EndangeredAnimal> endangeredAnimals = connection.createQuery(sqlEndangered)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);
        }

        return allAnimals;
    }
}
