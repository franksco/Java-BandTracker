import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class VenueTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Venue_instantiatesCorrectly_true() {
    Venue myVenue = new Venue("Moda Center", "13105");
    assertEquals(true, myVenue instanceof Venue);
  }

  @Test
  public void getName_VenueInstantiatesWithName_String() {
    Venue myVenue = new Venue("Moda Center", "portland");
    assertEquals("Moda Center", myVenue.getName());
  }

  @Test
  public void getLocation_VenueInstantiatesWithlocation_String() {
    Venue myVenue = new Venue("Moda Center", "portland");
    assertEquals("Moda Center", myVenue.getName());
  }

  @Test
  public void getId_VenueInstantiatesWithId_Int() {
    Venue myVenue = new Venue("Moda Center", "portland");
    myVenue.save();
    assertEquals(1, myVenue.getId());
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Venue.all().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Venue myVenue = new Venue("Moda Center", "portland");
    Venue myVenue2 = new Venue("Moda Center", "portland");
    assertTrue(myVenue.equals(myVenue2));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Venue myVenue = new Venue("Moda Center", "portland");
    myVenue.save();
    assertTrue(Venue.all().get(0).equals(myVenue));
  }

  // @Test
  // public void save_assignsIdToObject_int() {
  //   Venue myVenue = new Venue("Moda Center", "portland");
  //   myVenuesave();
  //   Venue savedVenue = Venueall().get(0);
  //   assertEquals(myVenuegetId(), savedVenuegetId());
  // }

  // @Test
  // public void find_findsVenueInDatabase_true() {
  //   Venue myVenue = new Venue("Moda Center", "portland");
  //   myVenuesave();
  //   Venue savedVenue = Venuefind(myVenuegetId());
  //   assertTrue(myVenueequals(savedVenue));
  // }

  // @Test
  // public void getBands_returnsAllBands_List() {
  //   Venue myVenue = new Venue("Moda Center", "portland"));
  //   myVenue.save();
  //   Band myBand = new Band("Red Hot Chili Peppers", array);
  //   myBand.save();
  //   List savedBands = myVenue.getBands();
  //   assertEquals(1, savedBands.size());
  // }

}
