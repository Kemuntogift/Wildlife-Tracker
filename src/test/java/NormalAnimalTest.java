import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class NormalAnimalTest {
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
    public void NormalAnimal_instantiatesWithName_String() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Simba", "young");
        assertEquals("Simba", testNormalAnimal.getName());
    }
    @Test
    public void NormalAnimal_instantiatesWithAge_String() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Simba", "young");
        assertEquals("young", testNormalAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfNameAndTypeAreSame_true() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Simba", "young");
        NormalAnimal anotherNormalAnimal = new NormalAnimal("Simba", "young");
        assertTrue(testNormalAnimal.equals(anotherNormalAnimal));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Simba", "young");
        testNormalAnimal.save();
        assertTrue(NormalAnimal.all().get(0).equals(testNormalAnimal));
    }
    @Test
    public void save_assignsIdToNormalAnimal() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Simba", "young");
        testNormalAnimal.save();
        NormalAnimal savedNormalAnimal = NormalAnimal.all().get(0);
        assertEquals(savedNormalAnimal.getId(), testNormalAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfNormalAnimal_true() {
        NormalAnimal firstNormalAnimal = new NormalAnimal("Simba", "young");
        firstNormalAnimal.save();
        NormalAnimal secondNormalAnimal = new NormalAnimal("Kangaroo", "adult");
        secondNormalAnimal.save();
        assertEquals(true, NormalAnimal.all().get(0).equals(firstNormalAnimal));
        assertEquals(true, NormalAnimal.all().get(1).equals(secondNormalAnimal));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondNormalAnimal() {
        NormalAnimal firstNormalAnimal = new NormalAnimal("Simba", "young");
        firstNormalAnimal.save();
        NormalAnimal secondNormalAnimal = new NormalAnimal("Kangaroo", "adult");
        secondNormalAnimal.save();
        assertEquals(NormalAnimal.find(secondNormalAnimal.getId()), secondNormalAnimal);
    }
}