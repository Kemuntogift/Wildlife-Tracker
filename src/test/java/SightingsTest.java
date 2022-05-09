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
        assertEquals(3, testSightings.getAnimal_id());
    }
    @Test
    public void equals_returnsTrueIfLocation_idRanger_idAndAnimal_idAreSame_true() {
        Sightings testSightings = new Sightings(1, 2, 3);
        Sightings anotherSightings = new Sightings(1, 2, 3);
        assertTrue(testSightings.equals(anotherSightings));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Sightings testSightings = new Sightings(1, 2, 3);
        testSightings.save();
        assertTrue(Sightings.all().get(0).equals(testSightings));
    }
    @Test
    public void save_assignsIdToSightings() {
        Sightings testSightings = new Sightings(1, 2, 3);
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(savedSightings.getId(), testSightings.getId());
    }
    @Test
    public void all_returnsAllInstancesOfSightings_true() {
        Sightings firstSightings = new Sightings(1, 2, 3);
        Sightings secondSightings = new Sightings(4, 2, 3);
        try{
        firstSightings.save();
        secondSightings.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSightings));
        assertEquals(true, Sightings.all().get(1).equals(secondSightings));
        }catch (IllegalArgumentException exception){
            System.out.println(exception);
        }
    }

    @Test
    public void find_returnsSightingsWithSameId_secondSightings() {
        Sightings firstSightings = new Sightings(1, 2, 3);
        firstSightings.save();
        Sightings secondSightings = new Sightings(4, 2, 3);
        secondSightings.save();
        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
    }
}
