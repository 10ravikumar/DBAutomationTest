import Data.Persons;
import database.DatabaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBCheckTest {
    DatabaseUtil databaseUtil;

    @BeforeEach
    void setUp(){
        databaseUtil = new DatabaseUtil();
    }

    @DisplayName("Test the Persons table should contains one record with Firstname as CHERRY")
    @Test
    void testPersonsFirstName() throws SQLException {
        String sqlQuery = "Select * from Persons";
        List<Persons> persons=databaseUtil.getQueryResultWithType(sqlQuery, Persons.class).stream()
                .filter(e ->e.FirstName().equals("CHERRY")).toList();

        assertEquals(1, persons.size());
        assertEquals("TOM", persons.get(0).LastName());
    }

    @DisplayName("Test the Persons table should contains two record with city as DELHI")
    @Test
    void testPersonsCityCount() throws SQLException {
        String sqlQuery = "Select * from Persons";
        List<Persons> persons=databaseUtil.getQueryResultWithType(sqlQuery, Persons.class).stream()
                .filter(e ->e.City().equals("DELHI")).toList();

        assertEquals(2, persons.size());
    }

}
