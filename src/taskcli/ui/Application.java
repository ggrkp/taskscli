package taskcli.ui;

import java.util.Scanner;

import taskcli.command.ICommand;
import taskcli.domain.exception.InvalidCommandException;
import taskcli.domain.exception.TaskManagerException;
import taskcli.factory.CommandFactory;
import taskcli.factory.ServiceFactory;

public class Application {

	public static void main(String[] args) {
		ServiceFactory serviceFactory = new ServiceFactory();
		CommandFactory cmdFactory = new CommandFactory(serviceFactory.createFileBasedTaskService("tasks.json"));
		System.out.println("=========================================");
		System.out.println("    WELCOME TO THE TASK CLI MANAGER      ");
		System.out.println("=========================================");
		System.out.println("Available commands: add, remove, update, list, search, clear, exit\n");

		try (Scanner scanner = new Scanner(System.in)) {
			boolean running = true;

			while (running) {
				System.out.print("task-cli> ");
				String input = scanner.nextLine().trim();
				if (input.isEmpty())
					continue;

				String[] segments = input.split(" ", 2);
				String commandKeyword = segments[0];
				String[] commandArgs = (segments.length > 1) ? new String[] { segments[1] } : new String[0];

				try {
					ICommand executionCommand = cmdFactory.getCommand(commandKeyword);
					if (executionCommand == null) {
						System.out.printf(
								"Error: '%s' is not a recognized command. Type 'help' to view available options.\n",
								commandKeyword);
						continue;
					}
					executionCommand.execute(commandArgs);
				} catch (TaskManagerException | InvalidCommandException exception) {
					System.out.println(exception.getMessage());
					continue;
				}

				System.out.println();
			}
		}
	}
}