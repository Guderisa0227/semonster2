package org.example;

public class Monster {
  private String name;
  private int rare; // 戦うとレア度が高いほうが勝つ．同じ場合は引き分け

  Monster(int nameNum, int rareNum) {
    this.name = this.summonMonster(nameNum);
    this.rare = rareNum;
  }

  String summonMonster(int mnumber) {
    String monsters[] = { "Slime", "Sahagin", "Dragon", "Dullahan", "Sea Serpent" };
    return monsters[mnumber];
  }

  // rareの値を取得するためのメソッド(getter)
  public int getRare() {
    return this.rare;
  }

  // ★★★ nameの値を取得するためのgetterを追加 ★★★
  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name + ":rarelity[" + this.rare + "]\n";
  }
}