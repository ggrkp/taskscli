package taskcli.command;

import taskcli.domain.TaskStatus;
import taskcli.spi.ITaskService;

public class UpdateCommand implements ICommand {

	private final ITaskService taskService;

	public UpdateCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		// 1. Validate that we received enough text input
		if (args.length < 1 || args[0].trim().isEmpty()) {
			System.out.println("Error: Missing parameters. " + help());
			return;
		}

		// Split the single remaining argument string into [id, status]
		String[] subTokens = args[0].trim().split(" ", 2);
		if (subTokens.length < 2) {
			System.out.println("Error: Both ID and Status are required. " + help());
			return;
		}
		try {
			int id = Integer.parseInt(subTokens[0].trim());
			TaskStatus status = TaskStatus.valueOf(subTokens[1].trim().toUpperCase());
			taskService.updateStatus(id, status);
			System.out.printf("Task %d updated successfully.\n", id);
		} catch (NumberFormatException e) {
			System.out.println("Error: The task ID must be a whole number.");
			return;
		} catch (IllegalArgumentException e) { // todo: remove
			System.out.println("Error: Invalid task status provided. Choose from: TODO, DOING, DONE.");
			return;
		}

	}

	@Override
	public String help() {
		return "Example: update 1 IN_PROGRESS";
	}
}
