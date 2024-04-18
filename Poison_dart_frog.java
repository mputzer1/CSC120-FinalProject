public class Poison_dart_frog extends FloraFauna {

    public Poison_dart_frog(String species) {
        super(species);
        //species = poison_dart_frog;
    }

    public void riddle() { //or instead when user enters certain location in rainforest, riddle is given.
        System.out.println("Insert frog riddle");
    }

    public static void main(String[] args) {
        Poison_dart_frog frog = new Poison_dart_frog("Poison Dart Frog");
        frog.toString();
    }
}