package taskcli.command;

import java.util.List;

import taskcli.domain.Task;
import taskcli.domain.TaskStatus;
import taskcli.spi.ITaskService;

public class SearchCommand implements ICommand {

	private final ITaskService taskService;

	public SearchCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1 || args[0].trim().isEmpty()) {
			System.out.println("Error: Specify a status. " + help());
			return;
		}
		try {
			TaskStatus targetStatus = TaskStatus.valueOf(args[0].trim().toUpperCase());
			List<Task> tasksByStatus = taskService.searchByStatus(targetStatus);
			if (tasksByStatus.isEmpty()) {
				System.out.println("No tasks found matching status: " + targetStatus);
				return;
			}
			tasksByStatus.forEach(System.out::println);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: Invalid search status. Choose from: TODO, IN_PROGRESS, DONE.");
			return;
		}

	}

	@Override
	public String help() {
		return "Example: search TODO";
	}
}
