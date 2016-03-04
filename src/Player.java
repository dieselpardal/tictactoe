import java.util.Scanner;

public class Player {

    private int player;
    public Player () {
        this.player = 0;
    }

    public int getPlayer() {
        return this.player;
    }

    public int Human(String[] piece, String Iam, String Adversary )  {
        int select = 0;
        do {
            System.out.print("Player "+this.player+" enter a number: ");
            Scanner scanner = new Scanner(System.in);
            select = scanner.nextInt();
        } while (piece[select] == Iam || piece[select] == Adversary);
        return select;
    }

    public int next() {
        this.player = this.player == 1 ? 2 : 1;
       return  this.player;
    }
}
