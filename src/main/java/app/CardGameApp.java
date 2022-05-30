package app;

public class CardGameApp extends GameApp {
	public CardGameApp() {
		super();
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	public String start(String start) {
		String a = start+"さんと"+item+"でゲームを開始します。 ババ抜きを行います。";
		return a;
	}

}
