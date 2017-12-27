package test;

public class NumResult {
	private int a;
	private int b;
	private int c;

	public NumResult(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "结果:[a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
