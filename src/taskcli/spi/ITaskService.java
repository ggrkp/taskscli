package taskcli.spi;

import taskcli.domain.Task;

public interface ITaskService {
	void createTask(Task task);

	void removeTask(int id);
}
