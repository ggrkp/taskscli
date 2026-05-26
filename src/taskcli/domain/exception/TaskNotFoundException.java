package taskcli.domain.exception;

public class TaskNotFoundException extends TaskManagerException {

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(int id) {
		super("Task with ID " + id + " could not be found.");
	}

}
