package taskcli.ui;

import taskcli.factory.CommandFactory;
import taskcli.factory.ServiceFactory;

public class Application {

	public static void main(String[] args) {
		ServiceFactory serviceFactory = new ServiceFactory();
		CommandFactory cmdFactory = new CommandFactory(serviceFactory.createFileBasedTaskService("tasks.json"));
		Terminal terminal = new Terminal(cmdFactory);
		terminal.start();
	}
}