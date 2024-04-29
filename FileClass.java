import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter; //Might use these later for leaderboard
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.io.BufferedWriter; // Import this class to write to a file

public class FileClass {
  private Multimap<String, Integer> scoreMap;
  private ArrayList<Integer> scoreList;
  private LinkedHashMap<String, Integer> sortedScoreMap;

  public FileClass() {
    this.scoreMap = ArrayListMultimap.create();
    this.scoreList = new ArrayList<>();
    this.sortedScoreMap = new LinkedHashMap<>();
  }

  public void fileReader(String fileName) {
    try {
      File myFile = new File(fileName);
      Scanner fileReader = new Scanner(myFile); // <- Same kind of object we used to read from the command line! But instead of System.in, we're reading from the file
      // Loop until we run out of lines
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        System.out.println(data);
      }

      // Tidy up
      fileReader.close();
      
    } catch (FileNotFoundException e) { // Sometimes things go wrong; we'll handle that here
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void sortedFileWriter() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", false)); 
      for (Map.Entry<String,Integer> entry : sortedScoreMap.entrySet()) {
        writer.write(entry.getKey() + ":" + entry.getValue());
        writer.newLine();
      }
      writer.close();
      } catch (IOException e) {
      System.out.println(e); // print error message
    }
  }


  public void fileWriter(String message) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true)); 
      writer.write("\n"+ message);
      writer.close();
    } catch (IOException e) {
      System.out.println(e); // print error message
    }
  }

  public void sortedFile() {
    try {
      Path nameFile = Path.of("Scoreboard.txt");
      String stringFile = Files.readString(nameFile);
      String[] splitLine = stringFile.split("\n");
      for (int i=0; i<splitLine.length; i++) {
        String splitLineString = splitLine[i];
        String[] keyValue = splitLineString.split(":");
        this.scoreMap.put(keyValue[0], Integer.valueOf(keyValue[1]));
      }

      for(Map.Entry<String, Integer> entry : scoreMap.entries()) {
        scoreList.add(entry.getValue());
      }
      Collections.sort(scoreList, Collections.reverseOrder());
      for (int num : scoreList) {
        for (Map.Entry<String,Integer> entry : scoreMap.entries()) {
          if (entry.getValue().equals(num) && !sortedScoreMap.containsKey(entry.getKey())) {
            sortedScoreMap.put(entry.getKey(), num); 
          }
        }
      }
      sortedFileWriter();
    } catch (IOException e) {
      System.out.println(e); // print error message
    }
}



  public static void main(String[] args) {
    FileClass file = new FileClass();
    file.sortedFile(); 
  }
}




//Sources
// https://stackoverflow.com/questions/15649567/sorting-a-text-file-in-java
// https://stackoverflow.com/questions/10514473/how-to-convert-a-string-to-a-hashmap
// https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java ---) taught me how to sort hashmap
// https://www.geeksforgeeks.org/write-hashmap-to-a-text-file-in-java/ --) taught me how to write to file
// https://www.geeksforgeeks.org/how-to-sort-an-arraylist-in-descending-order-in-java/ ---) taught reverse order