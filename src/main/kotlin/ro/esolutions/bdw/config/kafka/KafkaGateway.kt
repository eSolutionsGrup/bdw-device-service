package ro.esolutions.bdw.config.kafka

import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway
import ro.esolutions.bdw.config.security.Command

@MessagingGateway
interface KafkaGateway {
    @Gateway(requestChannel = "command")
    fun sendCommand(command: Command?)
}
