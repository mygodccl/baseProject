
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccl.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4j2Test {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() throws Exception {
		MDC.put("user", "开车不直播, 出事贴吧找老哥.");//对应配置文件pattern中%X{user}变量
		logger.trace("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.error("I am error log.");
	}
}