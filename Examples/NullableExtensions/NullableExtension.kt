// NullableExtensions/NullableExtension.kt
// (c)2020 Mindview LLC. See Copyright.txt for permissions.
package nullableextensions
import atomictest.eq

fun String?.isNullOrEmpty(): Boolean =
  this == null || isEmpty()

fun main() {
  "".isNullOrEmpty() eq true
}
