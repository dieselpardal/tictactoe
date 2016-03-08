public class Shield {

    public void process(MemoryAI mem) {
        if(mem.getNumPiece() ==0)
        {
            behindAdversarySpy(mem);
            twoCumputers(mem);
            twoComputersOneAdversaryPre(mem);
        }
    }
    private void behindAdversarySpy(MemoryAI mem)
    {
        int[] part = {1,3,7,9};
        for(int piece=0; piece<part.length; piece++)
            mem.shieldBehindAdversarySpy(part[3 - piece], part[piece]);
    }
    private void twoCumputers(MemoryAI mem)
    {
        int [][] part = {{3, 4, 1}, {4, 5, 3}, {8, 3, 7}, {5, 8, 9}};
        for(int piece=0; piece<part.length; piece++)
            mem.attackOfTwoCumputers(part[piece][0], part[piece][1], part[piece][2]);
    }
    private void twoComputersOneAdversaryPre(MemoryAI mem)
    {
        int [][] part = {{1,8,2},{3,8,2},{1,6,4},{7,6,4},{3,4,6},{9,4,6},{9,3,8},{7,2,8}};
        for(int piece=0; piece<part.length; piece++)
            mem.shieldTwoComputersOneAdversary(part[piece][0], part[piece][1], part[piece][2]);
    }
}
