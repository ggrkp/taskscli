package taskcli.spi;

public interface IRepositoryFactory {
	ITaskRepository createTaskRepository();
	
	ITaskRepository createFileSystemTaskRepository(String filePath);
}
