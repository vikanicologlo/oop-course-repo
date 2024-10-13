package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/java-classifcation/target/classes/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(entry);
          break;
        case "2":
          hitchhikers.individuals().add(entry);
          break;
        case "3":
          marvel.individuals().add(entry);
          break;
        case "4":
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Invalid input");
      }
    }


    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/starwars.json"), starWars);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/rings.json"), rings);
    mapper.writeValue(new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/output/marvel.json"), marvel);
    //Task of the day 1
    Example Example = new Example();
    //Task of the day 2
    ReadFile reader = new ReadFile();
    //Read whole file
    reader.readFileWholeAndPrint();
    //Read objects separately
    reader.readFileSeparatelyAndPrint();

    scanner.close();
  }
}

record Universe(
        String name,
        List<JsonNode> individuals
) { }
class Example {

  public Example() {
    System.out.println("Which one of universes do you like the most?");
    Scanner console = new Scanner(System.in);
    String answer = console.nextLine();
    System.out.println("I also like " + answer + "!");
  }
}

class ReadFile {
  private JsonNode jsonNode;

  public void readFileWholeAndPrint() throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    File file1 = new File("/Users/viktorianicologlo/Downloads/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/input.json");
    this.jsonNode = mapper.readTree(file1);
    System.out.println(" ");
    System.out.println("Printing whole Json file:");
    System.out.println(jsonNode.toPrettyString());

  }


  public void readFileSeparatelyAndPrint()  {
    JsonNode jsonNode1 = jsonNode.get("data");
    System.out.println(" ");
    System.out.println("Printing each Json object separately:");
    //use for loop to print each node separately
    for (JsonNode node : jsonNode1) {
      System.out.println(node.toPrettyString());
    }
  }

}