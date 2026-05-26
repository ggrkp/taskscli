package taskcli.repository;

import java.util.HashMap;
import java.util.Map;

import taskcli.domain.Task;
import taskcli.spi.ITaskRepository;

public class TaskRepository implements ITaskRepository {

	Map<Integer, Task> tasks;

	public TaskRepository() {
		tasks = new HashMap<>();
	}

	public Task get(int id) {
		Task foundTask = tasks.get(id);
		return (foundTask != null) ? new Task(foundTask) : null;
	}

	public void create(Task task) {
		Task newTask = new Task(task);
		tasks.put(newTask.getId(), newTask);
	}

	public void remove(int id) {
		tasks.remove(id);
	}

	public void update(Task updatedTask) {
		if(updatedTask == null) {
			
		}
		Task newTask = new Task(updatedTask);
		tasks.put(newTask.getId(), newTask);
	}

	@Override
	public String toString() {
		if (tasks.isEmpty()) {
			return "No tasks found.";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("--- TASK LIST ---\n");

		for (Task task : tasks.values()) {
			sb.append(task.toString()).append("\n");
		}

		sb.append("-----------------");
		return sb.toString();
	}

}
