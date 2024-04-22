import java.util.Scanner;

public class Desert {
    private FloraFauna camel;
    private FloraFauna cactus;
    private Monster sharknado;

    public Desert() {
        this.camel = new FloraFauna("camel", 2, "Tom");
        this.cactus = new FloraFauna("cactus", 3, "Janice");
        this.sharknado = new Monster("sharknado");
    }

    public void welcome() {
        //Reads welcome message
        //Or send to file class and have specific lines read
    }

    public FloraFauna camelriddle(Scanner s) { //Is there a way to consoliate this into one class (biome) or must it be separate b/c different things printed?
        System.out.println("\nIt's looking a little bold, like camel.");
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals("camel")) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The sharknado is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYou've been eaten!");
                    return null;
                }
            }
            if (userResponse.equals("camel")) {
                System.out.println("\nYou've answered correctly! The camel has been added to your inventory.");
                return this.camel;
            }
        }
    }

    public FloraFauna cactusriddle(Scanner s) {
        System.out.println("\nIt's looking a little bit like cactus...");
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals("cactus")) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The sharknado is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYou've been eaten!");
                    return null;
                }
            }
            if (userResponse.equals("cactus")) {
                System.out.println("\nYou've answered correctly! The cactus has been added to your inventory.");
                return this.cactus;
            }
        }
    }

}