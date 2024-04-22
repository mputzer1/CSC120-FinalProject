public class Aquatic {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;
    private Monster kraken;

    public Aquatic() {
        this.dolphin = new FloraFauna("dolphin", 4, "Dorothy"); 
        this.sea_anemone = new FloraFauna("sea anemone", 5, "Flounder");
        this.kraken = new Monster("kraken");
    }

    public void welcome() {
        System.out.println("Aquatic welcome");
        //Reads welcome message
    }

    public void riddle() {
        System.out.println("Aquatic riddle");
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }
}