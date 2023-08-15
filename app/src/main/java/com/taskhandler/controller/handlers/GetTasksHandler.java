package com.taskhandler.controller.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.taskhandler.dao.TaskDao;
import com.taskhandler.entity.Task;

public class GetTasksHandler implements HttpHandler {

	private TaskDao taskDao = new TaskDao();

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		List<Task> tasks = taskDao.getAllTasks();
		String response = tasks.toString();
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}