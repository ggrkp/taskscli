package taskcli.spi;

import java.util.List;

import taskcli.domain.Task;
import taskcli.domain.TaskStatus;

public interface ITaskService {

	List<Task> searchByStatus(TaskStatus status);

	void createTask(String title);

	void removeTask(int id);

	void updateStatus(int id, TaskStatus status);
	
	void clear();
}
