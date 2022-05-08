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
}