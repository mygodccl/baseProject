package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest {
	public static void main(String[] args) {
		int a = 5;
		CompletableFuture<String> f = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				return String.valueOf(a);
			}
		});
		
		f.thenApplyAsync(new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return Integer.valueOf(t) + 1;
			}
		}).thenAcceptAsync(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(t);
			}
			
		});
		System.out.println("阿达大赛");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
