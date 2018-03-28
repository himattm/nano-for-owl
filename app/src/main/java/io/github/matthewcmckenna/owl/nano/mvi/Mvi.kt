package io.github.matthewcmckenna.owl.nano.mvi

import io.reactivex.Observable

/**
 * Created by Matt on 3/15/2018.
 */

/**
 * Immutable object which contains all the required information for a business logic to process.
 */
interface MviAction

/**
 * Immutable object which represent an view's intent.
 */
interface MviIntent

/**
 * Immutable object resulting of a processed business logic.
 */
interface MviResult

/**
 * Object representing a UI that will
 * a) emit its intents to a view model,
 * b) subscribes to a view model for rendering its UI.
 *
 * @param I Top class of the [MviIntent] that the [MviView] will be emitting.
 * @param S Top class of the [MviViewState] the [MviView] will be subscribing to.
 */
interface MviView<I : MviIntent, in S : MviViewState> {
    /**
     * Unique [Observable] used by the [MviViewModel]
     * to listen to the [MviView].
     * All the [MviView]'s [MviIntent]s must go through this [Observable].
     */
    fun intents(): Observable<I>

    /**
     * Entry point for the [MviView] to render itself based on a [MviViewState].
     */
    fun render(state: S)
}

/**
 * Object that will subscribes to a [MviView]'s [MviIntent]s,
 * process it and emit a [MviViewState] back.
 *
 * @param I Top class of the [MviIntent] that the [MviViewModel] will be subscribing
 * to.
 * @param S Top class of the [MviViewState] the [MviViewModel] will be emitting.
 */
interface MviViewModel<I : MviIntent, S : MviViewState> {
    fun processIntents(intents: Observable<I>)
    fun states(): Observable<S>
}

/**
 * Immutable object which contains all the required information to render a [MviView].
 */
interface MviViewState
