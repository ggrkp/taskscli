package taskcli.ui;

import java.util.List;

import taskcli.domain.Task;
import taskcli.domain.TaskStatus;
import taskcli.factory.ServiceFactory;
import taskcli.spi.IServiceFactory;
import taskcli.spi.ITaskService;

public class Application {

	public static void main(String[] args) {
		IServiceFactory serviceFactory = new ServiceFactory();
		
		ITaskService taskService = serviceFactory.createFileBasedTaskService("tasks.json");
		
//		ITaskService taskService = serviceFactory.createTaskService();
//
		taskService.createTask("New Task Title 1");
		taskService.createTask("New Task Title 2");
		taskService.createTask("New Task Title 3");
		taskService.createTask("New Task Title 4");

		System.out.println(taskService.toString());

		taskService.removeTask(1);
		taskService.removeTask(3);
		taskService.createTask("New Task Title 4");
		System.out.println(taskService.toString());

		taskService.updateStatus(2, TaskStatus.DONE);
		System.out.println(taskService.toString());

		List<Task> doneTasks = taskService.searchByStatus(TaskStatus.DONE);
		System.out.println(doneTasks);
	}

}
