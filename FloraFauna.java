public class FloraFauna {
    protected String species = "Default species";
    protected Integer age = 0;
    protected String name = "Default name";

    public FloraFauna(String species, Integer age, String name) {
        if (species != null) { this.species = species;}
        if (age != null) { this.age = age;}
        if (name != null) { this.name = name;}
    }

    public String getSpecies() {
        return this.species;
    }

    public String toString() {
        return "* This creature is a " + this.species + " of age " + this.age + " named "+ this.name +".";
    }

    public String speak() {
        return "Heyyyyyy, help me out!";
    }
}