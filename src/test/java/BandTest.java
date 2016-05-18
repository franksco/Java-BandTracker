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

  // @Test
  // public void getName_bandInstantiatesWithName_String() {
  //   String[] array = {"1", "3"};
  //   Band myBand = new Band("Red Hot Chili Peppers", array);
  //   assertEquals("Red Hot Chili Peppers", myBand.getName());
  // }

  // @Test
  // public void all_emptyAtFirst_0() {
  //   assertEquals(0, Category.all().size());
  // }
  //
  // @Test
  // public void equals_returnsTrueIfNamesAretheSame_true() {
  //   Category firstCategory = new Category("Household chores");
  //   Category secondCategory = new Category("Household chores");
  //   assertTrue(firstCategory.equals(secondCategory));
  // }
  //
  // @Test
  // public void save_savesObjectIntoDatabase_true() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   assertTrue(Category.all().get(0).equals(myCategory));
  // }
  //
  // @Test
  // public void save_assignsIdToObject_int() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Category savedCategory = Category.all().get(0);
  //   assertEquals(myCategory.getId(), savedCategory.getId());
  // }
  //
  // @Test
  // public void find_findCategoryInDatabase_true() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Category savedCategory = Category.find(myCategory.getId());
  //   assertTrue(myCategory.equals(savedCategory));
  // }
  //
  // @Test
  // public void addTask_addsTaskToCategory_true() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn", "2016-05-14");
  //   myTask.save();
  //   myCategory.addTask(myTask);
  //   Task savedTask = myCategory.getTasks().get(0);
  //   assertTrue(myTask.equals(savedTask));
  // }
  //
  // @Test
  // public void getTasks_returnsAllTasks_List() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn", "2016-05-14");
  //   myTask.save();
  //   myCategory.addTask(myTask);
  //   List savedTasks = myCategory.getTasks();
  //   assertEquals(1, savedTasks.size());
  // }
  //
  // @Test
  // public void delete_deletesAllTasksAndCategoriesAssociations() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Task myTask = new Task("Mow the lawn", "2016-05-14");
  //   myTask.save();
  //   myCategory.addTask(myTask);
  //   myCategory.delete();
  //   assertEquals(0, myTask.getCategories().size());
  // }

}
