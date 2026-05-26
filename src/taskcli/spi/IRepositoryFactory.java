package taskcli.spi;

public interface IRepositoryFactory {
	ITaskRepository createTaskRepository();
}
