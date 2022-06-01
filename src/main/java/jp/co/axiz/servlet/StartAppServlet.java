package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;



/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String appType = request.getParameter("appType");
        
        
        App app = null;
        
      //nameがnullか空文字かを判断する
		if (name == null || name.isEmpty()) {
			// ユーザ名未入力の場合は何もせず、appStart.jspへ遷移
			request.getRequestDispatcher("appStart.jsp").forward(request, response);
			return;
		}

		switch (appType) {
		case "card":
			app = new CardGameApp("トランプ");
			break;
		case "darts":
			app = new DartsGameApp("ダーツ");
			break;
		case "clock":
			app = new ClockApp();
			break;
		}

		// アプリ実行結果のメッセージを入れるための変数
		String result = "";

		// その他
		// 例外処理
		try {
			result = app.start(name);

			if (app instanceof GameApp) {
				// GameAppを継承したクラスの場合、playTimeフィールドの値をリクエストスコープへセットする

				GameApp gameApp = (GameApp) app;
				// 型をGameAppに変換
				int playTime = gameApp.getPlayTime();
				// playTimeフィールドの値を取得

				request.setAttribute("playTime", playTime);
				// リクエストスコープへセット
				
				result += "実行時間" + gameApp.getPlayTime() + "分";
			}

		} catch (Exception ex) {
			result = "アプリの実行に失敗しました。";
		}

		// startメソッドを呼び、戻り値を変数resultへ代入する

		request.setAttribute("result", result);

		request.getRequestDispatcher("appStart.jsp").forward(request, response);
	}
}
