package taskcli.spi;

import java.util.List;

import taskcli.domain.Task;
import taskcli.repository.filter.IFilter;

public interface ITaskRepository {
	List<Task> get(IFilter filter);

	void create(Task task);

	void remove(int id);

	void update(Task updatedTask);

}
