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
				
		HttpSession session = request.getSession();
		
		// create Calculator object
		Calc calculator = (Calc)session.getAttribute("calc");
		if (calculator == null){
			calculator = new Calc();
			session.setAttribute("calc",calculator);
			calculator.setResult("0");
			calculator.setResultDetails("");
		}
		// when user click number button (0,1,2,3,4,5,6,7,8,9) or "," button or "C" button
		if (request.getParameterMap().containsKey("btn")){
			String btn = request.getParameter("btn");	// clicked button (value)
			// when "C" button was clicked
			if (btn.equals("C")){
				calculator.setResult("0");
				calculator.setResultDetails("");
				calculator.setA(0);
				calculator.setB(0);
				session.removeAttribute("action");
				session.removeAttribute("score");
				session.removeAttribute("hideComma");
			}
			// when "," button was clicked
			else if (btn.equals(".") && !calculator.getResult().contains(".")){
				calculator.setResult(calculator.getResult() + ".");
				session.setAttribute("hideComma", true);
			}
			// when number button was clicked (0,1,2,3,4,5,6,7,8,9)
			else{				
				if (calculator.getResult().equals("0") || calculator.getA() == 0){
					calculator.setResult("");
				}
				if (session.getAttribute("score") != null) { 
					calculator.setResultDetails(""); 
					calculator.setResult(""); 
					session.removeAttribute("score");
				}
				calculator.setResult(calculator.getResult() + btn);
				calculator.setResultDetails(calculator.getResultDetails() + " " + btn);				
				calculator.setA(Float.parseFloat(calculator.getResult()));
			}
		}
		// when user click action button (+,-,*,/,%,sqrt,+/-)
		if (request.getParameterMap().containsKey("action")){
			String action = request.getParameter("action");
			// if user click action button first time move value A to B, and set current value to A (multiple clicking will change only 'action' attribute)
			if (session.getAttribute("action") == null){	
				calculator.setB(calculator.getA());
				calculator.setA(0);	
			}
			session.setAttribute("action", action);
			if (session.getAttribute("hideComma") != null && session.getAttribute("hideComma").equals(true)) {session.removeAttribute("hideComma");}
			calculator.setResultDetails(calculator.getResultDetails() + " " + action);
			// action "+/-" was selected
			if (session.getAttribute("action").equals("+/-")){
				calculator.changeSign();
				calculator.setA(Float.parseFloat(calculator.getResult()));
				//calculator.setResultDetails(calculator.getResultDetails() + " =");
				session.removeAttribute("action");
				session.setAttribute("score", calculator.getA());
			}
		}
		// when user click "=" button
		if (request.getParameterMap().containsKey("equals")){
			if (session.getAttribute("action") != null){
				// action "+" was selected
				if (session.getAttribute("action").equals("+")){
					calculator.add();
				}
				// action "-" was selected
				if (session.getAttribute("action").equals("-")){
					calculator.sub();
				}
				// action "*" was selected
				// action "/" was selected
				// action "%" was selected
				// action "sqrt" was selected
			}
			calculator.setResultDetails(calculator.getResultDetails() + " =");
			session.removeAttribute("action");
			session.removeAttribute("hideComma");
			session.setAttribute("score", Float.parseFloat(calculator.getResult()));
			
			// if ERROR occurred disable all buttons and display ERR as a result
			//request.setAttribute("hide", true);
			//calculator.setResult("ERR");
			//calculator.setResultDetails("");
		}
		
		// get calculator view from "calcView.jsp" file
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
