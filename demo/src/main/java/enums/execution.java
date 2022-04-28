
package enums;

import java.util.HashMap;
import java.util.Map;

public enum execution {

	LOCAL_ENV("local"), REMOTE_ENV("remote");

	private static final Map<String, execution> BY_LABEL = new HashMap<>();
	public final String label;

	execution(String label) {
		this.label = label;
	}

	static {
		for (execution e : values()) {
			BY_LABEL.put(e.label, e);
		}
	}

	public static execution valueOfLabel(String label) {
		return BY_LABEL.get(label);
	}

}