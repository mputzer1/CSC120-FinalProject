import java.util.Scanner;

public class Desert extends Biome {
    private FloraFauna camel;
    private FloraFauna cactus;

    public Desert() {
        this.camel = new FloraFauna("camel", 2, "Tom");
        this.cactus = new FloraFauna("cactus", 3, "Janice");
    }

    public FloraFauna getCamel() {
        return this.camel;
    }

    public void welcome() {
        System.out.println("The sun is low over the horizon and you spot a sea of orange sand in the distance. The wind is harsh and creates swirling sand spires. You notice...");
    }

    public FloraFauna camelRiddle(Scanner s) { 
        if (riddle(s, "camel", "sharknado", "CamelRiddle.txt")) {
            return this.camel;
        } else {
            return null;
        }
    }

    public FloraFauna cactusRiddle(Scanner s) {
        if (riddle(s, "cactus", "sharknado", "CactusRiddle.txt")) {
            return this.cactus;
        } else {
            return null;
        }
    }

}