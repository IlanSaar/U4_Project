import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlainPokerPart1 {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("src/data");
        Scanner s = new Scanner(f);

        int fiveKind = 0;
        int fourKind = 0;
        int fullHouse = 0;
        int threeKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        while (s.hasNextLine()) {
            String line = s.nextLine();

            // Split off the bid (ignore it)
            String handText = line.split("\\|")[0];

            Hand hand = new Hand(handText);
            String type = hand.getHandType();

            if (type.equals("Five of a Kind")) {
                fiveKind++;
            } else if (type.equals("Four of a Kind")) {
                fourKind++;
            } else if (type.equals("Full House")) {
                fullHouse++;
            } else if (type.equals("Three of a Kind")) {
                threeKind++;
            } else if (type.equals("Two Pair")) {
                twoPair++;
            } else if (type.equals("One Pair")) {
                onePair++;
            } else {
                highCard++;
            }
        }

        s.close();

        System.out.println("Number of five of a kind hands: " + fiveKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourKind);
        System.out.println("Number of three of a kind hands: " + threeKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);
    }
}