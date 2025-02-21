package dev.sohaib;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to War!");
        System.out.println();
        System.out.println("""
                War is a 2-player game. The goal is to collect the full deck to win the game.\s
                
                It uses a 52-card deck, divided equally among the players. They must stack their cards face down in
                front of them. Then, each player turns up a card at the same time. The one with the highest number
                wins and can add the two cards to the bottom of their stack.
                
                If it is a draw, then it is war! Each player draws a card from their stack and places it face down on
                the table. Then they turn up a card from the stack. The player who wins gets to collect the cards that
                led to war, the cards that went to “battle” and the ones facing down (6 cards in total).
                """);
        System.out.println();
        System.out.println("Press any key to start your game!");
        String s1 = s.nextLine();
        while (s1.isEmpty()) {
            System.out.println("You have to enter a key to start the game.");
            s1 = s.nextLine();
        }

        List<Card> deck = new ArrayList<>(52);
        deck.addAll(Card.getStandardDeck());
        System.out.println("Deck is being shuffled...");
        Collections.shuffle(deck);

        System.out.println("What is player 1's name?");
        String p1 = s.nextLine();
        Player player1 = new Player(p1);

        System.out.println("What is player 2's name?");
        String p2 = s.nextLine();
        Player player2 = new Player(p2);

        System.out.println("Both players have been handed half of the deck...");
        player1.addCards(deck.subList(0, 26));
        player2.addCards(deck.subList(26, 52));

        System.out.print("Select how many rounds you want to play: ");
        int rounds = s.nextInt();

        Card player1Card, player2Card;
        List<Card> currentStack = new ArrayList<>();
        for (int i = 1; i <= rounds; i++) {
            roundStart(i);

            play(player1);
            play(player2);

            player1Card = playOneCard(player1, currentStack, true);

            player2Card = playOneCard(player2, currentStack, true);

            int result = compareCards(player1Card, player2Card);
            if (result > 0) {
                awardCardsToWinner(player1, currentStack);
            } else if (result < 0) {
                awardCardsToWinner(player2, currentStack);
            } else {
                Player winner = handleWar(player1, player2, currentStack);
                awardCardsToWinner(winner, currentStack);
            }
        }

        int player1CardCount = player1.getCardCount();
        int player2CardCount = player2.getCardCount();
        lineBreak();
        System.out.println("The game is over!");
        System.out.println(player1.getName() + " has " + player1CardCount + " cards.");
        System.out.println(player2.getName() + " has " + player2CardCount + " cards.");
        lineBreak();
        if (player1CardCount > player2CardCount) {
            System.out.println("The winner is " + player1.getName() + "!");
        } else if (player1CardCount < player2CardCount) {
            System.out.println("The winner is " + player2.getName() + "!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void roundStart(int round) {
        System.out.println("Round " + round);
        lineBreak();
    }

    public static void lineBreak() {
        System.out.println("------------------------");
    }

    public static void play(Player player) {
        String playerResponse;
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + ", press any key to play");

        playerResponse = scanner.nextLine();
        while (playerResponse.isEmpty()) {
            System.out.println("You have to enter a key to play.");
            playerResponse = scanner.nextLine();
        }
        lineBreak();
    }

    public static int compareCards(Card card1, Card card2) {
        return card1.compareTo(card2);
    }

    private static Card playOneCard(Player player, List<Card> currentStack, boolean showCard) {
        if (player.getCardCount() < 1) {
            lineBreak();
            System.out.println(player.getName() + " loses because they don't have any cards left.");
            System.exit(0);
        }
        Card card = player.playCard();
        if (showCard) {
            System.out.println(player.getName() + " has played card: " + card);
        }
        currentStack.add(card);
        return card;
    }

    private static void awardCardsToWinner(Player winner, List<Card> currentStack) {
        System.out.println(winner.getName() + " wins the round!");
        lineBreak();
        winner.getDeck().addAll(currentStack);
        currentStack.clear();
    }

    private static Player handleWar(Player player1, Player player2, List<Card> currentStack) {
        System.out.println("It's war!");
        if (player1.getCardCount() < 2) {
            lineBreak();
            System.out.println(player1.getName() + " loses because they don't have enough cards to play war.");
            System.out.println("Congratulations! " + player2.getName() + " you're the winner!");
            System.exit(0);
        } else if (player2.getCardCount() < 2) {
            lineBreak();
            System.out.println(player2.getName() + " loses because they don't have enough cards to play war.");
            System.out.println("Congratulations! " + player1.getName() + " you're the winner!");
            System.exit(0);
        }
        playOneCard(player1, currentStack, false);
        playOneCard(player2, currentStack, false);
        Card player1Card = playOneCard(player1, currentStack, true);
        Card player2Card = playOneCard(player2, currentStack, true);

        int result = player1Card.compareTo(player2Card);

        if (result > 0) {
            return player1;
        } else if (result < 0) {
            return player2;
        } else {
            System.out.println("It's another draw so you know what that means!");
            return handleWar(player1, player2, currentStack);
        }
    }
}
