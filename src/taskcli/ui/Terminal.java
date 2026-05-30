package taskcli.ui;

import java.util.Scanner;
import taskcli.command.ICommand;
import taskcli.domain.exception.InvalidCommandException;
import taskcli.domain.exception.TaskManagerException;
import taskcli.factory.CommandFactory;

public class Terminal {

	private final CommandFactory cmdFactory;

	public Terminal(CommandFactory cmdFactory) {
		this.cmdFactory = cmdFactory;
	}

	public void start() {
		printWelcomeHeader();

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("task-cli> ");
				String input = scanner.nextLine().trim();

				if (input.isEmpty()) {
					continue;
				}

				processInput(input);
				System.out.println();
			}
		}
	}

	private void processInput(String input) {
		String[] segments = input.split(" ", 2);
		String commandKeyword = segments[0];
		String[] commandArgs = (segments.length > 1) ? new String[] { segments[1] } : new String[0];

		try {
			ICommand executionCommand = cmdFactory.getCommand(commandKeyword);
			if (executionCommand == null) {
				System.out.printf("Error: '%s' is not a recognized command. Type 'help' to view available options.\n",
						commandKeyword);
				return;
			}
			executionCommand.execute(commandArgs);
		} catch (TaskManagerException | InvalidCommandException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void printWelcomeHeader() {
		System.out.println("=========================================");
		System.out.println("    WELCOME TO THE TASK CLI MANAGER      ");
		System.out.println("=========================================");
		System.out.println("Available commands: add, remove, update, list, search, clear, exit\n");
	}
}
