package com.fujie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujie.modle.Sport;


/**
 * Servlet implementation class TestAjaxServlet
 */

public class TestAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------接收到请求---------------------");
		/**
         * for ajax-cross-domain request TODO get the ip address from
         * configration(ajax-cross-domain.properties)
         */
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
//        response.setDateHeader("Expires", 0); // Proxies.
//		String[] list ={"篮球","足球","滑冰","游泳","羽毛球"};
		List<Sport> sports = new ArrayList<Sport>();	
		sports.add(new Sport("篮球"));
		sports.add(new Sport("足球"));
		sports.add(new Sport("滑冰"));
		sports.add(new Sport("游泳"));
		sports.add(new Sport("羽毛球"));
		PrintWriter out = response.getWriter();  
//		System.out.println(JsonUtils.list2json(sports));	
//        out.write(JsonUtils.list2json(sports));  	
//		
	}

}
