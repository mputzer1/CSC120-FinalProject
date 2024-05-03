import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileWriter; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.BufferedWriter; 

/**
 * Stores the attributes of the file class
 */
public class FileClass {
  private Multimap<String, Integer> scoreMap;
  private ArrayList<Integer> scoreList;
  private LinkedHashMap<String, Integer> sortedScoreMap;

  /**
   * Constructor for the attributes of the file class
   */
  public FileClass() {
    this.scoreMap = ArrayListMultimap.create();
    this.scoreList = new ArrayList<>();
    this.sortedScoreMap = new LinkedHashMap<>();
  }

  /**
   * Reads and prints data from files
   * @param fileName string for file name
   */
  public void fileReader(String fileName) {
    try {
      File myFile = new File(fileName);
      Scanner fileReader = new Scanner(myFile); 
      if (fileName.equals("Scoreboard.txt")) {
        int nLine = 1;
        while (nLine <= 5) {
          String data = fileReader.nextLine();
          System.out.println(data);
          nLine ++;
        }
      } else {
        while (fileReader.hasNextLine()) {
          String data = fileReader.nextLine();
          System.out.println(data);
        }
      }

      fileReader.close();
      
    } catch (FileNotFoundException e) { 
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


  /**
   * Once the scoreboard file is sorted, this method writes the sorted scores to the scoreboard file
   */
  public void sortedFileWriter() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", false)); 
      for (Map.Entry<String,Integer> entry : sortedScoreMap.entrySet()) {
        writer.write(entry.getKey() + ":" + entry.getValue());
        writer.newLine();
      }
      writer.close();
      } catch (IOException e) {
      System.out.println(e); 
    }
  }

  
  /**
   * Writes username and scores to the scoreboard file
   * @param usernameScore string for the username and score of player
   */
  public void fileWriter(String usernameScore) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true)); 
      writer.write(usernameScore);
      writer.close();
    } catch (IOException e) {
      System.out.println(e); 
    }
  }

  /**
   * Converts the scoreboard file to a string, splits it, sorts it, and calls the sortedFileWriter to add sorted scores to the scoreboard file
   */
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

      for(Map.Entry<String, Integer> entry : this.scoreMap.entries()) {
        this.scoreList.add(entry.getValue());
      }
      Collections.sort(this.scoreList, Collections.reverseOrder());
      for (int num : this.scoreList) {
        for (Map.Entry<String,Integer> entry : this.scoreMap.entries()) {
          if (entry.getValue().equals(num) && !this.sortedScoreMap.containsKey(entry.getKey())) {
            this.sortedScoreMap.put(entry.getKey(), num); 
          }
        }
      }
      sortedFileWriter();
    } catch (IOException e) {
      System.out.println(e); 
    }
  }
}