package app;

public abstract class GameApp implements App {
	public abstract String play();
	
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
		String m = start + "さんと" +item+"でゲームを開始します。";
		String p = play();
		return m + p;
	}
	
}
