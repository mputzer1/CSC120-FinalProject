import java.util.Scanner;

public class Rainforest {
    private FloraFauna poison_dart_frog; //Would it be better to just create a string for poison dart frog? //Should we have important info about posion dart frog that user can read?
    private FloraFauna cacao;
    private Monster croczilla; //Is this really necessary?

    public Rainforest() {
        this.poison_dart_frog = new FloraFauna("poison dart frog", 3, "Theo"); 
        this.cacao = new FloraFauna("cacao", 6, "Barbara");
        this.croczilla = new Monster("croczilla");
    }

    public void welcome() {
        System.out.println("\nYou notice a large tree...");
        //Reads welcome message
        //or send to file class and have specific lines
    }


    public FloraFauna frogriddle(Scanner s) {
        System.out.println("\nIt's looking a little bold, like mold.");
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals("poison dart frog")) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The croczilla is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYou've been eaten!");
                    //userInput.close();
                    return null;
                }
            }
            if (userResponse.equals("poison dart frog")) {
                System.out.println("\nYou've answered correctly! The poison dart frog has been added to your inventory.");
                //userInput.close();
                return this.poison_dart_frog;
            }
        }
    }

    public FloraFauna cacaoriddle(Scanner s) {
        System.out.println("\nIt's looking a little bit like chocolate...");
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals("cacao")) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The croczilla is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYou've been eaten!");
                    return null;
                }
            }
            if (userResponse.equals("cacao")) {
                System.out.println("\nYou've answered correctly! The cacao has been added to your inventory.");
                return this.cacao;
            }
        }

        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }

}