package Funds.ecm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>Discription:[启动类]</p>
 **/
@EnableTransactionManagement
@MapperScan("Funds.dao.root")
@EnableScheduling
@SpringBootApplication
public class EcmApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EcmApplication.class, args);
	}

}
