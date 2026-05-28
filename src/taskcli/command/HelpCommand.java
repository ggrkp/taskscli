package taskcli.command;

import java.util.Map;

public class HelpCommand implements ICommand {

	private final Map<String, ICommand> registeredCommands;

	// Injected registry map gives this command a bird's-eye view of all features
	public HelpCommand(Map<String, ICommand> registeredCommands) {
		this.registeredCommands = registeredCommands;
	}

	@Override
	public void execute(String[] args) {
		System.out.println("=========================================");
		System.out.println("         TASK CLI COMMAND MANUAL         ");
		System.out.println("=========================================");
		System.out.println("Available commands by example:\n");

		for (Map.Entry<String, ICommand> entry : registeredCommands.entrySet()) {
			String commandName = entry.getKey().toUpperCase();
			String usageInstructions = entry.getValue().help();

			System.out.printf(" * %-10s -> %s\n", commandName, usageInstructions);
		}
		System.out.println("=========================================");
	}

	@Override
	public String help() {
		return "Example: help (Displays this reference manual)";
	}
}