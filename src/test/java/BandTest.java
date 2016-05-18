import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly_true() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    assertEquals(true, myBand instanceof Band);
  }

  @Test
  public void getName_bandInstantiatesWithName_String() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    assertEquals("Red Hot Chili Peppers", myBand.getName());
  }

  @Test
  public void getId_bandInstantiatesWithId_Int() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    myBand.save();
    assertEquals("Red Hot Chili Peppers", myBand.getName());
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Band.all().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    Band myBand2 = new Band("Red Hot Chili Peppers", array);
    assertTrue(myBand.equals(myBand2));
  }

  @Test
  public void save_assignsIdToObject_int() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    myBand.save();
    Band savedBand = Band.all().get(0);
    assertEquals(myBand.getId(), savedBand.getId());
  }

  @Test
  public void find_findBandInDatabase_true() {
    String[] array = {"1", "3"};
    Band myBand = new Band("Red Hot Chili Peppers", array);
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertTrue(myBand.equals(savedBand));
  }

  // @Test
  // public void update_UpdateBand_true() {
  //   String[] array = {"1", "3"};
  //   Band myBand = new Band("Red Hot Chili Peppers", array);
  //   myBand.save();
  //   Band savedBand = Band.find(myBand.getId());
  //   myBand.update("Red Bot Chili Plankers", array);
  //   assertTrue(myBand.getName() !=myBandcopy.getName());
  // }

  // @Test
  // public void getVenues_returnsAllVenues_List() {
  //   String[] array = {"1", "3"};
  //   Band myBand = new Band("Red Hot Chili Peppers", array);
  //   myBand.save();
  //   Venue myVenue = new Venue("Moda Center", "portland");
  //   myVenue.save();
  //   List savedVenues = myBand.getVenues();
  //   assertEquals(1, savedVenues.size());
  // }

  // @Test
  // public void delete_deletesAllBandsAndVenuesAssociations() {
  //   String[] array = {"1", "3"};
  //   Band myBand = new Band("Red Hot Chili Peppers", array);
  //   myBand.save();
  //   Venue myVenue = new Venue("Moda Center", "portland");
  //   myVenue.save();
  //   myBand.delete();
  //   assertEquals(0, myVenue.getBands().size());
  // }

}
