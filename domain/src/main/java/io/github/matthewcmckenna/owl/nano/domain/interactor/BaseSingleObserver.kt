package io.github.matthewcmckenna.owl.nano.domain.interactor

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable


open class BaseSingleObserver<T> : SingleObserver<T> {

    override fun onSuccess(value: T) {}

    override fun onSubscribe(d: Disposable?) {}

    override fun onError(e: Throwable?) {}

}
