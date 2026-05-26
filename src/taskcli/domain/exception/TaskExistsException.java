package taskcli.domain.exception;

public class TaskExistsException extends TaskManagerException {

	private static final long serialVersionUID = 1L;

	public TaskExistsException(int id) {
		super("Task with ID " + id + " already exists.");
	}

}
