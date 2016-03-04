public class Defenser {

    public void process(MemoryAI mem) {

        if(mem.getNumPiece() ==0)
        {
            tableDefenser(mem);
            twoAdversary(mem);
            TwoAdversaryOneComputers(mem);
            HorseTwoAdversary(mem);
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
        for(int step=0; step<part.length; step++)
            mem.defenseTwoAdversary(part[3 - step], 5, part[step]);
        for(int step=2; step<9; step+=2) {
            mem.defenseTwoAdversary(1, 9, step);
            mem.defenseTwoAdversary(3, 7, step);
        }
    }
    private void TwoAdversaryOneComputers(MemoryAI mem)
    {
        int [][] miniPiece = {{3,7,1},{1,9,3},{1,9,7},{3,7,9}};
        for(int step=0; step<miniPiece.length; step++)
            mem.defenseTwoAdversaryOneComputers(miniPiece[step][0], miniPiece[step][1], miniPiece[step][2]);
    }
    private void HorseTwoAdversary(MemoryAI mem)
    {
        int [][] miniPiece = {{1,2},{3,2},{1,4},{7,4},{3,6},{9,6},{9,8},{7,8}};
        for(int step=0; step<miniPiece.length; step++)
            mem.defenseTwoAdversary(miniPiece[step][0], 5, miniPiece[step][1]);
    }
}
