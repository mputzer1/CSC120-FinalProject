public class FloraFauna {
    protected String species = "Default species";
    //protected String riddle = "Default riddle"; Would it be better to create specific animal classes or new animals within biome?
    //Maybe store riddles in a file and pull them when needed?

    public FloraFauna(String species) {
        if (species != null) { this.species = species;}
    }

    public String getSpecies() {
        return this.species;
    }

    public String toString() {
        return "This creature is a" + this.species;
    }

    public String speak() {
        return "Heyyyyyy, help me out!";
    }
}