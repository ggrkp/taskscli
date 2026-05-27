package taskcli.repository.filter;

import java.util.List;

import taskcli.domain.Task;

public interface IFilter {
	List<Task> apply(List<Task> tasks);
}
