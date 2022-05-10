//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RangersTest {
//    @BeforeEach
//    void setUp() {
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
//    }
//
//    @AfterEach
//    void tearDown() {
//        try(Connection con = DB.sql2o.open()) {
//            String deleteRangersQuery = "DELETE FROM rangers *;";
//            con.createQuery(deleteRangersQuery).executeUpdate();
//        }
//    }
//    @Test
//    public void Rangers_instantiatesWithName_String() {
//        Rangers testRangers = new Rangers("Mary",2);
//        assertEquals("Mary", testRangers.getName());
//    }
//    @Test
//    public void Rangers_instantiatesWithBadgeNumber_Integer() {
//        Rangers testRangers = new Rangers("Mary",2);
//        assertEquals(2, testRangers.getBadge_number());
//    }
//    @Test
//    public void equals_returnsTrueIfNameAndBadgeNumberAreSame_true() {
//        Rangers testRangers = new Rangers("Mary",2);
//        Rangers anotherRangers = new Rangers("Mary",2);
//        assertTrue(testRangers.equals(anotherRangers));
//    }
//    @Test
//    public void save_returnsTrueIfDescriptionsAreTheSame() {
//        Rangers testRangers = new Rangers("Mary",2);
//        testRangers.save();
//        assertTrue(Rangers.all().get(0).equals(testRangers));
//    }
//    @Test
//    public void save_assignsIdToRangers() {
//        Rangers testRangers = new Rangers("Mary",2);
//        testRangers.save();
//        Rangers savedRangers = Rangers.all().get(0);
//        assertEquals(savedRangers.getId(), testRangers.getId());
//    }
//    //try catch exception thrown during saving
//    @Test
//    public void all_returnsAllInstancesOfRangers_true() {
//        Rangers firstRangers = new Rangers("Mary",2);
//        Rangers secondRangers = new Rangers("Billy",5);
//        try{
//            firstRangers.save();
//            secondRangers.save();
//            assertEquals(true, Rangers.all().get(0).equals(firstRangers));
//            assertEquals(true, Rangers.all().get(1).equals(secondRangers));
//        }catch (IllegalArgumentException exception){
//            System.out.println(exception);
//        }
//    }
//
//    @Test
//    public void find_returnsRangersWithSameId_secondRangers() {
//        Rangers firstRangers = new Rangers("Mary",2);
//        firstRangers.save();
//        Rangers secondRangers = new Rangers("Billy",5);
//        secondRangers.save();
//        assertEquals(Rangers.find(secondRangers.getId()), secondRangers);
//    }
//}
