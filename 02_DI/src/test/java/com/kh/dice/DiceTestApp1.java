package com.kh.dice;

import com.kh.dice.impl.DiceAImpl;
import com.kh.dice.impl.DiceBImpl;
import com.kh.dice.impl.DiceCImpl;

public class DiceTestApp1 {

	public static void main(String[] args) {
		Player player1 = new Player(new DiceAImpl());
		player1.playDice(3);
		System.out.println("=========================================");
		System.out.println("선택된 주사위 수의 통합은 : " + player1.getTotalValue());
		System.out.println("=========================================");
		
		Player player2 = new Player(new DiceBImpl());
		player2.playDice(3);
		System.out.println("=========================================");
		System.out.println("선택된 주사위 수의 통합은 : " + player2.getTotalValue());
		System.out.println("=========================================");
		
		Player player3 = new Player(new DiceCImpl());
		player3.playDice(3);
		System.out.println("=========================================");
		System.out.println("선택된 주사위 수의 통합은 : " + player3.getTotalValue());
		System.out.println("=========================================");
	}

}
