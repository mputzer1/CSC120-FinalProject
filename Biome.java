public class Biome {
    protected String biome = "Default biome";

    public Biome(String biome) {
        if (biome != null) { this.biome = biome;}
    }

    public String getBiome() {
        return this.biome;
    }

    public String toString() {
        return "This biome is a" + this.biome;
    }

    public void welcome() {
        //Reads welcome message
    }

    public void riddle() {
        //riddle
        //Read file (maybe same file for all the riddles, but read specific lines, avoid creating 478478 files)
        //User answers one riddle then another riddle for second animal(3 attempts per riddle)
    }

    //Look at labels for edges
    //Use value graph
}