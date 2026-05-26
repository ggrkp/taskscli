package taskcli.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Identifier {
	private static final AtomicInteger counter = new AtomicInteger(0);

	public static int nextId() {
		return counter.incrementAndGet();
	}
}
