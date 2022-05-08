import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @BeforeEach
    void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
    }

    @AfterEach
    void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM animals *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
        }
    }
    @Test
    public void Animal_instantiatesWithName_String() {
        Animal testAnimal = new Animal("Simba", "normal");
        assertEquals("Simba", testAnimal.getName());
    }
    @Test
    public void Animal_instantiatesWithType_String() {
        Animal testAnimal = new Animal("Simba", "normal");
        assertEquals("normal", testAnimal.getType());
    }
    @Test
    public void equals_returnsTrueIfNameAndTypeAreSame_true() {
        Animal testAnimal = new Animal("Simba", "normal");
        Animal anotherAnimal = new Animal("Simba", "normal");
        assertTrue(testAnimal.equals(anotherAnimal));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Animal testAnimal = new Animal("Simba", "normal");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void save_assignsIdToAnimal() {
        Animal testAnimal = new Animal("Simba", "normal");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Simba", "normal");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Kangaroo", "normal");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Simba", "normal");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Kangaroo", "normal");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }
}