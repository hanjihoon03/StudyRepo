import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"module-test-domain","module-test-mvc"})
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class,args);
    }
}
