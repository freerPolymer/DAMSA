import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.polymer.db.base.IConstant;
import com.polymer.db.mapper.SysUser;
import com.polymer.db.mapper.SysUserMapper;
import com.polymer.db.mapper.SystemMenus;
import com.polymer.db.util.CRPUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.polymer.db.DBApplication.class)
@SpringBootConfiguration
public class DBTest {

	@Autowired
	private SysUserMapper userMapper;

	@Test
	public void find(){
		System.out.println(userMapper.getAll());
	}

	@Test
	public void test(){
		String ch=IConstant.NUMBER_STR+IConstant.UPPER_ABC_STR+System.currentTimeMillis();
		String id=CRPUtils.getRandomChar(ch,32);

		System.out.println(id);

	}


	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void redisTest(){
		ValueOperations<String, SysUser> operations = redisTemplate.opsForValue();
		operations.set("5225552d4f4s4f488e5f222a2",new SysUser("dkkfdke332kld","号","55f2d5e5e5-df4d4f4d4==",false,new Date()));

		System.out.println(operations.get("5225552d4f4s4f488e5f222a2"));
	}

}
