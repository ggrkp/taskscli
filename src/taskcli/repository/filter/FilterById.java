package taskcli.repository.filter;

import java.util.List;

import taskcli.domain.Task;
import taskcli.domain.TaskStatus;

public class FilterById implements IFilter {

	private final int id;

	public FilterById(int id) {
		this.id = id;
	}

	@Override
	public List<Task> apply(List<Task> tasks) {
		return tasks.stream().filter(task -> task.getId() == id).toList();
	}

}
