package ro.esolutions.bdw.config.security

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.springframework.stereotype.Service
import ro.esolutions.bdw.config.kafka.KafkaGateway
import java.util.concurrent.ConcurrentHashMap

@Service
class DeviceCommandGateway(
    private val kafkaGateway: KafkaGateway
) {
    private val commands = ConcurrentHashMap<String, CompletableDeferred<CommandResponse>>()

    fun sendAndWaitResponse(command: Command): CommandResponse = runBlocking {
        kafkaGateway.sendCommand(command)

        val deferred = CompletableDeferred<CommandResponse>()
        commands[command.uid] = deferred
        try {
            withTimeout(25000) {
                deferred.await().also { println("received response: $it") }
            }
        } catch (e: TimeoutCancellationException) {
            deferred.cancel(e)
            commands.remove(command.uid)
            println("command $command timed out")
            throw IllegalStateException("device not found")
        }
    }

    fun completeCommand(response: CommandResponse) {
        val deferred = commands[response.uid]
        deferred?.let {
            deferred.complete(response)
            commands.remove(response.uid)
        } ?:run{
            println("unknown response received: ${response.uid}")
        }
    }
}
