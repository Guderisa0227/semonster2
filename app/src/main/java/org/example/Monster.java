package org.example;

public class Monster {
  private String name;
  private int rare;

  // コンストラクタ
  public Monster(int nameNum, int rare) {
    if (rare >= 3) {
      this.name = evolveName(this.summonMonster(nameNum));
    } else {
      this.name = this.summonMonster(nameNum);
    }
    this.rare = rare;
  }

  // 進化後の名前
  private static String evolveName(String originalName) {
    switch (originalName) {
      // スライム
      case "Slime":
        return "King Slime";
      // サハギン
      case "Sahagin":
        return "Tidal Sahagin";
      // ドラゴン
      case "Dragon":
        return "Ancient Dragon";
      // デュラハン
      case "Dullahan":
        return "Chaos Dullahan";
      // シーサーペント
      case "Sea Serpent":
        return "Leviathan";
      default:
        return originalName;
    }
  }

  public String summonMonster(int num) {
    // スライム, サハギン, ドラゴン, デュラハン, シーサーペント
    String monsters[] = { "Slime", "Sahagin", "Dragon", "Dullahan", "Sea Serpent" };

    if (num < 0 || num >= monsters.length) {
      throw new IllegalArgumentException("Invalid number: " + num);
    }
    return monsters[num];
  }

  @Override
  public String toString() {
    return this.name + ":Rarity[" + this.rare + "]";
  }
}
