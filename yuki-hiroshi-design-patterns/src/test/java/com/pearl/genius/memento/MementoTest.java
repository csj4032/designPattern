package com.pearl.genius.memento;

import com.pearl.genius.memento.game.Gamer;
import org.junit.Test;

/**
 * 메멘토 패턴(memento pattern)은 객체를 이전 상태로 되돌릴 수 있는 기능을 제공하는 소프트웨어 디자인 패턴
 */
public class MementoTest {

	@Test
	public void test() {
		var gamer = new Gamer(100);
		var memento = gamer.createMemento();

		for (int i = 0; i < 100; i++) {
			System.out.println("===" + i);
			System.out.println("현상 : " + gamer);
			gamer.bet();
			System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

			if (gamer.getMoney() > memento.getMoney()) {
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				gamer.restoreMomento(memento);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
}
