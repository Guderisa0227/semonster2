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
    // ドラゴン → エンシェントドラゴン
    Monster monster = new Monster(2, 4);
    assertEquals("Ancient Dragon:Rarity[4]", monster.toString());
  }

  @Test
  public void testNonEvolvedMonster() {
    // デュラハン → 進化なし
    Monster monster = new Monster(3, 2);
    assertEquals("Dullahan:Rarity[2]", monster.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMonsterIndex() {
    // 無効な番号
    new Monster(10, 1);
  }
}
