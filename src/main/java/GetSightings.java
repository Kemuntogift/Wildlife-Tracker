import java.sql.Timestamp;

public class GetSightings {
    private int animalId;
    private String location;
    private String ranger;
    private Timestamp lastSeen;
    public String name;
    public int id;
    public String health;
    public String age;
    public String type;

    //join animals and sightings constructors
    public GetSightings(String name,String health,String age,String location,String ranger,String type,Timestamp lastSeen){
        this.name = name;
        this.health = health;
        this.age = age;
        this.location = location;
        this.ranger = ranger;
        this.type = type;
        this.lastSeen = lastSeen;

    }
    public int getId() {
        return id;
    }
    public String getAge() {
        return age;
    }
    public String getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }
    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger() {
        return ranger;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }
}
