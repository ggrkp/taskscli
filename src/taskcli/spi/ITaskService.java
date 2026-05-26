package taskcli.spi;

import taskcli.domain.TaskStatus;

public interface ITaskService {
	void createTask(String title);

	void removeTask(int id);

	void updateStatus(int id, TaskStatus status);
}
