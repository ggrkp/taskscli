package taskcli.domain;

public class Task {

	public Task() {}
	
	public Task(Task other) {
		this.id = other.id;
		this.title = other.title;
		this.taskStatus = other.taskStatus;
	}

	public Task(int id, String title, TaskStatus taskStatus) {
		this.id = id;
		this.title = title;
		this.taskStatus = taskStatus;
	}

	public Task(int id, String title) {
		this(id, title, TaskStatus.TODO);
	}

	private int id;

	private String title;

	private TaskStatus taskStatus;

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s - %s", id, title, taskStatus);
	}
}
