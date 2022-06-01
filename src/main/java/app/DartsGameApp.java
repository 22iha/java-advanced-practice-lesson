package app;

public class DartsGameApp extends GameApp {
	
	//フィールドなし
	//コンストラクタ_2つ
	public DartsGameApp() {
		super();
	}
	public DartsGameApp(String item) {
		super(item);
	}
	//メソッド_1つ
	public String play() {
		return "10回投げて合計点を競います。";
	}
}
