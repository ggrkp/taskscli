package taskcli.ui;

import taskcli.domain.Identifier;
import taskcli.domain.Task;
import taskcli.factory.ServiceFactory;
import taskcli.spi.IServiceFactory;
import taskcli.spi.ITaskService;

public class Application {

	public static void main(String[] args) {
		IServiceFactory serviceFactory = new ServiceFactory();
		
		ITaskService taskService = serviceFactory.createTaskService();

		taskService.createTask(new Task(Identifier.nextId(), "New Task Title 1"));
		taskService.createTask(new Task(Identifier.nextId(), "New Task Title 2"));
		taskService.createTask(new Task(Identifier.nextId(), "New Task Title 3"));
		taskService.createTask(new Task(Identifier.nextId(), "New Task Title 4"));

		System.out.println(taskService.toString());

		taskService.removeTask(1);
		taskService.removeTask(3);
		taskService.createTask(new Task(Identifier.nextId(), "New Task Title 4"));

		System.out.println(taskService.toString());

	}

}
