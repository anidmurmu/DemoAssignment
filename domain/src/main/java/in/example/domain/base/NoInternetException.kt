package `in`.example.domain.base

import java.io.IOException

class NoInternetException(message: String) : IOException(message)