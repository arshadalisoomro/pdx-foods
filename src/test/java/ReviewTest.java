
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReviewTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/pdx_foods_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteReviewsQuery = "DELETE FROM reviews *;";
      String deleteRestaurantsQuery = "DELETE FROM restaurants *;";
      con.createQuery(deleteReviewsQuery).executeUpdate();
      con.createQuery(deleteRestaurantsQuery).executeUpdate();
    }
  }

  @Test
  public void review_instantiatesCorrectly_true() {
    Review myReview = new Review("Just the best!");
    assertEquals(true, myReview instanceof Review);
  }
}
