public class Aquatic extends Biome {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;
    private Monster kraken;

    public Rainforest(String biome, FloraFauna dolphin, FloraFauna sea_anemone, Monster kraken) {
        super(biome);
        this.dolphin = new FloraFauna("dolphin"); 
        this.sea_anemone = new FloraFauna("sea anemone");
        this.kraken = new Monster("kraken");
    }

    public void welcome() {
        //Reads welcome message
    }

    public void riddle() {
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }
}