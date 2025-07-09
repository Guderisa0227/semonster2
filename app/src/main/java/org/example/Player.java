package semonster2;

import java.util.ArrayList;
import java.util.LinkedList;
import org.example.Monster; // Monsterクラスをインポート

public class Player {
  String name; // Player name
  ArrayList<Monster> monsterDeck = new ArrayList<>();
  LinkedList<Integer> randomNumberList; // randomな0~4の数値を必要な数保存しておく

  Player(LinkedList<Integer> randomNumberList, String playerName) {
    this.randomNumberList = randomNumberList;
    this.name = playerName;
  }

  /**
   * モンスターを8体分drawする．利用するランダムな値(0~4)はrandomNumberListから取得する
   */
  public void drawMonsters() {
    // モンスターの数を8体に増やす
    for (int i = 0; i < 8; i++) {
      // randomNumberListが空でないことを確認
      if (this.randomNumberList == null || this.randomNumberList.size() < 2) {
        System.err.println("ランダムな数値が不足しています。");
        break;
      }
      this.monsterDeck.add(new Monster(this.randomNumberList.pop(), this.randomNumberList.pop()));
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Deck:" + this.name + "\n");
    for (Monster m : this.monsterDeck) {
      // 各モンスターの情報の後に改行を追加
      sb.append(m.toString()).append("\n");
    }
    return sb.toString();
  }
}
