package taskcli.factory;

import java.util.HashMap;
import java.util.Map;

import taskcli.command.AddCommand;
import taskcli.command.ClearCommand;
import taskcli.command.ExitCommand;
import taskcli.command.HelpCommand;
import taskcli.command.ICommand;
import taskcli.command.ListCommand;
import taskcli.command.RemoveCommand;
import taskcli.command.SearchCommand;
import taskcli.command.UpdateCommand;
import taskcli.domain.exception.InvalidCommandException;
import taskcli.spi.ITaskService;

public class CommandFactory {
	private final Map<String, ICommand> commands = new HashMap<>();

	ServiceFactory serviceFactory = new ServiceFactory();

	public CommandFactory(ITaskService service) {
		commands.put("add", new AddCommand(service));
		commands.put("remove", new RemoveCommand(service));
		commands.put("clear", new ClearCommand(service));
		commands.put("update", new UpdateCommand(service));
		commands.put("exit", new ExitCommand());
		commands.put("search", new SearchCommand(service));
		commands.put("list", new ListCommand(service));
		commands.put("help", new HelpCommand(this.commands));
	}

	public ICommand getCommand(String key) throws InvalidCommandException {
		ICommand command = commands.get(key.toLowerCase().trim());
		if (command == null) {
			throw new InvalidCommandException(key);
		}
		return command;
	}

}
