import java.util.Scanner;

public class Desert extends Biome {
    private FloraFauna camel;
    private FloraFauna cactus;
    private Monster sharknado;

    public Desert() {
        this.camel = new FloraFauna("camel", 2, "Tom");
        this.cactus = new FloraFauna("cactus", 3, "Janice");
        this.sharknado = new Monster("sharknado");
    }

    public FloraFauna getCamel() {
        return this.camel;
    }

    public void welcome() {
        //Reads welcome message
        //Or send to file class and have specific lines read
    }

    public FloraFauna camelRiddle(Scanner s) { //Is there a way to consoliate this into one class (biome) or must it be separate b/c different things printed?
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