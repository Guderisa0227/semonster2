// src/test/java/org/example/MonsterTest.java
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void testMonsterCreationAndGetters() {
        // Given: nameNum=2 ("Dragon"), rareNum=4
        Monster monster = new Monster(2, 4);

        // Then:
        assertEquals("モンスターの名前が正しく設定されていません。", "Dragon", monster.getName());
        assertEquals("モンスターのレア度が正しく設定されていません。", 4, monster.getRare());
    }

    @Test
    public void testSummonMonsterWithValidNumber() {
        // Given: nameNum=0 ("Slime")
        Monster monster = new Monster(0, 1);
        
        // Then:
        assertEquals("0番のモンスターは'Slime'であるべきです。", "Slime", monster.getName());
    }

    @Test
    public void testToString() {
        // Given: nameNum=3 ("Dullahan"), rareNum=3
        Monster monster = new Monster(3, 3);
        String expectedString = "Dullahan:Rarity[3]\n";

        // Then:
        assertEquals("toStringのフォーマットが期待通りではありません。", expectedString, monster.toString());
    }

    // 例外テストは @Test(expected = ...) を使用
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSummonMonsterThrowsExceptionForInvalidNumber() {
        // When: 無効なmnumberでMonsterをインスタンス化すると例外がスローされる
        new Monster(5, 1);
    }
}