package org.example;

import java.util.HashMap;
import java.util.LinkedList;

public class SeMonsterGame {

  HashMap<String, Player> playerMap = new HashMap<>();
  LinkedList<Integer> randomNumberList = new LinkedList<Integer>();

  SeMonsterGame(LinkedList<Integer> randomNumberList) {
    this.randomNumberList = randomNumberList;
  }

  void addPlayer(String playerName) {
    this.playerMap.put(playerName, new Player(randomNumberList, playerName));
  }

  void draw(String playerName) {
    Player player = this.playerMap.get(playerName);
    player.drawMonsters();
    System.out.println(player);
  }

  void battle(String player1Name, String player2Name) {
    Player player1 = this.playerMap.get(player1Name);
    Player player2 = this.playerMap.get(player2Name);

    System.out.println("\n======= BATTLE START =======");

    for (int i = 0; i < 5; i++) {
      System.out.println("--- Turn " + (i + 1) + " ---");

      Monster m1 = player1.monsterDeck.get(i);
      Monster m2 = player2.monsterDeck.get(i);

      // ★★★ .name を .getName() に変更 ★★★
      System.out.println(player1.name + "は " + m1.getName() + " を出した！");
      System.out.println(player2.name + "は " + m2.getName() + " を出した！");

      if (m1.getRare() > m2.getRare()) {
        System.out.println(m1.getName() + " の勝ち！\n");
      } else if (m1.getRare() < m2.getRare()) {
        System.out.println(m2.getName() + " の勝ち！\n");
      } else {
        System.out.println("引き分け！\n");
      }
    }
    System.out.println("======== BATTLE END ========");
  }
}