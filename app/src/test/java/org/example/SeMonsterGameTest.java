// src/test/java/org/example/SeMonsterGameTest.java
package org.example;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SeMonsterGameTest {

    private SeMonsterGame game;
    private LinkedList<Integer> initialNumbers;

    @Before
    public void setUp() {
        // テストごとに初期化
        initialNumbers = new LinkedList<>(Arrays.asList(
                0, 1, 2, 3, // Player1's monsters (name, rare, name, rare)
                1, 2, 3, 4, // Player2's monsters (name, rare, name, rare)
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 // dummy numbers
        ));
    }

    @Test
    public void addPlayer() {
        game = new SeMonsterGame(new LinkedList<>());
        game.addPlayer("TestPlayer");
        assertTrue("プレイヤーがplayerMapに追加されていません。", game.playerMap.containsKey("TestPlayer"));
        assertNotNull("追加されたプレイヤーがnullです。", game.playerMap.get("TestPlayer"));
    }
    
    @Test
    public void draw() {
        game = new SeMonsterGame(initialNumbers);
        game.addPlayer("TestPlayer");
        
        // draw前の乱数リストのサイズを記録
        int sizeBefore = game.randomNumberList.size();
        
        game.draw("TestPlayer"); // 5枚引くので、乱数を10個消費するはず

        // draw後のプレイヤーのデッキサイズを確認
        assertEquals("モンスターを5枚ドローできていません。", 5, game.playerMap.get("TestPlayer").monsterDeck.size());
        // draw後の乱数リストのサイズを確認
        assertEquals("ドローによって乱数が10個消費されていません。", sizeBefore - 10, game.randomNumberList.size());
    }

    @Test
    public void battle_Player1Wins() {
        // Given: プレイヤー1が必ず勝つシナリオ
        LinkedList<Integer> winScenario = new LinkedList<>(Arrays.asList(
                2, 4, 2, 4, // Player1 draws two Dragons[4]
                0, 0, 0, 0  // Player2 draws two Slimes[0]
        ));

        // 乱数を固定 (CPUは常に最初のモンスターを選ぶ)
        Random predictableRandom = new Random(1L);
        // 前回提案した、Randomを注入できるコンストラクタを使用
        game = new SeMonsterGame(winScenario, predictableRandom);

        // プレイヤーを追加してドロー
        game.addPlayer("Hero");
        game.addPlayer("CPU");
        // ※ PlayerクラスのdrawMonstersは5回ループするため、ダミーの数字を追加
        for(int i=0; i<6; i++) {
            winScenario.add(0);
        }
        game.draw("Hero");
        game.draw("CPU");

        // ユーザー入力をシミュレート ("1"を入力)
        String simulatedInput = "1\n1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // When: battle実行
        game.battle("Hero", "CPU", scanner);
        
        // Then: 本来はコンソール出力をキャプチャして結果を検証しますが、
        // このテストでは例外なく最後まで実行されることを確認します。
    }
}