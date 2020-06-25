package will.test.rpc.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// for dubbo to resolve @Reference
@EnableDubbo(scanBasePackages = "will.test.rpc")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
// for spring to auto scan bean
@ComponentScan(value = {"will.test.rpc"})
public class ConsumerConfiguration {

}
