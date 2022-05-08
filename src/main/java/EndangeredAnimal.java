import org.sql2o.Connection;

import java.util.List;


public class EndangeredAnimal extends Animal implements DatabaseManagement {

    public static final String ANIMAL_TYPE="endangered";



    public EndangeredAnimal(String name, String age) {
        this.name = name;
        this.age = age;
        type = ANIMAL_TYPE;
    }


    public static List<EndangeredAnimal> all(){
        try (Connection con=DB.sql2o.open()) {
            String sql ="SELECT * FROM animals WHERE type='endangered';";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);

        }
    }
    public static EndangeredAnimal find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql= "SELECT * FROM animals WHERE id=:id";
            EndangeredAnimal animal=  con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;

        }

    }
}
