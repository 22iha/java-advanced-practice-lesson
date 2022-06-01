package jp.co.axiz.app;

public abstract class GameApp implements App {
	protected abstract String play();
	
	//ゲームに使用する道具名を表す文字列
	//フィールド
	private String item;
	//アクセサ
	public String getItem(){
		return this.item;
	}
	public void setItem(String item){
		this.item = item;
	}
	
	//追加したフィールド
	private int playTime;
	//アクセサ
	public int getPlayTime() {
		return this.playTime;
	}
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	
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
