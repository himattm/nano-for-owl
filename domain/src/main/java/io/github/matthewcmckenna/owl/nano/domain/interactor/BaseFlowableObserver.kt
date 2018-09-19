package io.github.matthewcmckenna.owl.nano.domain.interactor

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

open class BaseFlowableObserver<T> : SingleObserver<T> {
    override fun onSuccess(value: T) {
        // no-op
    }

    override fun onSubscribe(d: Disposable?) {
        // no-op
    }

    override fun onError(e: Throwable?) {
        // no-op
    }

}
