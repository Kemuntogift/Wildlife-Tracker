import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Rangers {
    private int id;

    private String name;
    private int badge_number;


    public Rangers(String name, int badge_number) {
        this.name = name;
        this.badge_number = badge_number;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getBadge_number() {
        return badge_number;
    }
    public int getId() {
        return id;
    }
    //throw exception for empty fields
    public void save(){

        if(this.name==""||this.badge_number==-1){
            //throw exception if fields are empty
            throw new IllegalArgumentException("Please fill all form fields");
        }
        try (Connection con=DB.sql2o.open()){
            String sql= "INSERT INTO rangers (name,badge_number) VALUES (:name,:badge_number)";

            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("badge_number",this.badge_number)
                    .executeUpdate()
                    .getKey();
        }

    }
    //gets list of all saved
    public static List<Rangers> all(){
        try (Connection con =DB.sql2o.open()){
            String sql=("SELECT * FROM rangers");
            return con.createQuery(sql)
                    .executeAndFetch(Rangers.class);

        }
    }
    //find by id assigned in database
    public static Rangers find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM rangers WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Rangers.class);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rangers rangers = (Rangers) o;
        return id == rangers.id &&
                name == rangers.name &&
                badge_number == rangers.badge_number;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, badge_number);
    }
}
