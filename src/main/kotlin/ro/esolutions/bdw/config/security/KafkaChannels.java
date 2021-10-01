package ro.esolutions.bdw.config.security;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {
    @Input
    MessageChannel commandResponse();

    @Output
    MessageChannel command();
}
