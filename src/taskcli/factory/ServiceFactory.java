package taskcli.factory;

import taskcli.service.TaskService;
import taskcli.spi.IServiceFactory;
import taskcli.spi.IRepositoryFactory;
import taskcli.spi.ITaskService;

public class ServiceFactory implements IServiceFactory {

	IRepositoryFactory repositoryFactory = new RepositoryFactory();

	public ITaskService createTaskService() {
		return new TaskService(repositoryFactory.createTaskRepository());
	}

	public ITaskService createFileBasedTaskService(String filePath) {
		return new TaskService(repositoryFactory.createFileSystemTaskRepository(filePath));
	}

}
