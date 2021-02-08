
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dyadlows
 */
public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String action = request.getParameter("reset");
        if( action != null && action.equals("true") ){
            session.invalidate();
            session = request.getSession();
        }
        
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("number_list");
        if ( numberList == null ){
            numberList = new ArrayList<Integer>();
        }
        
        if (request.getParameter("input_number") != null){
            int number = Integer.parseInt( request.getParameter("input_number") );
            numberList.add(number);
            session.setAttribute("number_list", numberList);
        }
        
        // calculate average (Why yes, I dabble in arithmetic)
        double average = 0.0;
        for( int number : numberList ){
            average += number;
        }
        if( numberList.size() > 0 ){
            average /= numberList.size();
        }
        
        
        request.setAttribute("average",average);

        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // not used for this demo
    }

}
