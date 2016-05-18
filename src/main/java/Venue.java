import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Venue {
  private int id;
  private String name;
  private String located;
  private int band_id;


  public Venue(String name, String located) {
    this.name = name;
    this.located = located;
  }

  public String getName() {
    return name;
  }

  public String getLocated() {
    return located;
  }

  public int getBandId() {
    return band_id;
  }

  public int getId() {
    return id;
  }


  public static List<Venue> all() {
    String sql = "SELECT * FROM venues";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Venue.class);
    }
  }

  @Override
  public boolean equals(Object otherVenue){
    if (!(otherVenue instanceof Venue)) {
      return false;
    } else {
      Venue newVenue = (Venue) otherVenue;
      return this.getName().equals(newVenue.getName())
      && this.getId() == newVenue.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO venues(name, located) VALUES (:name, :located)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("located", this.located)
      .executeUpdate()
      .getKey();
    }
  }

  public static Venue find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM venues where id=:id";
      Venue venue = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Venue.class);
      return venue;
    }
  }

  public List<Band> getBands() {
    try(Connection con = DB.sql2o.open()){
      String joinQuery = "SELECT bands.name FROM venues JOIN bands_venues ON (venues.id = bands_venues.venues_id) JOIN bands ON (bands_venues.bands_id = bands.id) WHERE venues.id = :venue_id ORDER BY bands.name";
      List<Band> bands = con.createQuery(joinQuery)
      .addParameter("venue_id", this.getId())
      .executeAndFetch(Band.class);
      return bands;
    }
  }
}
