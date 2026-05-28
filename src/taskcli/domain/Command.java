package taskcli.domain;

public enum Command {
	ADD("add"), REMOVE("remove"), UPDATE("update"), LIST("list"), SEARCH("search"), CLEAR("clear"), EXIT("exit");

	private final String commandText;

	Command(String commandText) {
		this.commandText = commandText;
	}

	public static Command fromString(String text) {
		for (Command command : Command.values()) {
			if (command.commandText.equalsIgnoreCase(text.trim())) {
				return command;
			}
		}
		return null;
	}
}
