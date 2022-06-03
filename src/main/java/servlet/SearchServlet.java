package servlet;

import java.io.IOException;
//import java.util.Dictionary;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ここに必要な処理を記述してください。

		request.setCharacterEncoding("UTF-8");
		String english = request.getParameter("english");

		Dictionary dictionary = new Dictionary();
		HashMap<String, String> dictionaryInfo = dictionary.getDictionaryInfo();

		String result = "";

		// 未入力、空文字ではないか
		if (english != null && !english.isEmpty()) {


			// 検索結果があった場合
			// 値があるか確認
			if (dictionaryInfo.containsKey(english)) {
				// 値があったらgetして表示
				String japanese = dictionaryInfo.get(english);
				result = "英語：" + english + "日本語：" + japanese;

			} else {
				// key(日本語)が無い場合の表示
				result = "見つかりませんでした。";
			}

		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("dictionary.jsp").forward(request, response);
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
