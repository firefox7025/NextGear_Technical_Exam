package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Primary Startup Application</h1>
 * <p>This class will contain only the main method, responsible for starting the spring boot application</p>
 *
 * @author Alexander Montgomery
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
