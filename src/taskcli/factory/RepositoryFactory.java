package taskcli.factory;

import taskcli.repository.TaskRepository;
import taskcli.spi.IRepositoryFactory;

public class RepositoryFactory implements IRepositoryFactory {

	public TaskRepository createTaskRepository() {
		return new TaskRepository();
	}

}
