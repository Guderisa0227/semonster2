package semonster2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Arrays;

public class PlayerTest {

  @Test
  void testPlayerDeckAndToString() {
    // テスト用のランダム数値リストを作成（名前番号, レア度）x 8体分 = 16個
    LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(
        3, 0, // 1. デュラハン:レア度[0]
        2, 4, // 2. ドラゴン:レア度[4] -> Ancient Dragon
        3, 0, // 3. デュラハン:レア度[0]
        3, 3, // 4. デュラハン:レア度[3] -> Chaos Dullahan
        0, 1, // 5. スライム:レア度[1]
        1, 2, // 6. サハギン:レア度[2]
        4, 0, // 7. シーサーペント:レア度[0]
        2, 1 // 8. ドラゴン:レア度[1]
    ));

    // Playerを生成
    Player player = new Player(numbers, "TestUser");
    player.drawMonsters();

    // 1. モンスターデッキの数が8体であることをテスト
    assertEquals(8, player.monsterDeck.size());

    // 2. toString()の出力が期待通りであることをテスト
    String expected = "Deck:TestUser\n"
        + "Dullahan:Rarity[0]\n"
        + "Ancient Dragon:Rarity[4]\n"
        + "Dullahan:Rarity[0]\n"
        + "Chaos Dullahan:Rarity[3]\n"
        + "Slime:Rarity[1]\n"
        + "Sahagin:Rarity[2]\n"
        + "Sea Serpent:Rarity[0]\n"
        + "Dragon:Rarity[1]\n";

    assertEquals(expected, player.toString());
  }
}
