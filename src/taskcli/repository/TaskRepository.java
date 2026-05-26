package taskcli.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import taskcli.domain.Task;
import taskcli.domain.exception.TaskExistsException;
import taskcli.domain.exception.TaskManagerException;
import taskcli.domain.exception.TaskNotFoundException;
import taskcli.spi.ITaskRepository;

public class TaskRepository implements ITaskRepository {

	private final Map<Integer, Task> tasks;

	public TaskRepository() {
		tasks = new ConcurrentHashMap<>();
	}

	public Task get(int id) {
		Task foundTask = tasks.get(id);
		if (foundTask == null) {
			throw new TaskNotFoundException(id);
		}
		return new Task(foundTask);
	}

	public void create(Task task) {
		if (task == null) {
			throw new TaskManagerException("Task cannot be null.");
		}
		int newTaskId = task.getId();
		if (tasks.containsKey(newTaskId)) {
			throw new TaskExistsException(newTaskId);
		}
		Task newTask = new Task(task);
		tasks.put(newTask.getId(), newTask);
	}

	public void remove(int id) {
		Task removedTask = tasks.remove(id);
		if (removedTask == null) {
			throw new TaskNotFoundException(id);
		}
	}

	public void update(Task updatedTask) {
		if (updatedTask == null) {
			throw new TaskManagerException("Task cannot be null.");
		}
		int updatedTaskId = updatedTask.getId();
		if (!tasks.containsKey(updatedTaskId)) {
			throw new TaskNotFoundException(updatedTaskId);
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
