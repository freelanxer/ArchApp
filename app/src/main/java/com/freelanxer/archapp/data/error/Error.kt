package com.freelanxer.archapp.data.error

import java.lang.Exception

class Error(
    val code: Int,
    val description: String,
) {
    constructor(exception: Exception): this(code = DEFAULT_ERROR, description = exception.message ?: "")
}

const val DEFAULT_ERROR = -1
const val NETWORK_ERROR = -2