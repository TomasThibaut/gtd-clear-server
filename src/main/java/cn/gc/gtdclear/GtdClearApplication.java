package cn.gc.gtdclear;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.gc.gtdclear.repository")
public class GtdClearApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtdClearApplication.class, args);
	}

}

