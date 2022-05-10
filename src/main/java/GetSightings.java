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

    public GetSightings(String name,String health,String age,String location,String ranger,String type,Timestamp lastSeen){
        this.name = name;
        this.health = health;
        this.age = age;
        this.location = location;
        this.ranger = ranger;
        this.type = type;
        this.lastSeen = lastSeen;

    }
}
