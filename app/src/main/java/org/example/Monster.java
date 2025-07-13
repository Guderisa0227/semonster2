package org.example;

public class Monster {
  private String name;
  private int rare;

  Monster(int nameNum, int rareNum) {
    this.name = this.summonMonster(nameNum);
    this.rare = rareNum;
  }

  String summonMonster(int mnumber) {
    String monsters[] = { "Slime", "Sahagin", "Dragon", "Dullahan", "Sea Serpent" };
    return monsters[mnumber];
  }

  public int getRare() {
    return this.rare;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    //
    // "rarelity" typo corrected to "Rarity"
    //
    return this.name + ":Rarity[" + this.rare + "]\n";
  }
}
