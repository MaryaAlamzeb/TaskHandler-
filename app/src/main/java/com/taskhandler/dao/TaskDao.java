package com.taskhandler.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.taskhandler.database.DatabaseConfig;
import com.taskhandler.entity.Task;

public class TaskDao {
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		try (Connection connection = DatabaseConfig.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Task")) {

			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setDescription(resultSet.getString("description"));
				task.setDate(resultSet.getDate("date"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

//	public void createTask(Task task) {
//		try (Connection connection = DatabaseConfig.getConnection();
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("INSERT INTO tasks (description, date) VALUES (?, ?)")) {
//
//			preparedStatement.setString(1, task.getDescription());
//			preparedStatement.setDate(2, new java.sql.Date(task.getDate().getTime()));
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void updateTask(Task task) {
//		try (Connection connection = DatabaseConfig.getConnection();
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("UPDATE tasks SET description = ?, date = ? WHERE id = ?")) {
//
//			preparedStatement.setString(1, task.getDescription());
//			preparedStatement.setDate(2, new java.sql.Date(task.getDate().getTime()));
//			preparedStatement.setInt(3, task.getId());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteTask(int taskId) {
//		try (Connection connection = DatabaseConfig.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tasks WHERE id = ?")) {
//
//			preparedStatement.setInt(1, taskId);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}