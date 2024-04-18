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

    public void welcome() {
        //Reads welcome message
        //or send to file class and have specific lines
    }


    public void riddle() {
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }

}