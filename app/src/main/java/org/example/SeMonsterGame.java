package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SeMonsterGame {

  HashMap<String, Player> playerMap = new HashMap<>();
  LinkedList<Integer> randomNumberList = new LinkedList<Integer>();
  private Random random = new Random();

  SeMonsterGame(LinkedList<Integer> randomNumberList) {
    this.randomNumberList = randomNumberList;
  }

  void addPlayer(String playerName) {
    this.playerMap.put(playerName, new Player(randomNumberList, playerName));
  }

  void draw(String playerName) {
    Player player = this.playerMap.get(playerName);
    player.drawMonsters();
  }

  void battle(String player1Name, String player2Name, Scanner scanner) {
    Player player1 = this.playerMap.get(player1Name);
    Player player2 = this.playerMap.get(player2Name);
    int player1Wins = 0;
    int player2Wins = 0;

    System.out.println("\n======= BATTLE START =======");

    int initialDeckSize = player1.monsterDeck.size();
    for (int i = 0; i < initialDeckSize; i++) {
      System.out.println("--- Turn " + (i + 1) + " ---");

      player1.showHand();
      
      
      int playerChoice = -1;
      while (true) {
        System.out.print("Choose your monster (1-" + player1.monsterDeck.size() + ") > ");
        playerChoice = scanner.nextInt();
        if (playerChoice >= 1 && playerChoice <= player1.monsterDeck.size()) {
          break; // Exit loop if input is valid
        } else {
          System.out.println("Invalid input. Please choose a number from your hand.");
        }
      }


      Monster m1 = player1.monsterDeck.remove(playerChoice - 1); // Adjust for array index
      Monster m2 = player2.monsterDeck.remove(random.nextInt(player2.monsterDeck.size()));

      System.out.println(player1.name + " summons " + m1.getName() + "[" + m1.getRare() + "]" + "!");
      System.out.println(player2.name + " summons " + m2.getName() + "[" + m2.getRare() + "]" + "!");

      if (m1.getRare() > m2.getRare()) {
        System.out.println(m1.getName() + " wins!\n");
        player1Wins++;
      } else if (m1.getRare() < m2.getRare()) {
        System.out.println(m2.getName() + " wins!\n");
        player2Wins++;
      } else {
        System.out.println("It's a draw!\n");
      }
    }

    System.out.println("--- Final Result ---");
    System.out.println(player1.name + ": " + player1Wins + " wins");
    System.out.println(player2.name + ": " + player2Wins + " wins");
    if (player1Wins > player2Wins) {
      System.out.println(player1.name + " is the winner!");
    } else if (player1Wins < player2Wins) {
      System.out.println(player2.name + " is the winner!");
    } else {
      System.out.println("The game is a draw!");
    }

    System.out.println("======== BATTLE END ========");
  }
}