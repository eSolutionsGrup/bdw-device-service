package ro.esolutions.bdw.config.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@EnableBinding(KafkaChannels.class)
@IntegrationComponentScan
public class KafkaConfig {
}
