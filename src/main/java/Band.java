import java.util.List;
import org.sql2o.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Band {
  private int id;
  private String name;
  private List<Integer> checkedVenues = new ArrayList<Integer>();

  public Band(String name, String[] stringVenues) {
    this.name = name;
    List<Integer> intVenues = new ArrayList<Integer>();
      for(String stringtag : stringVenues){
        intVenues.add(Integer.parseInt(stringtag));
      }
    this.checkedVenues = intVenues;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Band> all() {
    String sql = "SELECT * FROM bands";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Band.class);
    }
  }

  @Override
  public boolean equals(Object otherBand) {
    if (!(otherBand instanceof Band)) {
      return false;
    } else {
      Band newBand = (Band) otherBand;
      return this.getName().equals(newBand.getName()) &&
      this.getId() == newBand.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO bands(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();

      for (Integer checkedvenue : this.checkedVenues) {
        String joinbands_venuesTableAdd = "INSERT INTO bands_venues (bands_id, venues_id) VALUES (:band_id, :venue_id)";
        con.createQuery(joinbands_venuesTableAdd)
        .addParameter("venue_id", checkedvenue)
        .addParameter("band_id", this.getId())
        .executeUpdate();
      }
    }
  }

  public static Band find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM bands where id=:id";
      Band band = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Band.class);
      return band;
    }
  }

  public void update(String newName, String[] stringVenues) {
    List<Integer> intVenues = new ArrayList<Integer>();
      for(String stringtag : stringVenues){
        intVenues.add(Integer.parseInt(stringtag));
      }
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE bands SET name = :name WHERE id = :id";
      con.createQuery(sql)
      .addParameter("name", newName)
      .addParameter("id", this.id)
      .executeUpdate();

      String joinDeleteQuery = "DELETE FROM bands_venues WHERE bands_id = :bandId";
        con.createQuery(joinDeleteQuery)
        .addParameter("bandId", this.getId())
        .executeUpdate();

      for (Integer checkedvenue : intVenues) {
        String joinbands_venuesTableAdd = "INSERT INTO bands_venues (bands_id, venues_id) VALUES (:band_id, :venue_id)";
        con.createQuery(joinbands_venuesTableAdd)
        .addParameter("venue_id", checkedvenue)
        .addParameter("band_id", this.getId())
        .executeUpdate();
      }
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM bands WHERE id = :id;";
      con.createQuery(deleteQuery)
      .addParameter("id", this.getId())
      .executeUpdate();

      String joinDeleteQuery = "DELETE FROM bands_venues WHERE bands_id = :bandId";
      con.createQuery(joinDeleteQuery)
      .addParameter("bandId", this.getId())
      .executeUpdate();
    }
  }

  public List<Venue> getVenues() {
    try(Connection con = DB.sql2o.open()){
      String joinQuery = "SELECT venues.* FROM bands JOIN bands_venues ON (bands.id = bands_venues.bands_id) JOIN venues ON (bands_venues.venues_id = venues.id) WHERE bands.id = :band_id ORDER BY venues.name";
      List<Venue> venues = con.createQuery(joinQuery)
      .addParameter("band_id", this.getId())
      .executeAndFetch(Venue.class);
      return venues;
    }
  }

}
