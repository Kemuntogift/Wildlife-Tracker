import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class SightingsTest {
    @BeforeEach
    void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
    }

    @AfterEach
    void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
    @Test
    public void Sightings_instantiatesWithLocationId_Integer() {
        Sightings testSightings = new Sightings(1, 2, 3);
        assertEquals(1, testSightings.getLocation_id());
    }
    @Test
    public void Sightings_instantiatesWithRangerId_Integer() {
        Sightings testSightings = new Sightings(1, 2, 3);
        assertEquals(2, testSightings.getRanger_id());
    }
    @Test
    public void Sightings_instantiatesWithAnimalId_Integer() {
        Sightings testSightings = new Sightings(1, 2, 3);
        assertEquals(2, testSightings.getAnimal_id());
    }
}