import org.sql2o.*;
import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Band Tracker");
  }

  @Test
  public void bandIsCreatedTest() {
    Venue myVenue1 = new Venue("Moda Center", "Portland");
    myVenue1.save();
    goTo("http://localhost:4567/");
    click("a", withText("Add a new Band"));
    fill("#name").with("Red Hot Chili Peppers");
    click("label", withText("Moda Center"));
    submit(".btn");
    assertThat(pageSource()).contains("Red Hot Chili Peppers");
    assertThat(pageSource()).contains("Moda Center");
  }

  @Test
  public void bandIsViewableTest() {
    Venue myVenue1 = new Venue("Moda Center", "Portland");
    myVenue1.save();
    goTo("http://localhost:4567/");
    click("a", withText("Add a new Band"));
    fill("#name").with("Red Hot Chili Peppers");
    click("label", withText("Moda Center"));
    submit(".btn");
    goTo("http://localhost:4567/");
    click("a", withText("View All Bands"));
    assertThat(pageSource()).contains("Red Hot Chili Peppers");
  }

  @Test
  public void venueIsCreated() {
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    fill("#name").with("Moda Center");
    fill("#located").with("Portland");
    submit(".btn");
    assertThat(pageSource()).contains("Moda Center");
  }


  @Test
  public void bandIsCreatedAndAddToVenue() {
    goTo("http://localhost:4567/");
    click("a", withText("View Venues"));
    fill("#name").with("Staples Center");
    fill("#located").with("Los Angeles");
    submit(".btn");
    click("a", withText("Home"));
    click("a", withText("Add a new Band"));
    fill("#name").with("Red Hot Chili Peppers");
    click("label", withText("Staples Center"));
    submit(".btn");
    click("a", withText("Home"));
    click("a", withText("View Venues"));
    click("a", withText("Staples Center"));
    assertThat(pageSource()).contains("Red Hot Chili Peppers");
    assertThat(pageSource()).contains("Staples Center");
  }
  //
  // @Test
  // public void taskShowPageDisplaysDescription() {
  //   Task testTask = new Task("Mow the lawn", "2016-05-14");
  //   testTask.save();
  //   String url = String.format("http://localhost:4567/tasks/%d", testTask.getId());
  //   goTo(url);
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // @Test
  // public void taskIsAddedToCategory() {
  //   Category testCategory = new Category("Household chores");
  //   testCategory.save();
  //   Task testTask = new Task("Mow the lawn", "2016-05-14");
  //   testTask.save();
  //   String url = String.format("http://localhost:4567/categories/%d", testCategory.getId());
  //   goTo(url);
  //   fillSelect("#task_id").withText("Mow the lawn");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("<li>");
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // @Test
  // public void categoryIsAddedToTask() {
  //   Category testCategory = new Category("Household chores");
  //   testCategory.save();
  //   Task testTask = new Task("Mow the lawn", "2016-05-14");
  //   testTask.save();
  //   String url = String.format("http://localhost:4567/tasks/%d", testTask.getId());
  //   goTo(url);
  //   fillSelect("#category_id").withText("Household chores");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("<li>");
  //   assertThat(pageSource()).contains("Household chores");
  // }

}
