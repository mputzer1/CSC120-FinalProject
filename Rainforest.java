import java.util.Scanner;

public class Rainforest {
    private FloraFauna poison_dart_frog;
    private FloraFauna cacao;
    private Monster croczilla;

    public Rainforest() {
        this.poison_dart_frog = new FloraFauna("poison dart frog"); 
        this.cacao = new FloraFauna("cacao");
        this.croczilla = new Monster("croczilla");
    }

    public void welcome() {
        System.out.println("\nYou notice a large tree...");
        //Reads welcome message
        //or send to file class and have specific lines
    }


    public FloraFauna frogriddle() {
        System.out.println("\nIt's looking a little bold, like mold.");
        //System.out.println("Enter your answer:");
        Scanner userInput = new Scanner(System.in);
        String userResponse = "";
        int incorrectCounter = 0;
    
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = userInput.nextLine().toLowerCase();
            if (!userResponse.equals("poison dart frog")) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The croczilla is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYou've been eaten!");
                    userInput.close();
                    return null;
                }
            }
            if (userResponse.equals("poison dart frog")) {
                System.out.println("\nYou've answered correctly!");
                userInput.close();
                return this.poison_dart_frog;
            }
        }
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }

}