package taskcli.repository;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import taskcli.domain.IdGenerator;
import taskcli.domain.Task;
import taskcli.repository.filter.IFilter;
import taskcli.spi.ITaskRepository;

public class FileSystemTaskRepositoryWrapper implements ITaskRepository {

	private final ITaskRepository repository;

	private final Path path;

	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public FileSystemTaskRepositoryWrapper(String filePath) {
		this(filePath, new TaskRepository());
	}

	public FileSystemTaskRepositoryWrapper(String filePath, ITaskRepository repository) {
		if (filePath == null || filePath.isEmpty()) {
			throw new IllegalArgumentException("File path cannot be null");
		}
		this.repository = repository;
		this.path = Paths.get(filePath);
		initializeFileStorage();
		loadTasksIntoMemory();
	}

	@Override
	public Task get(int id) {
		return repository.get(id);
	}

	@Override
	public List<Task> get(IFilter filter) {
		return repository.get(filter);
	}

	@Override
	public void create(Task task) {
		repository.create(task);
		flushToDisk();
	}

	@Override
	public void remove(int id) {
		repository.remove(id);
		flushToDisk();
	}

	@Override
	public void update(Task updatedTask) {
		repository.update(updatedTask);
		flushToDisk();
	}

	@Override
	public String toString() {
		return repository.toString();
	}

	private void initializeFileStorage() {
		try {
			Path parentDir = path.getParent();
			if (parentDir != null && Files.notExists(parentDir)) {
				Files.createDirectories(parentDir);
			}
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to initializ file storage.", e);
		}
	}

	private void loadTasksIntoMemory() {
		System.out.println("Initializing tasks from file...");
		try {
			if (Files.size(path) == 0)
				return;
		} catch (IOException e) {
			throw new RuntimeException("Could not read file size attributes.", e);
		}

		Type taskListType = new TypeToken<List<Task>>() {
		}.getType();

		try (Reader reader = Files.newBufferedReader(path)) {
			List<Task> loadedTasks = gson.fromJson(reader, taskListType);
			if (loadedTasks == null) {
				return;
			}
			int maxId = 0;
			for (Task task : loadedTasks) {
				this.repository.create(task);
				if (task.getId() > maxId) {
					maxId = task.getId();
				}
			}
			IdGenerator.synchronize(maxId);
		} catch (IOException e) {
			throw new RuntimeException("Something went wrong while initializing database snapshot.", e);
		}
	}

	private synchronized void flushToDisk() {
		try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.WRITE,
				StandardOpenOption.TRUNCATE_EXISTING)) {
			List<Task> currentTasksInMap = repository.get(tasks -> tasks);
			gson.toJson(currentTasksInMap, writer);
		} catch (IOException e) {
			throw new RuntimeException("Storage failure: Could not commit updates to system disk.", e);
		}
	}

	@Override
	public void clear() {
		this.repository.clear();
		flushToDisk();
	}

}