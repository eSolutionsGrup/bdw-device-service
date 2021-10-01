package ro.esolutions.bdw.config.security

import java.util.*

class Command {
    val uid = UUID.randomUUID().toString()
}
class CommandResponse(val uid: String)