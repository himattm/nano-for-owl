package io.github.matthewcmckenna.owl.nano.domain.repository

import io.github.matthewcmckenna.owl.nano.domain.model.VodsModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface VodsRepository {

    fun clearVods(): Completable

    fun saveVods(vods: List<VodsModel>): Completable

    fun getVods(): Flowable<List<VodsModel>>
}
