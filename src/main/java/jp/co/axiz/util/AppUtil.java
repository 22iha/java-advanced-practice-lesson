package jp.co.axiz.util;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

public class AppUtil {
	
	
	//isGameAppメソッド
	//GameAppのインスタンスかを判定する
	public static boolean isGameApp(App app) {
		if (app instanceof GameApp) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//isCardGameAppメソッド
	public static boolean isCardGameApp(App app) {
		if(app instanceof CardGameApp) {
			return true;
		}else {
			return false;
		}
	}
	
	//isDartsGameAppメソッド
	public static boolean isDartsGameApp(App app) {
		if(app instanceof DartsGameApp) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//isClockAppメソッド
	public static boolean isClockApp(App app) {
		if(app instanceof ClockApp) {
			return true;
		}else {
			return false;
		}
	}
	
	
	// getAppNameメソッド
	public static String getAppName(App app) {
		String AppName = "";
		
		if (isGameApp(app)) {
			AppName = "ゲーム：";
			
			if (isCardGameApp(app)) {
				AppName = "カード";
			} else if (isDartsGameApp(app)) {
				AppName = "ダーツ";
			}
			
		} else {
			AppName = "時計";
		}
		return AppName;
	}
	
	
}
