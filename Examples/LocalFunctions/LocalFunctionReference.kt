// LocalFunctions/LocalFunctionReference.kt
// (c)2020 Mindview LLC. See Copyright.txt for permissions.
import localfunctions.*
import atomictest.eq

fun main() {
  fun interesting(session: Session): Boolean {
    if (session.title.contains("Kotlin") &&
      session.speaker in favoriteSpeakers) {
      return true
    }
    // ... more checks
    return false
  }
  sessions.any(::interesting) eq true
}
