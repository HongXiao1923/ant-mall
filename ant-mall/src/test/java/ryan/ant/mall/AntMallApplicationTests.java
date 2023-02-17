package ryan.ant.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class AntMallApplicationTests {

	@Autowired
	private DataSource defaultDataSource;

	@Test
	public void databaseSourceTest() throws SQLException{
		Connection conn = defaultDataSource.getConnection();
		System.out.print("获取数据库连接：");
		System.out.println(conn != null);
		conn.close();
	}

	/*@Test
	public void dataSourceClassTest() throws SQLException{
		System.out.println("默认数据源为：" + defaultDataSource,getClass());	//数据类型为：HikariDataSource
	}*/

	@Test
	void contextLoads() {
	}

}
