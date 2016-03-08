import java.util.Scanner;

public class Player {

    private int play;
    public Player () {
        this.play = 0;
    }

    public int getPlay() {
        return this.play;
    }

    public int playHuman(String[] pieces, String play, String adversary)  {
        int select = 0;
        do {
            System.out.print("Player "+this.play +" enter a number: ");
            Scanner scanner = new Scanner(System.in);
            select = scanner.nextInt();
        } while (pieces[select] == play || pieces[select] == adversary);
        return select;
    }

    public int next() {
        this.play = this.play == 1 ? 2 : 1;
       return  this.play;
    }
}
