import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;


public class NormalAnimal extends Animal implements DatabaseManagement {

    public static final String ANIMAL_TYPE="normal";



    public NormalAnimal(String name, String age) {
        this.name = name;
        this.age = age;
        type = ANIMAL_TYPE;
        //throw exception if fields are empty
        if (name.isEmpty() || age.isEmpty()){
            throw new IllegalArgumentException("Please fill out all fields.");
        }
    }


    public static List<NormalAnimal> normalAll(){
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
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof NormalAnimal)) {
            return false;
        } else {
            NormalAnimal newAnimal = (NormalAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getHealth().equals(newAnimal.getHealth()) &&
                    this.getAge().equals(newAnimal.getAge());
        }
    }

//    public static List<Object> getAnimals() {
//        List<Object> allAnimals = new ArrayList<Object>();
//
//        try(Connection connection = DB.sql2o.open()) {
//            String sqlNormal = "SELECT * FROM animals WHERE id=:id AND type='normal';";
//            List<NormalAnimal> normalAnimals = connection.createQuery(sqlNormal)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(NormalAnimal.class);
//            allAnimals.addAll(normalAnimals);
//
//            String sqlEndangered = "SELECT * FROM animals WHERE id=:id AND type='endangered-animal';";
//            List<EndangeredAnimal> endangeredAnimals = connection.createQuery(sqlEndangered)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(EndangeredAnimal.class);
//            allAnimals.addAll(endangeredAnimals);
//        }
//
//        return allAnimals;
//    }
}
