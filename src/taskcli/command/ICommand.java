package taskcli.command;

public interface ICommand {

	void execute(String[] args);

	String help();
}
