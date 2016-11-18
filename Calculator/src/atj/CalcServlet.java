package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet(description = "calculator", urlPatterns = { "/CalculatorServlet" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
		
		HttpSession session = request.getSession();
		
		Calc calculator = (Calc)session.getAttribute("calc");
		if (calculator == null){
			calculator = new Calc();
			session.setAttribute("calc",calculator);
			calculator.setResult("0");
			calculator.setResultDetails("");
		}
		
		if (request.getParameterMap().containsKey("btn")){
			String btn = request.getParameter("btn");
			if (btn.equals("C")){
				calculator.setResult("0");
				calculator.setResultDetails("");
				calculator.setA(0);
				calculator.setB(0);
			}
			else if (btn.equals(",")){
				// jkjkjkj
			}
			else{
				//calculator.setA(Integer.parseInt(btn));
				//calculator.setResult(btn);
				if (calculator.getResult().equals("0")){
					calculator.setResult("");
				}
				
				
				calculator.setResult(calculator.getResult() + btn);
				
				
				calculator.setA(Integer.parseInt(calculator.getResult()));
				calculator.setResultDetails(calculator.getResultDetails() + " " + btn);
			}
		}
		if (request.getParameterMap().containsKey("action")){
			String action = request.getParameter("action");
			session.setAttribute("action", action);
			
			calculator.setAction(action);
			calculator.setResultDetails(calculator.getResultDetails() + " " + action);
		}
		if (request.getParameterMap().containsKey("equals")){
			if (calculator.getAction() != null){
				calculator.calculate((String)session.getAttribute("action"));
				calculator.setResultDetails(calculator.getResultDetails() + " =");
			}
		}
			
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/calcView.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
