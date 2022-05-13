//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SightingsTest {
//    @BeforeEach
//    void setUp() {
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
//    }
//
//    @AfterEach
//    void tearDown() {
//        try(Connection con = DB.sql2o.open()) {
//            String deleteSightingsQuery = "DELETE FROM sightings *;";
//            con.createQuery(deleteSightingsQuery).executeUpdate();
//        }
//    }
//    @Test
//    public void Sightings_instantiatesWithAnimalName_String() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        assertEquals("Lion", testSightings.getAnimalName());
//    }
//    @Test
//    public void Sightings_instantiatesWithLocation_String() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        assertEquals("Nairobi", testSightings.getLocation());
//    }
//    @Test
//    public void Sightings_instantiatesWithRanger_String() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        assertEquals("Daniel", testSightings.getRangerName());
//    }
//    @Test
//    public void equals_returnsTrueIfLocationRangerAndAnimal_idAreSame_true() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        Sightings anotherSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        assertTrue(testSightings.equals(anotherSightings));
//    }
//    @Test
//    public void save_returnsTrueIfDescriptionsAreTheSame() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        testSightings.save();
//        assertTrue(Sightings.sightingsAll().get(0).equals(testSightings));
//    }
//    @Test
//    public void save_assignsIdToSightings() {
//        Sightings testSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        testSightings.save();
//        Sightings savedSightings = Sightings.sightingsAll().get(0);
//        assertEquals(savedSightings.getId(), testSightings.getId());
//    }
//    //try catch exception thrown during saving
//    @Test
//    public void all_returnsAllInstancesOfSightings_true() {
//        Sightings firstSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        Sightings secondSightings = new Sightings("Panda", "Donholm", "Beryl");
//        try{
//        firstSightings.save();
//        secondSightings.save();
//        assertEquals(true, Sightings.sightingsAll().get(0).equals(firstSightings));
//        assertEquals(true, Sightings.sightingsAll().get(1).equals(secondSightings));
//        }catch (IllegalArgumentException exception){
//            System.out.println(exception);
//        }
//    }
//
//    @Test
//    public void find_returnsSightingsWithSameId_secondSightings() {
//        Sightings firstSightings = new Sightings("Lion", "Nairobi", "Daniel");
//        firstSightings.save();
//        Sightings secondSightings = new Sightings("Panda", "Donholm", "Beryl");
//        secondSightings.save();
//        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
//    }
//
//}
