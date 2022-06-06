package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.util.AppUtil;

class AppUtilTest {
	
	//isGameApp入力データパターン
	@Test
	void gametest1() {
//		fail("まだ実装されていません");
		App app = new CardGameApp();
		boolean result = AppUtil.isGameApp(app);
		boolean expected = true;
		
		//想定と結果の比較
		assertEquals(expected,result);
	}
	@Test
	void gametest2() {
		App app = new DartsGameApp();
		boolean result = AppUtil.isGameApp(app);
		boolean expected = true;
		
		assertEquals(expected,result);
	}
	@Test
	void gametest3() {
		App app = new ClockApp();
		boolean result = AppUtil.isGameApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	
	//isCardGameApp入力データパターン
	@Test
	void card1test() {
		App app = new CardGameApp();
		boolean result = AppUtil.isCardGameApp(app);
		boolean expected = true;
		
		assertEquals(expected,result);
	}
	@Test
	void card2test() {
		App app = new DartsGameApp();
		boolean result = AppUtil.isCardGameApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	@Test
	void card3test() {
		App app = new ClockApp();
		boolean result = AppUtil.isCardGameApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	
	//isDartsGameApp入力データパターン
	@Test
	void darts1test() {
		App app = new CardGameApp();
		boolean result = AppUtil.isDartsGameApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	@Test
	void darts2test() {
		App app = new DartsGameApp();
		boolean result = AppUtil.isDartsGameApp(app);
		boolean expected = true;
		
		assertEquals(expected,result);
	}
	@Test
	void darts3test() {
		App app = new ClockApp();
		boolean result = AppUtil.isDartsGameApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	
	//isClockApp入力データパターン
	@Test
	void clock1test() {
		App app = new CardGameApp();
		boolean result = AppUtil.isClockApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	@Test
	void clock2test() {
		App app = new DartsGameApp();
		boolean result = AppUtil.isClockApp(app);
		boolean expected = false;
		
		assertEquals(expected,result);
	}
	@Test
	void clock3test() {
		App app = new ClockApp();
		boolean result = AppUtil.isClockApp(app);
		boolean expected = true;
		
		assertEquals(expected,result);
	}
	
	//getAppName入力データパターン
	@Test
	void name1test() {
		App app = new CardGameApp();
		String result = AppUtil.getAppName(app);
		String expected = "カード";
		
		assertEquals(expected,result);
	}
	@Test
	void name2test() {
		App app = new DartsGameApp();
		String result = AppUtil.getAppName(app);
		String expected = "ダーツ";
		
		assertEquals(expected,result);
	}
	@Test
	void name3test() {
		App app = new ClockApp();
		String result = AppUtil.getAppName(app);
		String expected = "時計";
		
		assertEquals(expected,result);
	}
	

}
