package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/input1.json");
    JsonNode data = mapper.readTree(inputFile).get("input");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    //iteration over data entries
    for (JsonNode entry : data) {
      Criteria criteria = new Criteria(entry);
      // classification
      if (criteria.planet.equals("Kashyyyk") || (!criteria.isHumanoid && criteria.age <= 400 && criteria.hasTraits("HAIRY", "TALL"))) {
        starWars.individuals().add(entry);
      } else if (criteria.planet.equals("Endor")) {
        starWars.individuals().add(entry);
      } else if (criteria.planet.equals("Asgard") || (!criteria.planet.equals("Earth") && criteria.isHumanoid && criteria.age <= 5000 && criteria.hasTraits("BLONDE", "TALL"))) {
        marvel.individuals().add(entry);
      } else if (criteria.planet.equals("Betelgeuse") || (criteria.age <= 100 && (criteria.hasTraits("EXTRA_ARMS") || criteria.hasTraits("EXTRA_HEAD")))) {
        hitchhikers.individuals().add(entry);
      } else if (criteria.planet.equals("Vogsphere") || (!criteria.planet.equals("Earth") && (!criteria.isHumanoid && (criteria.hasTraits("BULKY") || (criteria.hasTraits("GREEN") ) || (criteria.age <= 200 && criteria.hasTraits("GREEN")))))) {
        hitchhikers.individuals().add(entry);
      } else if (criteria.planet.equals("Earth") || (criteria.isHumanoid && criteria.age <= 8000)) {
        rings.individuals().add(entry);
      } else if (criteria.planet.equals("Earth") || (criteria.isHumanoid && criteria.hasTraits("BULKY"))) {
        rings.individuals().add(entry);
      } else {
        System.out.println("There are characters who don't match the right criteria");
      }
    }

    View view = new View(mapper);

    //storing data in json files
    view.writeToFile(starWars, "/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/starwars.json");
    view.writeToFile(hitchhikers, "/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/hitchhiker.json");
    view.writeToFile(rings, "/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/rings.json");
    view.writeToFile(marvel, "/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/marvel.json");
  }
}

class Criteria {
  public String planet;
  public boolean isHumanoid;
  public int age;
  public List<String> traits;

  public Criteria(JsonNode entry) {
    this.planet = entry.has("planet") ? entry.get("planet").asText() : "";
    this.isHumanoid = entry.has("isHumanoid") ? entry.get("isHumanoid").asBoolean() : false;
    this.age = entry.has("age") ? entry.get("age").asInt() : 0;

    // Check if entry has traits and then convert each trait to string
    this.traits = new ArrayList<>();
    if (entry.has("traits")) {
      entry.get("traits").forEach(trait -> this.traits.add(trait.asText()));
    }
  }

  // Check if entry contains specified traits, return false if not and true if contains
  public boolean hasTraits(String... traitsToCheck) {
    for (String trait : traitsToCheck) {
      if (!this.traits.contains(trait)) {
        return false;
      }
    }
    return true;
  }
}

record Universe(String name, List<JsonNode> individuals) { }

class View {
  private final ObjectMapper mapper;

  public View(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  //pretty format of the strings to json file
  public void writeToFile(Universe universe, String filePath) throws IOException {
    mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), universe);
  }
}