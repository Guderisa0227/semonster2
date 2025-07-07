package org.example;

import java.util.Random;

public class Monster {
  String name;
  int rare;

  // コンストラクタ
  public Monster(String name, int rare) {
    this.name = name;
    this.rare = rare;
  }

  public String toString() {
    return this.name + ":Rarity[" + this.rare + "]";
  }

  public void summonMonster(int num) {
    
  }
}
