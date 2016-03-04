public class Engine {

    private final Attack attack;
    private final Defenser defenser;
    private final Shield shield;


    public Engine(Attack attack, Defenser defenser, Shield shield ) {
        this.attack = attack;
        this.defenser = defenser;
        this.shield = shield;
    }

    public int IA(String[] piece, String Computer, String Adversary ) {
        return this.IA(new MemoryAI(piece, Computer, Adversary));
    }

    public int IA(MemoryAI mem) {

        mem.centerNotExist();
        attack.process(mem);
        defenser.process(mem);
        shield.process(mem);
        return mem.lastChance();
    }
}
