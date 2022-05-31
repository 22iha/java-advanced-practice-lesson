
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CardGameApp;
import app.GameApp;

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
        
        //nameがnullか空文字かを判断する
        if (name != null && !name.isEmpty()) {
        	
            GameApp app;
            //ゲームなら何か、カードならトランプ
			if(appType.equals("game")) {
        		app = new GameApp("何か");
        	}else{
        		app = new CardGameApp("トランプ");
        	}
			
			// アプリ実行結果のメッセージを入れるための変数
			String result = "";
            
			// startメソッドを呼び、戻り値を変数resultへ代入する
            result = app.start(name);

            request.setAttribute("result", result);
        }
    

        request.getRequestDispatcher("appStart.jsp").forward(request, response);
    }
}
