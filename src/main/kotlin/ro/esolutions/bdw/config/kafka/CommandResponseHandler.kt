package ro.esolutions.bdw.config.kafka

import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import ro.esolutions.bdw.config.command.CommandResponse
import ro.esolutions.bdw.config.command.DeviceCommandGateway

@Component
class CommandResponseHandler(private val deviceCommandGateway: DeviceCommandGateway) {

    @StreamListener("commandResponse")
    fun handleCommandResponse(@Payload response: CommandResponse) {
        deviceCommandGateway.completeCommand(response)
    }
}
