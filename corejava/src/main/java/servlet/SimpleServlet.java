package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

public class SimpleServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StopWatch stopWatch = new Log4JStopWatch();
		PrintWriter out = response.getWriter();
		out.println("SimpleServlet Executed");
		out.flush();
		out.close();
		try {
			Thread.sleep((long) (Math.random() * 1000L));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopWatch.lap("firstBlock");

	}
}