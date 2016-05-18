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
  //
  // @Test
  // public void all_emptyAtFirst_0() {
  //   assertEquals(0, Recipe.all().size());
  // }
  //
  // @Test
  // public void equals_returnsTrueIfDescriptionsAretheSame_true() {
  //   Recipe firstRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   Recipe secondRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   assertTrue(firstRecipe.equals(secondRecipe));
  // }
  //
  // @Test
  // public void save_savesObjectIntoDatabase_true() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   assertTrue(Recipe.all().get(0).equals(myRecipe));
  // }
  //
  // @Test
  // public void save_assignsIdToObject_int() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   Recipe savedRecipe = Recipe.all().get(0);
  //   assertEquals(myRecipe.getId(), savedRecipe.getId());
  // }
  //
  // @Test
  // public void find_findsRecipeInDatabase_true() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   Recipe savedRecipe = Recipe.find(myRecipe.getId());
  //   assertTrue(myRecipe.equals(savedRecipe));
  // }
  //
  // @Test
  // public void update_updatesRecipeDescription_true() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   myRecipe.update("Take a nap");
  //   assertEquals("Take a nap", Recipe.find(myRecipe.getId()).getDescription());
  // }
  //
  // @Test
  // public void delete_deletesRecipe_true() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   int myRecipeId = myRecipe.getId();
  //   myRecipe.delete();
  //   assertEquals(null, Recipe.find(myRecipeId));
  // }
  //
  // @Test
  // public void addCategory_addsCategoryToRecipe() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   myRecipe.addCategory(myCategory);
  //   Category savedCategory = myRecipe.getCategories().get(0);
  //   assertTrue(myCategory.equals(savedCategory));
  // }
  //
  // @Test
  // public void getCategories_returnsAllCategories_List() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   myRecipe.addCategory(myCategory);
  //   List savedCategories = myRecipe.getCategories();
  //   assertEquals(1, savedCategories.size());
  // }
  //
  //
  // @Test
  // public void delete_deletesAllRecipesAndCategoriesAssociations() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   myRecipe.save();
  //   myRecipe.addCategory(myCategory);
  //   myRecipe.delete();
  //   assertEquals(0, myCategory.getRecipes().size());
  // }

}
