public class Attack  {

    public void process(MemoryAI mem) {
        if(mem.getNumPiece() ==0)
        {
            tableAttack(mem);
            twoCumputers(mem);
        }
    }
    private void twoCumputers(MemoryAI mem){
        mem.attackOfTwoCumputers(1, 9, 5);
        mem.attackOfTwoCumputers(3, 7, 5);
        int[] part = {1,3,7,9};
        for (int step = 0; step < part.length; step++)
            mem.attackOfTwoCumputers(part[3 - step], 5, part[step]);
    }
    private void tableAttack(MemoryAI mem){
        int line = 0;
        while (line < 3) {
            int col = line * 3;
            mem.attackOfTwoCumputers(1 + line, 4 + line, 7 + line);
            mem.attackOfTwoCumputers(1 + line, 7 + line, 4 + line);
            mem.attackOfTwoCumputers(4 + line, 7 + line, 1 + line);

            mem.attackOfTwoCumputers(1 + col, 2 + col, 3 + col);
            mem.attackOfTwoCumputers(1 + col, 3 + col, 2 + col);
            mem.attackOfTwoCumputers(2 + col, 3 + col, 1 + col);
            line++;
        }
    }
}
