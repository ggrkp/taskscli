package taskcli.command;

import taskcli.spi.ITaskService;

public class ClearCommand implements ICommand {

	private final ITaskService taskService;

	public ClearCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		taskService.clear();
		System.out.println("All tasks have been successfully cleared.");
	}

	@Override
	public String help() {
		return "Example: clear";
	}
}
