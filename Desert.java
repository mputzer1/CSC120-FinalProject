public class Desert {
    private FloraFauna camel;
    private FloraFauna cactus;
    private Monster sharknado;

    public Desert() {
        this.camel = new FloraFauna("camel");
        this.cactus = new FloraFauna("cactus");
        this.sharknado = new Monster("sharknado");
    }

    public void welcome() {
        //Reads welcome message
        //Or send to file class and have specific lines read
    }

    public void riddle() {
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }

}