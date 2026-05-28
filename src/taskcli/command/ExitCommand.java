package taskcli.command;

public class ExitCommand implements ICommand {

	@Override
	public void execute(String[] args) {
		System.out.println("Exiting Application. Goodbye!");
		System.exit(0);
	}

	@Override
	public String help() {
		return "Example: exit";
	}
}
