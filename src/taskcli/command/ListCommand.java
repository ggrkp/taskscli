package taskcli.command;

import taskcli.spi.ITaskService;

public class ListCommand implements ICommand {
	private final ITaskService taskService;

	// The constructor captures the state upfront
	public ListCommand(ITaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void execute(String[] args) {
		System.out.println(taskService.toString());
	}

	@Override
	public String help() {
		return "Example: list";
	}

}
