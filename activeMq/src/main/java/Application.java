import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(value = "com.taihui.springboot.activemq")
@EnableJms //启动jms， Java消息服务
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        Queue queue = (Queue) context.getBean("queue");
        try {
            String queueName = queue.getQueueName();
            System.out.println(queueName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
