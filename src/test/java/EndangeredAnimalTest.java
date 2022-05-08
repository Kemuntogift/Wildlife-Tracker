import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class EndangeredAnimalTest {
    @BeforeEach
    void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
    }

    @AfterEach
    void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
        }
    }
    @Test
    public void EndangeredAnimal_instantiatesWithName_String() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        assertEquals("Kangaroo", testEndangeredAnimal.getName());
    }
    @Test
    public void EndangeredAnimal_instantiatesWithType_String() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        assertEquals("young", testEndangeredAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfNameAndTypeAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }
    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Panda", "adult");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Kangaroo", "young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Panda", "adult");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}