import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Animal {

    public int id;
    public String name;
    public String type;
   public String health;
   public String age;




    public String getName(){
        return name;
    }
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }
    public String getAge(){
        return age;
    }
    public String getHealth(){return health;}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return name.equals(animal.name) &&
//                type.equals(animal.type);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name,type);
//    }
    public void save(){
        try (Connection con=DB.sql2o.open()){
            String sql ="INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
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
    public static List<Animal> all(){
        try (Connection con=DB.sql2o.open()) {
            String sql ="SELECT * FROM animals";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);

        }
    }
//    public static Animal find(int id){
//        try (Connection con=DB.sql2o.open()){
//            String sql= "SELECT * FROM animals WHERE id=:id";
//            Animal animal=  con.createQuery(sql)
//                    .addParameter("id",id)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetchFirst(Animal.class);
//            return animal;
//
//        }
//
//    }
}
