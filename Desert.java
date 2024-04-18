public class Desert extends Biome {
    private FloraFauna camel;
    private FloraFauna cactus;
    private Monster sharknado;

    public Desert(String biome, FloraFauna camel, FloraFauna cactus, Monster sharknado) {
        super(biome);
        this.camel = new FloraFauna("camel");
        this.cactus = new FloraFauna("cactus");
        this.sharknado = new Monster("sharknado");
    }
}