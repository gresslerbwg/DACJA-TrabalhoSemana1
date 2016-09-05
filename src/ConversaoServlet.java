import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SomaServlet
 */
@WebServlet("/converter")
public class ConversaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double temp1 = Double.parseDouble(request.getParameter("temperatura"));
		int conversao = Integer.parseInt(request.getParameter("conversao"));
		Double temp2;
		if(conversao == 0){
			temp2= ((temp1 * 9) / 5) + 32;
		}else{
			temp2= ((temp1 - 32) * 5) / 9;
		}
		String saida1 = String.format("%.1f", temp1);
		String saida2 = String.format("%.1f", temp2);
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out= response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Temperatura</title>");
			out.println("</head>");
			out.println("<body>");
			if(conversao == 0){
				out.println("<h1>" + saida1 + "°C equivalem a "+ saida2 + "°F</h1>");
			}else{
				out.println("<h1>" + saida1 + "°F equivalem a "+ saida2 + "°C</h1>");
			}
			out.println("</body>");
			out.println("<html>");
		}
	}
}
