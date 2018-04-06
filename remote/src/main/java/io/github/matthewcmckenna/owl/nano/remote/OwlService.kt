package io.github.matthewcmckenna.owl.nano.remote

import io.github.matthewcmckenna.owl.nano.remote.model.vods.VodsResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface OwlService {

    @GET("vods")
    fun getVods(): Flowable<VodsResponse>
}