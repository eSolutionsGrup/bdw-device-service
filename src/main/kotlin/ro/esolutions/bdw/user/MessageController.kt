package ro.esolutions.bdw.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ro.esolutions.bdw.config.command.Command
import ro.esolutions.bdw.config.command.DeviceCommandGateway

@RestController
@RequestMapping("/message")
class MessageController(private val commandGateway: DeviceCommandGateway) {

    @GetMapping
    fun getMessage(): String {
        val response = commandGateway.sendAndWaitResponse(Command())
        return response.uid
    }

}