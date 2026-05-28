package taskcli.command;

import taskcli.spi.ITaskService;

public class RemoveCommand implements ICommand {
	private final ITaskService taskService;

	// The constructor captures the state upfront
	public RemoveCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			System.out.println("Error: Requres a valid id." + help());
			return;
		}
		try {
			int id = Integer.parseInt(args[0].trim());
			taskService.removeTask(id);
		} catch (NumberFormatException e) {
			System.out.println("Error: The ID must be a number (e.g., 1, 2, 3). You provided: '" + args[0] + "'");
			return;
		}
	}

	@Override
	public String help() {
		return "Example: remove 3";
	}

}
