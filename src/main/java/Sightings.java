import java.sql.Timestamp;
import java.util.Date;

public class Sightings {
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

}
