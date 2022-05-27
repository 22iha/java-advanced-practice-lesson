package app;

public class GameApp {
	
	//ゲームに使用する道具名を表す文字列
	//フィールド
	public String item;
	
	//コンストラクタ
	public GameApp() {
	}
	public GameApp(String item) {
		this.item = item;
	}
	
	//メソッド
	public String start(String start) {
		String m = start + "さんと" +item+"でゲームを開始します";
		return m;
	}
	
}
