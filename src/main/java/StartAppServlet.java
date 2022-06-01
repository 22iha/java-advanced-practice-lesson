
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.App;
import app.CardGameApp;
import app.ClockApp;
import app.DartsGameApp;

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
        if(name != null && !name.isEmpty()) {
        
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
			
        	//その他
			//例外処理
			try {
				result = app.start(name);
			}catch(Exception ex){
				result = "アプリの実行に失敗しました。" ;
			}
            
			// startメソッドを呼び、戻り値を変数resultへ代入する
            

            request.setAttribute("result", result);
        }
    
        request.getRequestDispatcher("appStart.jsp").forward(request, response);
    }
}
