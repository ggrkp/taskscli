package taskcli.spi;

import taskcli.domain.Task;

public interface ITaskRepository {
	Task get(int id);

	void create(Task task);

	void remove(int id);

	void update(Task updatedTask);
}
