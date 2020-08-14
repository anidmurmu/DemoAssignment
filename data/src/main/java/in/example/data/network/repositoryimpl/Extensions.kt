import `in`.example.domain.base.Resource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer

fun <T> applyLoading(): ObservableTransformer<Resource<T>, Resource<T>> = ObservableTransformer { upstream ->
    Observable.just(Resource.loading<T>()).concatWith(upstream)
}

fun Any?.runIfNull(block: () -> Unit) {
    if (this == null) block()
}