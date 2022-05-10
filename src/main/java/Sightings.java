import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private int animalId;
    private String rangerName;
    private String location;

    private Timestamp lastSeen;


    public Sightings(int animalId, String location, String rangerName) {
        this.location = location;
        this.rangerName = rangerName;
        this.animalId = animalId;


    }

    public int getId() {
        return id;
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

        if (this.animalId == -1 || this.location == "" || this.rangerName == "") {
            //throw exception if fields are empty
            throw new IllegalArgumentException("Please fill all form fields");
        }
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalId, location, rangerName, lastSeen) VALUES (:animalId, :location, :rangerName, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();


        }

    }

    //gets list of all saved
    public static List<Sightings> all() {
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

}
