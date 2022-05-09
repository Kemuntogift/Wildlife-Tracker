import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private int location_id;
    private int ranger_id;
    private int animal_id;
    private Date date= new Date();
    private Timestamp time;



    public Sightings(int location_id, int ranger_id, int animal_id) {
        this.location_id = location_id;
        this.ranger_id = ranger_id;
        this.animal_id = animal_id;
        this.time = new Timestamp(date.getTime());
        this.id = id;

    }

public int getId(){
        return id;
}

    public int getLocation_id() {
        return location_id;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }
    public Timestamp getTime() {
        return time;
    }
    //method to save sightings
    public void save(){

        if(this.animal_id==-1||this.location_id==-1||this.ranger_id==-1){
            //throw exception if fields are empty
            throw new IllegalArgumentException("Please fill all form fields");
        }
        try (Connection con=DB.sql2o.open()){
            String sql= "INSERT INTO sightings (animal_id,ranger_id,location_id,time) VALUES (:animal_id,:ranger_id," +
                    ":location_id,:time)";

            this.id=(int) con.createQuery(sql,true)
                    .addParameter("animal_id",this.animal_id)
                    .addParameter("ranger_id",this.ranger_id)
                    .addParameter("location_id",this.location_id)
                    .addParameter("time",this.time)
                    .executeUpdate()
                    .getKey();


        }

    }
    //gets list of all saved
    public static List<Sightings> all(){
        try (Connection con =DB.sql2o.open()){
            String sql=("SELECT * FROM sightings");
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);

        }
    }
//find by id assigned in database
    public static Sightings find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sightings.class);

        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id &&
                location_id == sightings.location_id &&
                ranger_id == sightings.ranger_id &&
                animal_id == sightings.animal_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location_id, ranger_id, animal_id);
    }
}
