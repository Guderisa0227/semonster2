// src/test/java/org/example/AppTest.java
package org.example;

import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
        assertEquals("Hello SEMonster", classUnderTest.getGreeting());
    }

    @Test
    public void testCreateRandomList() {
        // Given: リストのサイズを10に指定
        int count = 10;

        // When: メソッドを実行
        LinkedList<Integer> randomList = App.createRandomList(count);

        // Then:
        // 1. リストのサイズが正しいか
        assertEquals("リストのサイズが指定したcountと異なります。", count, randomList.size());

        // 2. リストの各要素が期待される範囲内か (0から4)
        for (Integer num : randomList) {
            assertTrue("生成された数値が0から4の範囲外です: " + num, num >= 0 && num <= 4);
        }
    }

    @Test
    public void testCreateRandomListWithZeroCount() {
        // Given: リストのサイズを0に指定
        int count = 0;

        // When: メソッドを実行
        LinkedList<Integer> randomList = App.createRandomList(count);

        // Then:
        assertTrue("countが0の場合、リストは空であるべきです。", randomList.isEmpty());
    }
}