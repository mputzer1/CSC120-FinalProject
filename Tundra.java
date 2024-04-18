public class Tundra extends Biome {
    private FloraFauna arctic_fox;
    private FloraFauna fern;
    private Monster yeti;

    public Tundra(String biome, FloraFauna arctic_fox, FloraFauna fern, Monster yeti) {
        super(biome);
        this.arctic_fox = new FloraFauna("arctic fox"); 
        this.fern = new FloraFauna("fern");
        this.yeti = new Monster("yeti");
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