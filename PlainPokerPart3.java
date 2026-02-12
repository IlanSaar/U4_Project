import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlainPokerPart3 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/data");
        Scanner scan = new Scanner(file);

        Hand[] hands = new Hand[1000];
        int[] bids = new int[1000];
        int count = 0;

        int five = 0, four = 0, full = 0, three = 0;
        int two = 0, one = 0, high = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\|");

            hands[count] = new Hand(parts[0]);
            bids[count] = Integer.parseInt(parts[1]);

            String type = hands[count].getHandType();

            if (type.equals("Five of a Kind")) five++;
            else if (type.equals("Four of a Kind")) four++;
            else if (type.equals("Full House")) full++;
            else if (type.equals("Three of a Kind")) three++;
            else if (type.equals("Two Pair")) two++;
            else if (type.equals("One Pair")) one++;
            else high++;

            count++;
        }

        scan.close();

        int total = 0;

        for (int i = 0; i < count; i++) {
            int rank = 1;

            for (int j = 0; j < count; j++) {
                if (hands[i].isStrongerThan(hands[j])) {
                    rank++;
                }
            }

            total += rank * bids[i];
        }

        int wildTotal = 0;

        for (int i = 0; i < count; i++) {
            int rank = 1;

            for (int j = 0; j < count; j++) {
                if (hands[i].isStrongerThanWild(hands[j])) {
                    rank++;
                }
            }

            wildTotal += rank * bids[i];
        }

        System.out.println("Number of five of a kind hands: " + five);
        System.out.println("Number of full house hands: " + full);
        System.out.println("Number of four of a kind hands: " + four);
        System.out.println("Number of three of a kind hands: " + three);
        System.out.println("Number of two pair hands: " + two);
        System.out.println("Number of one pair hands: " + one);
        System.out.println("Number of high card hands: " + high);
        System.out.println("Total Bid Value: " + total);
        System.out.println("Total Bid Value With Jacks Wild: " + wildTotal);
    }
}