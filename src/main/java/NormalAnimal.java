import org.sql2o.Connection;

import java.util.List;


public class NormalAnimal extends Animal implements DatabaseManagement {

    public static final String ANIMAL_TYPE="normal";



    public NormalAnimal(String name, String age) {
        this.name = name;
        this.age = age;
        type = ANIMAL_TYPE;
    }


    public static List<NormalAnimal> all(){
        try (Connection con=DB.sql2o.open()) {
            String sql ="SELECT * FROM animals WHERE type='normal';";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimal.class);

        }
    }
    public static NormalAnimal find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql= "SELECT * FROM animals WHERE id=:id";
            NormalAnimal animal=  con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NormalAnimal.class);
            return animal;

        }

    }
}
