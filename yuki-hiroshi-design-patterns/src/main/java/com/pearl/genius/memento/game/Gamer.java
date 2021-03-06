package com.pearl.genius.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {

	private int money;
	private List fruits = new ArrayList();
	private Random random = new Random();
	private static String[] fruitsname = {"사과", "포도", "바나나", "귤"};

	public Gamer(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void bet() {
		var dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			System.out.println("소지금이 증가했습니다.");
		} else if (dice == 2) {
			money /= 2;
			System.out.println("소지금이 절반이 되었습니다.");
		} else if (dice == 6) {
			String f = getFruit();
			System.out.println("과일 (" + f + ")을 받았습니다.");
			fruits.add(f);
		} else {
			System.out.println("변한 것이 없습니다.");
		}
	}

	public Memento createMemento() {
		var m = new Memento(money);
		return m;
	}

	public void restoreMomento(Memento memento) {
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}

	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	private String getFruit() {
		var prefix = "";
		if (random.nextBoolean()) {
			prefix = "맛있는";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
