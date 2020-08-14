package `in`.example.domain.base

interface UseCase<P> {
    interface Callback {
        fun onSuccess()
        fun onError(throwable: Throwable)
    }

    suspend fun execute(param: P, callback: Callback)
}

interface UseCaseNetwork<P> {
    interface Callback {
        fun onSuccess()
        fun onError(throwable: Throwable)
    }

    fun execute(param: P, callback: Callback)
}