package io.github.matthewcmckenna.owl.nano.remote.vods

import io.github.matthewcmckenna.owl.nano.data.model.VodsEntity
import io.github.matthewcmckenna.owl.nano.data.repository.VodsRemote
import io.github.matthewcmckenna.owl.nano.remote.OwlService
import io.github.matthewcmckenna.owl.nano.remote.vods.mapper.VodsEntityMapper
import io.reactivex.Flowable
import javax.inject.Inject

class VodsRemoteImpl @Inject constructor(
        private val vodsService: OwlService,
        private val entityMapper: VodsEntityMapper
) : VodsRemote {

    override fun getVods(): Flowable<List<VodsEntity>> {
        return vodsService.getVods()
                .map { it.data!! }
                .map { list ->
                    val entries = mutableListOf<VodsEntity>()
                    list.filterNotNull().forEach { entries.add(entityMapper.mapFromRemote(it)) }
                    entries
                }
    }
}
