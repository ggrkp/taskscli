package taskcli.repository.filter;

import java.util.List;

import taskcli.domain.Task;
import taskcli.domain.TaskStatus;

public class FilterByStatus implements IFilter {

	private final TaskStatus status;

	public FilterByStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public List<Task> apply(List<Task> tasks) {
		return tasks.stream().filter(task -> task.getTaskStatus().equals(status)).toList();
	}

}
  