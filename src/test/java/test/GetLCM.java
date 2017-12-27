package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.springframework.util.StopWatch;

public class GetLCM {
	
	/**
	 * 求ab最小公倍数10000, bc20000, ac20000...满足条件abc有多少
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		List<NumCup> ab = new ArrayList<>();
		List<NumCup> bc = new ArrayList<>();
		List<NumCup> ac = new ArrayList<>();
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		new Thread(new TaskNum(ab, countDownLatch, 10000)).start();
		new Thread(new TaskNum(bc, countDownLatch, 20000)).start();
		new Thread(new TaskNum(ac, countDownLatch, 20000)).start();
		
		countDownLatch.await();
//		getAll(10000, ab);
//		getAll(20000, bc);
//		getAll(20000, ac);
		
		Set<NumResult> acb = new HashSet<>();
		
		for (NumCup numCupAB : ab) {
			int a1 = numCupAB.getA();
			int b1 = numCupAB.getB();
			for (NumCup numCupBC : bc) {
				int b2 = numCupBC.getA();
				int c2 = numCupBC.getB();
				if(b1 == b2) {
					for (NumCup numCupAC : ac) {
						int a3 = numCupAC.getA();
						int c3 = numCupAC.getB();
						if(c2 == c3 && a1 == a3) {
							acb.add(new NumResult(a1, b1, c2));
						}
					}
				}
			}
		}
		
		acb.forEach(c -> System.out.println(c));
		System.out.println(acb.size());
		
		stopWatch.stop();
		System.out.println(stopWatch.getTotalTimeSeconds());
	}

	public static List<NumCup> getAll(int num, List<NumCup> cups) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				int a = i;
				int b = j;
				int result;
				int mod = a % b;
				if (mod == 0) {
					result = a;
				} else {
					int out = getMaxMult(a, b);
					result = a * b / out;
				}

				if (result == num) {
					cups.add(new NumCup(i, j));
				}

			}
		}
		return cups;
	}

	public static int getMaxMult(int a, int b) {
		int m = a % b;
		while (m != 0) {
			a = b;
			b = m;
			m = a % b;
		}
		return b;
	}

}