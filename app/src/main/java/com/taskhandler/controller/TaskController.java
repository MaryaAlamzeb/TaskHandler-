package com.taskhandler.controller;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.taskhandler.dao.TaskDao;

@javax.servlet.annotation.WebServlet("/tasks")
public class TaskController {

	private static TaskDao taskDao = new TaskDao();

	private static void sendResponse(HttpExchange exchange, int status) throws IOException {
		exchange.sendResponseHeaders(status, -1);
		exchange.getResponseBody().close();
	}

//	public static void configureEndpoints(HttpServer server) {
//		server.createContext("/tasks", new GetTasksHandler());
////	        server.createContext("/tasks", new CreateTaskHandler());
////	        server.createContext("/tasks", new UpdateTaskHandler());
////	        server.createContext("/tasks", new DeleteTaskHandler());
//	}
}