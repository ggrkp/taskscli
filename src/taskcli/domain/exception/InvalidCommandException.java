package taskcli.domain.exception;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String key) {
		super(String.format("Command '%s' is invalid. Type help in order to see available commands.", key));
	}

}
