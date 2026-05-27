package taskcli.factory;

import taskcli.repository.TaskRepository;
import taskcli.repository.FileSystemTaskRepositoryDecorator;

import taskcli.spi.IRepositoryFactory;
import taskcli.spi.ITaskRepository;

public class RepositoryFactory implements IRepositoryFactory {

	public ITaskRepository createTaskRepository() {
		return new TaskRepository();
	}

	public ITaskRepository createFileSystemTaskRepository(String filePath) {
		return new FileSystemTaskRepositoryDecorator(filePath);
	}

}
