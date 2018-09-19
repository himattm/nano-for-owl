package io.github.matthewcmckenna.owl.nano.data.repository

import io.github.matthewcmckenna.owl.nano.data.model.VodsEntity
import io.reactivex.Flowable

/**
 * Interface defining methods for the caching of Vods. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface VodsRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getVods(): Flowable<List<VodsEntity>>

}
