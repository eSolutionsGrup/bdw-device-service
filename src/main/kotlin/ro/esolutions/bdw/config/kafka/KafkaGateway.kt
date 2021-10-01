package ro.esolutions.bdw.config.kafka

import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway
import ro.esolutions.bdw.config.command.Command

@MessagingGateway
interface KafkaGateway {
    @Gateway(requestChannel = "command")
    fun sendCommand(command: Command?)
}
