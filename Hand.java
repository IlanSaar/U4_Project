public class Hand {

    private String[] cards;

    public Hand(String text) {
        cards = text.split(",");
    }

    public int getHandStrength() {
        String type = getHandType();

        if (type.equals("Five of a Kind")) return 6;
        if (type.equals("Four of a Kind")) return 5;
        if (type.equals("Full House")) return 4;
        if (type.equals("Three of a Kind")) return 3;
        if (type.equals("Two Pair")) return 2;
        if (type.equals("One Pair")) return 1;
        return 0;
    }

    public String getHandType() {
        String[] labels = new String[5];
        int[] counts = new int[5];
        int size = 0;

        for (int i = 0; i < 5; i++) {
            boolean found = false;

            for (int j = 0; j < size; j++) {
                if (labels[j].equals(cards[i])) {
                    counts[j]++;
                    found = true;
                }
            }

            if (!found) {
                labels[size] = cards[i];
                counts[size] = 1;
                size++;
            }
        }

        int two = 0, three = 0, four = 0, five = 0;

        for (int i = 0; i < size; i++) {
            if (counts[i] == 5) five++;
            if (counts[i] == 4) four++;
            if (counts[i] == 3) three++;
            if (counts[i] == 2) two++;
        }

        if (five == 1) return "Five of a Kind";
        if (four == 1) return "Four of a Kind";
        if (three == 1 && two == 1) return "Full House";
        if (three == 1) return "Three of a Kind";
        if (two == 2) return "Two Pair";
        if (two == 1) return "One Pair";
        return "High Card";
    }

    public boolean isStrongerThan(Hand other) {

        if (this.getHandStrength() != other.getHandStrength()) {
            return this.getHandStrength() > other.getHandStrength();
        }

        for (int i = 0; i < 5; i++) {
            int a = cardValue(cards[i]);
            int b = cardValue(other.cards[i]);

            if (a != b) {
                return a > b;
            }
        }

        return false;
    }

    private int cardValue(String card) {
        if (card.equals("Ace")) return 12;
        if (card.equals("King")) return 11;
        if (card.equals("Queen")) return 10;
        if (card.equals("Jack")) return 9;
        if (card.equals("10")) return 8;
        if (card.equals("9")) return 7;
        if (card.equals("8")) return 6;
        if (card.equals("7")) return 5;
        if (card.equals("6")) return 4;
        if (card.equals("5")) return 3;
        if (card.equals("4")) return 2;
        if (card.equals("3")) return 1;
        return 0;
    }
}