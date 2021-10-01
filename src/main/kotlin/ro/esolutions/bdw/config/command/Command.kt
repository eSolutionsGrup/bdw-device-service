package ro.esolutions.bdw.config.command

import java.util.*

class Command {
    val uid = UUID.randomUUID().toString()
}
class CommandResponse(val uid: String)