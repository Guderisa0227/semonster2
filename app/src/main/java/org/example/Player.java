package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
  String name;// Player name
  ArrayList<Monster> monsterDeck = new ArrayList<>();
  LinkedList<Integer> randomNumberList;// randomな0~4の数値を必要な数保存しておく

  Player(LinkedList<Integer> randomNumberList, String playerName) {
    this.randomNumberList = randomNumberList;
    this.name = playerName;
  }

  public void drawMonsters() {
    for (int i = 0; i < 5; i++) {
      this.monsterDeck.add(new Monster(this.randomNumberList.pop(), this.randomNumberList.pop()));
    }
  }

  /**
   * 手札のモンスターを番号付きで表示するメソッド
   */
  public void showHand() {
    System.out.println("Deck:" + this.name);
    for (int i = 0; i < monsterDeck.size(); i++) {
      // 選択しやすいように番号を付けて表示
      System.out.print((i + 1) + ": " + monsterDeck.get(i));
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Deck:" + this.name + "\n");
    for (Monster m : this.monsterDeck) {
      sb.append(m);
    }
    return sb.toString();
  }
}