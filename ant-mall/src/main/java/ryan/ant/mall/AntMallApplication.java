package ryan.ant.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ryan.ant.mall.dao")
public class AntMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntMallApplication.class, args);
	}

}
