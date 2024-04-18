public class Rainforest extends Biome {
    private FloraFauna poison_dart_frog;
    private FloraFauna cacao;
    private Monster croczilla;

    public Rainforest(String biome, FloraFauna poison_dart_frog, FloraFauna cacao, Monster croczilla) {
        super(biome);
        this.poison_dart_frog = new FloraFauna("poison dart frog"); 
        this.cacao = new FloraFauna("cacao");
        this.croczilla = new Monster("croczilla");
    }

    //Have rainforest file that reads certain description when called here from the rainforest

    public void start() {
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
    }


    public void river() {
        //Read file
    }

}