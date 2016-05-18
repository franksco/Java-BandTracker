import org.junit.rules.ExternalResource;
import org.sql2o.*;
import spark.Spark;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/band_tracker_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String createBandsQuery = "CREATE TABLE bands (id serial PRIMARY KEY, name varchar);";
      String createVenuesQuery = "CREATE TABLE venues (id serial PRIMARY KEY, name varchar, located varchar);";
      String createBandsVenuesQuery = "CREATE TABLE bands_venues (id serial PRIMARY KEY, band_id int, venue_id int); ";

      String deleteBandsQuery = "DROP TABLE bands;";
      String deleteVenuesQuery = "DROP TABLE venues;";
      String deleteBandsVenuesQuery = "DROP TABLE bands_venues;";


      con.createQuery(createBandsQuery).executeUpdate();
      con.createQuery(createVenuesQuery).executeUpdate();
      con.createQuery(createBandsVenuesQuery).executeUpdate();

      con.createQuery(deleteBandsQuery).executeUpdate();
      con.createQuery(deleteVenuesQuery).executeUpdate();
      con.createQuery(deleteBandsVenuesQuery).executeUpdate();
    }
  }

}
