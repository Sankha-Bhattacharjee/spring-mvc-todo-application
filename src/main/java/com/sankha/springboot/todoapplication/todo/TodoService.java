package com.sankha.springboot.todoapplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "Sankha", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Sankha", "Learn ML", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Sankha", "Learn GCP", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo newTodo = new Todo(++todosCount, username, description, targetDate, isDone);
		todos.add(newTodo);
	}
	
	public void deleteById(int id) {
		//predicate is a condition
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
