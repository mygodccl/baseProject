package compatableFuture;

import java.util.concurrent.CompletableFuture;

public class CompatableFutureTest {
	
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(()-> "5");
	}
}
