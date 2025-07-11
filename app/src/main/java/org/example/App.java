package org.example;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class App {
  final static Random random = new Random();
  final static int maxRandomNumber = 4;

  public String getGreeting() {
    return "Hello SEMonster";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter player name > ");
    String playerName = scanner.next();

    SeMonsterGame mf = new SeMonsterGame(createRandomList(20));

    mf.addPlayer(playerName);
    mf.addPlayer("CPU");

    mf.draw(playerName);
    mf.draw("CPU");

    // battleメソッドにscannerを渡す
    mf.battle(playerName, "CPU", scanner);

    scanner.close();
  }

  public static LinkedList<Integer> createRandomList(int count) {
    LinkedList<Integer> randNumList = new LinkedList<>();
    for (int i = 0; i < count; i++) {
      randNumList.add(random.nextInt(maxRandomNumber + 1));
    }
    return randNumList;
  }
}