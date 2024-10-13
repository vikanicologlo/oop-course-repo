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

    for (JsonNode entry : data) {
      if (entry.has("id") && entry.get("id").asInt() % 2 == 0) {
        int evenId = entry.get("id").asInt();
        System.out.println("Even ID: " + evenId);
      }
    }


    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/starwars.json"), starWars);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/rings.json"), rings);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/marvel.json"), marvel);
  }
}

class Criteria {
  public String planet;
  public boolean isHumanoid;
  public int age;
  public List<String> traits;

  //use entry.has to check if such field exists and if doesnt, set up default value
  //for traits use arraylist
  public Criteria(JsonNode entry) {
    this.planet = entry.has("planet") ? entry.get("planet").asText() : "";
    this.isHumanoid = entry.has("isHumanoid") ? entry.get("isHumanoid").asBoolean() : false;
    this.age = entry.has("age") ? entry.get("age").asInt() : 0;
    this.traits = new ArrayList<>();
  }
  //check if trait contains or not
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