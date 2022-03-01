package practiceproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class Product extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String ID=request.getParameter("productID");
		Dashboard db=new Dashboard();
		String qry="select ProductName,ProductID from product where ProductId = ?";
		try {
			db.prep=db.conn.prepareStatement(qry);
			db.prep.setString(1, ID);
			db.theResultSet=db.prep.executeQuery();
			boolean flag=false;
			while(db.theResultSet.next()) {
				out.println("ID : "+db.theResultSet.getInt("ProductId")+" <br>belongs to PRODUCT NAME: "+db.theResultSet.getString("ProductName"));
				flag = true;
				break;
			}
			if(!flag) {
				out.println("Invalid product id");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product.html");
				dispatcher.include(request, response);
			}
		}
		catch(SQLException e) {
			System.out.println("Issue with query");
		}
	}
	
}
