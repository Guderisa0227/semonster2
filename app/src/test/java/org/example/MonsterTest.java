package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
  @Test
  public void testSummonMonster1() {
    Monster monster = new Monster(0, 0);
    assertEquals("Slime:Rarity[0]", monster.toString());
  }

  @Test
  public void testEvolvedMonster() {
    Monster monster = new Monster(2, 4); // ドラゴン → エンシェントドラゴン
    assertEquals("Ancient Dragon:Rarity[4]", monster.toString());
  }

  @Test
  public void testNonEvolvedMonster() {
    Monster monster = new Monster(3, 2); // デュラハン → 進化なし
    assertEquals("Dullahan:Rarity[2]", monster.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMonsterIndex() {
    new Monster(10, 1); // 無効な番号
  }
}
