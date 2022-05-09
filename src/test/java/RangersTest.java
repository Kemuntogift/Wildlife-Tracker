import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class RangersTest {
    @BeforeEach
    void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "KEMUNTO543210");
    }

    @AfterEach
    void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String deleteSightingsQuery = "DELETE FROM rangers *;";
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
    @Test
    public void Rangers_instantiatesWithName_String() {
        Rangers testRangers = new Rangers("Mary",2);
        assertEquals("Mary", testRangers.getName());
    }
    @Test
    public void Rangers_instantiatesWithBadgeNumber_Integer() {
        Rangers testRangers = new Rangers("Mary",2);
        assertEquals(2, testRangers.getBadge_number());
    }
}