public class Hand {

    private String[] cards;

    public Hand(String handText) {
        cards = handText.split(",");
    }

    public String getHandType() {
        String[] labels = new String[5];
        int[] counts = new int[5];
        int labelCount = 0;

        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];
            boolean found = false;

            for (int j = 0; j < labelCount; j++) {
                if (labels[j].equals(card)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                labels[labelCount] = card;
                counts[labelCount] = 1;
                labelCount++;
            }
        }

        int numFive = 0;
        int numFour = 0;
        int numThree = 0;
        int numTwo = 0;

        for (int i = 0; i < labelCount; i++) {
            if (counts[i] == 5) {
                numFive++;
            } else if (counts[i] == 4) {
                numFour++;
            } else if (counts[i] == 3) {
                numThree++;
            } else if (counts[i] == 2) {
                numTwo++;
            }
        }
        if (numFive == 1) {
            return "Five of a Kind";
        } else if (numFour == 1) {
            return "Four of a Kind";
        } else if (numThree == 1 && numTwo == 1) {
            return "Full House";
        } else if (numThree == 1) {
            return "Three of a Kind";
        } else if (numTwo == 2) {
            return "Two Pair";
        } else if (numTwo == 1) {
            return "One Pair";
        } else {
            return "High Card";
        }

    }
}