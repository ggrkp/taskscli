package taskcli.service;

import taskcli.domain.IdGenerator;
import taskcli.domain.Task;
import taskcli.domain.TaskStatus;
import taskcli.spi.ITaskRepository;
import taskcli.spi.ITaskService;

public class TaskService implements ITaskService {

	private final ITaskRepository taskRepository;

	public TaskService(ITaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void createTask(String title) {
		System.out.printf("Creating task with title: %s \n", title);
		int newId = IdGenerator.nextId();
		Task task = new Task(newId, title);
		taskRepository.create(task);
	}

	public void removeTask(int id) {
		System.out.printf("Removing task with id: %d \n", id);
		taskRepository.remove(id);
		System.out.printf("Task with ID %s removed. \n", id);
	}

	@Override
	public String toString() {
		return taskRepository.toString();
	}

	@Override
	public void updateStatus(int id, TaskStatus status) {
		Task task = taskRepository.get(id);
		task.setTaskStatus(status);
		taskRepository.update(task);
	}

}
