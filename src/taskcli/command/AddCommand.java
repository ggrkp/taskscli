package taskcli.command;

import taskcli.spi.ITaskService;

public class AddCommand implements ICommand {

	private final ITaskService taskService;

	public AddCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1 || args[0].trim().isEmpty()) {
			System.out.println("Error: Title required. " + help());
			return;
		}
		taskService.createTask(args[0]);
	}

	@Override
	public String help() {
		return "Example: add Clean my room";
	}

}
