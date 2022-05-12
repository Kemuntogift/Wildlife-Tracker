import org.sql2o.Connection;

import java.util.List;


public class EndangeredAnimal extends Animal implements DatabaseManagement {

    public static final String ANIMAL_TYPE="endangered";



    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.age = age;
        this.health = health;
        type = ANIMAL_TYPE;
//throw exception if fields are empty
        if (name.isEmpty() || health.isEmpty() || age.isEmpty()){
            throw new IllegalArgumentException("Please fill out all fields.");
        }
    }



    public static List<EndangeredAnimal> endangeredAll(){
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
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newAnimal = (EndangeredAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getHealth().equals(newAnimal.getHealth()) &&
                    this.getAge().equals(newAnimal.getAge());
        }
    }
}
