public class Defenser {

    public void process(MemoryAI mem) {

        if(mem.getNumPiece() ==0)
        {
            tableDefenser(mem);
            twoAdversary(mem);
            twoAdversaryOneComputers(mem);
            horseTwoAdversary(mem);
        }
    }
    private void tableDefenser(MemoryAI mem) {
        int line=0;
        while(line<3) {
            int col = line * 3;
            mem.defenseTwoAdversary(1 + line, 4 + line, 7 + line);
            mem.defenseTwoAdversary(1 + line, 7 + line, 4 + line);
            mem.defenseTwoAdversary(7 + line, 4 + line, 1 + line);

            mem.defenseTwoAdversary(1 + col, 2 + col, 3 + col);
            mem.defenseTwoAdversary(1 + col, 3 + col, 2 + col);
            mem.defenseTwoAdversary(3 + col, 2 + col, 1 + col);
            line++;
        }
    }
    private void twoAdversary(MemoryAI mem) {
        int[] part = {1,3,7,9};
        for(int piece=0; piece<part.length; piece++)
            mem.defenseTwoAdversary(part[3 - piece], 5, part[piece]);
        for(int piece=2; piece<9; piece+=2) {
            mem.defenseTwoAdversary(1, 9, piece);
            mem.defenseTwoAdversary(3, 7, piece);
        }
    }
    private void twoAdversaryOneComputers(MemoryAI mem)
    {
        int [][] part = {{3,7,1},{1,9,3},{1,9,7},{3,7,9}};
        for(int piece=0; piece<part.length; piece++)
            mem.defenseTwoAdversaryOneComputers(part[piece][0], part[piece][1], part[piece][2]);
    }
    private void horseTwoAdversary(MemoryAI mem)
    {
        int [][] part = {{1,2},{3,2},{1,4},{7,4},{3,6},{9,6},{9,8},{7,8}};
        for(int piece=0; piece<part.length; piece++)
            mem.defenseTwoAdversary(part[piece][0], 5, part[piece][1]);
    }
}
