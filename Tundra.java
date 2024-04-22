public class Tundra {
    private FloraFauna arctic_fox;
    private FloraFauna fern;
    private Monster yeti;

    public Tundra() {
        this.arctic_fox = new FloraFauna("arctic fox", 6, "Gary"); 
        this.fern = new FloraFauna("fern", 5, "finn");
        this.yeti = new Monster("yeti");
    }

    public void welcome() {
        System.out.println("Tundra Welcome!");
        //Reads welcome message
    }

    public void riddle() {
        System.out.println("Tundra Riddle!");
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }
}