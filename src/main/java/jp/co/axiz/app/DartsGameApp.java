package jp.co.axiz.app;

public class DartsGameApp extends GameApp {
	
	//フィールドなし
	//コンストラクタ_2つ
	public DartsGameApp() {
		super();
	}
	public DartsGameApp(String item) {
		super(item);
		//10を代入
		setPlayTime(10);
		
	}
	//メソッド_1つ
	protected String play() {
		return "10回投げて合計点を競います。";
	}
}
