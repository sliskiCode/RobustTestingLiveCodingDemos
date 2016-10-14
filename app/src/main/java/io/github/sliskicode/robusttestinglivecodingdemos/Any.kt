package io.github.sliskicode.robusttestinglivecodingdemos

fun <T> T?.isNull() = this == null

fun <T> T?.isNotNull() = this != null

inline fun <T> T?.ifNull(function: (T?) -> Unit) {
    if (this == null) function(this)
}

inline fun <T> T?.ifNotNull(function: (T) -> Unit) {
    if (this != null) function(this)
}
