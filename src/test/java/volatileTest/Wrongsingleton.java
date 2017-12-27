package volatileTest;

public class Wrongsingleton {
	private static volatile Wrongsingleton _instance = null;

	private Wrongsingleton() {
	}

	public static Wrongsingleton getInstance() {

		if (_instance == null) {
			_instance = new Wrongsingleton();
		}

		return _instance;
	}
}