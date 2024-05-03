
/**
 * Attributes for the FloraFauna class
 */
public class FloraFauna {
    protected String species = "Default species";
    protected Integer age = 0;
    protected String name = "Default name";

    /**
     * Constructor for the FloraFauna class
     * @param species string for species type 
     * @param age integer for age
     * @param name string for name
     */
    public FloraFauna(String species, Integer age, String name) {
        if (species != null) { this.species = species;}
        if (age != null) { this.age = age;}
        if (name != null) { this.name = name;}
    }

    /**
     * Compiles information about the creature into a string
     * @return string with animal/plant/monster info
     */
    public String toString() {
        return "* This creature is a " + this.species + " of age " + this.age + " named "+ this.name +".";
    }
}