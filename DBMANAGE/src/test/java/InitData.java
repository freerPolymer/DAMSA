import com.polymer.db.base.IConstant;
import com.polymer.db.util.CRPUtils;
import com.polymer.db.util.CodecsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * SQL拼接。 基础数据初始化脚本生成
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class InitData {

	@Test
	public void initData(){
		// 非线程安全的SQL语句生成工具
		StringBuilder sql = new StringBuilder();

		sql.append(" /* DAMSA系统初始化SQL */ \n");
		sql.append(" /* DDL for mysql 8.x */ \n");
		sql.append(" -- 注意：如果使用的是DBeaver工具连接的数据库，那么上述属性在需要在驱动属性中设置 allowMultiQueries 为 true \n");
		sql.append(" use db_msa; \n");
		sql.append("begin; \n");
		sql.append("set autocommit=0; \n");
		sql.append("start transaction; \n");
		sql.append(" /*系统基础数据初始化*/ \n");
		sql.append(" -- 默认用户名密码(MD5数据加密)：admin adsh3009 \n");
		sql.append(" insert into sys_user(sid,name,`password`,enabled,create_time) \n");
		sql.append(" values( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','admin','"+CodecsUtil.MD5("adsh3009","adminadsh3009")+"',1,now() \n");
		sql.append(" ),( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','develop','"+CodecsUtil.MD5("123456","develop123456")+"',0,now() \n");
		sql.append(" ); \n");

		sql.append(" insert into sys_roles(rid,name,code,expired) \n");
		sql.append(" values ( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','系统管理员','SYS_MANAGER',0 \n");
		sql.append(" ); \n");

		sql.append(" -- permission 为json格式的菜单列表，其中标注可读，可写属性 \n");
		sql.append(" insert into sys_permissions(pid,name,permission,expired,create_time,modify_time) \n");
		sql.append(" values( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','系统管理员','{\"ALL\":\"*\"}',1,now(),null \n");
		sql.append(" ); \n");

		sql.append(" insert into sys_menus (`mid`,parent,name,url,logo,enabled,create_time,modify_time) \n");
		sql.append(" values ( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','ROOT','权限列表','/system/manager/db/','',1,now(),null \n");
		sql.append(" ); \n");

		sql.append(" insert into sys_department (did,name,address,logo,enabled,create_time,modify_time) \n");
		sql.append(" values( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','技术部','xx省xx市xx区xx路xx号豪苑大厦1507-208','',1,now(),null \n");
		sql.append(" ); \n");

		sql.append(" insert into cus_user (cid,name,`password`,enabled,create_time,modify_time) \n");
		sql.append(" values( \n");
		sql.append(" '"+ CRPUtils.getRandomChar(32) +"','ly','"+CodecsUtil.MD5("ly0000","lyly0000")+"',0,now(),null \n");
		sql.append(" ); \n");
		sql.append("commit; \n\n");

		System.out.println(sql);

		File outsql= new File(this.getClass().getResource("").getPath()+"data_init_"+System.currentTimeMillis()+".sql");

		RandomAccessFile file = null;
		FileChannel fileChannel = null;
		ByteBuffer buffer = null;
		try {
			if(!outsql.exists())
				outsql.createNewFile();
			// 开始准备写出
			file = new RandomAccessFile(outsql, "rw");
			fileChannel = file.getChannel();
			//使用直接分配内存方式
			int capacity=(int)(sql.capacity()*1.28);
			buffer = ByteBuffer.allocateDirect(capacity);
			buffer.put(sql.toString().getBytes(IConstant.CHAR_SET));
			buffer.flip();
			fileChannel.write(buffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			buffer.clear();
			fileChannel.close();
			file.close();
			System.out.println(outsql.getAbsolutePath());
		} catch (IOException e) {throw new RuntimeException(e);}
	}
}
