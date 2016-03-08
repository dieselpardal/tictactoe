public class Engine {

    private final Attack attack;
    private final Defenser defenser;
    private final Shield shield;


    public Engine(Attack attack, Defenser defenser, Shield shield ) {
        this.attack = attack;
        this.defenser = defenser;
        this.shield = shield;
    }

    public int playAI(String[] piece, String computer, String adversary) {
        return this.playAI(new MemoryAI(piece, computer, adversary));
    }

    public int playAI(MemoryAI mem) {

        mem.centerNotExist();
        attack.process(mem);
        defenser.process(mem);
        shield.process(mem);
        return mem.lastChance();
    }
}
