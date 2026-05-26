package taskcli.service;

import taskcli.domain.Task;
import taskcli.spi.ITaskRepository;
import taskcli.spi.ITaskService;

public class TaskService implements ITaskService {

	private final ITaskRepository taskRepository;

	public TaskService(ITaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void createTask(Task task) {		
		System.out.printf("Creating task with title: %s \n", task.getTitle());
		taskRepository.create(task);
	}

	public void removeTask(int id) {
		System.out.printf("Removing task with id: %d \n", id);
		taskRepository.remove(id);
	}
	
	@Override
	public String toString() {
		return taskRepository.toString();
	}

}
