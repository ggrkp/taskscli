package taskcli.spi;

public interface IServiceFactory {
	ITaskService createTaskService();
	
	ITaskService createFileBasedTaskService(String filePath);
}
