
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ccl.Application;
import com.ccl.admin.entity.User;
import com.ccl.admin.entity.UserRole;
import com.ccl.admin.service.IUserRoleService;
import com.ccl.admin.service.IUserService;
import com.ccl.common.datasource.DBTypeEnum;
import com.ccl.common.datasource.DbContextHolder;
import com.google.common.collect.Lists;


@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisPlusTest {
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserRoleService userrole;

	@Test
	public void testInsert() throws Exception {
		User entity = new User("ccl", "1234", "2385");
		userService.insert(entity);
	}
	
	@Test
	public void testUpdate() throws Exception {
		User findByName = userService.findByName("ccl");
		User user = new User();
		user.setId(findByName.getId());
		user.setPhone("6666");
		userService.updateById(user);
	}
	
	@Test
	public void testPage() throws Exception {
		Wrapper<User> wrapper = new EntityWrapper<User>();
		wrapper.where("password={0}", 1234);
		userService.delete(wrapper);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testquery() throws Exception {
		Page<User> page = new Page<>(1, 5);
		Page<User> selectUserPage = userService.selectUserPage(page);
		List<User> records = selectUserPage.getRecords();
	}
	
	@Test
	public void testCreateData() {
		List<User> selectByMap = userService.selectByMap(null);
		List<UserRole>  userRole = Lists.newArrayList();
		for (User user : selectByMap) {
			UserRole e1 = new UserRole();
			e1.setUserid(user.getId());
			e1.setRoleid(1L);
			UserRole e2 = new UserRole();
			e2.setUserid(user.getId());
			e2.setRoleid(2L);
			userRole.add(e1);
			userRole.add(e2);
		}
		userrole.insertBatch(userRole);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testDynamicSource() throws Exception {
		List<User> userList = userService.selectList(new EntityWrapper<User>());
		
		DbContextHolder.setDbType(DBTypeEnum.two);
		List<User> userList2 = userService.selectList(new EntityWrapper<User>());
	}
	
}