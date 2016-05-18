import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class VenueTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly_true() {
    Venue myVenue = new Venue("Moda Center", "13105");
    assertEquals(true, myVenue instanceof Venue);
  }



  //
  // @Test
  // public void _3() {
  //   List<String> array1 = new ArrayList<String>();
  //   array1.add("1/2 cup of water");
  //   array1.add("1/2 cup of flour");
  //   array1.add("1/2 cup of milk");
  //   array1.add("1 cup of sugar");
  //   array1.add("1/2 tsp. of salt");
  //   List<String> array2 = new ArrayList<String>();
  //   array2.add("Mix water");
  //   array2.add("Mix flour");
  //   array2.add("Mix Milk");
  //   array2.add("Mix sugar");
  //   array2.add("Mix Salt");
  //   Recipe myRecipe1 = new Recipe("Brisket", array2, array1);
  //   myRecipe1.save();
  //   List<String> array3 = new ArrayList<String>();
  //   array3.add("1 cup of tabasco");
  //   array3.add("1 cup of habanero");
  //   array3.add("1 cup of jalepeno");
  //   List<String> array4 = new ArrayList<String>();
  //   array4.add("Mix tabasco");
  //   array4.add("Mix Habernro");
  //   array4.add("Mix Jalepeno");
  //   array4.add("Cook at 350");
  //   array4.add("Let cool for a little bit");
  //   Recipe myRecipe2 = new Recipe("fire", array4, array3);
  //   myRecipe2.save();
  //   List<String> expected1 = new ArrayList<String>();
  //   expected1.add("1/2 cup of water");
  //   expected1.add("1/2 cup of flour");
  //   expected1.add("1/2 cup of milk");
  //   expected1.add("1 cup of sugar");
  //   expected1.add("1/2 tsp. of salt");
  //   List<String> expected2 = new ArrayList<String>();
  //   expected2.add("Mix water");
  //   expected2.add("Mix flour");
  //   expected2.add("Mix Milk");
  //   expected2.add("Mix sugar");
  //   expected2.add("Mix Salt");
  //   assertEquals(expected1, myRecipe1.getIngredients());
  //   assertEquals(expected2, myRecipe1.getDirections());
  // }

  // @Test
  // public void getDescription_taskInstantiatesWithDescription_String() {
  //   Recipe myRecipe = new Recipe("Mow the lawn", "2016-05-14");
  //   assertEquals("Mow the lawn", myRecipe.getDescription());
  // }
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
