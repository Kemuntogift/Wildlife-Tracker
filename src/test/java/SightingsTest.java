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
    public void Sightings_instantiatesWithAnimalId_Integer() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        assertEquals(1, testSightings.getAnimalId());
    }
    @Test
    public void Sightings_instantiatesWithLocation_String() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        assertEquals("Nairobi", testSightings.getLocation());
    }
    @Test
    public void Sightings_instantiatesWithRanger_String() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        assertEquals("Daniel", testSightings.getRanger());
    }
    @Test
    public void equals_returnsTrueIfLocationRangerAndAnimal_idAreSame_true() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        Sightings anotherSightings = new Sightings(1, "Nairobi", "Daniel");
        assertTrue(testSightings.equals(anotherSightings));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        testSightings.save();
        assertTrue(Sightings.all().get(0).equals(testSightings));
    }
    @Test
    public void save_assignsIdToSightings() {
        Sightings testSightings = new Sightings(1, "Nairobi", "Daniel");
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(savedSightings.getId(), testSightings.getId());
    }
    //try catch exception thrown during saving
    @Test
    public void all_returnsAllInstancesOfSightings_true() {
        Sightings firstSightings = new Sightings(1, "Nairobi", "Daniel");
        Sightings secondSightings = new Sightings(5, "Donholm", "Beryl");
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
        Sightings firstSightings = new Sightings(1, "Nairobi", "Daniel");
        firstSightings.save();
        Sightings secondSightings = new Sightings(5, "Donholm", "Beryl");
        secondSightings.save();
        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
    }
}
