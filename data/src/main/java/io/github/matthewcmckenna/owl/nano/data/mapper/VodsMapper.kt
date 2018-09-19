package io.github.matthewcmckenna.owl.nano.data.mapper

import io.github.matthewcmckenna.owl.nano.data.model.VodsEntity
import io.github.matthewcmckenna.owl.nano.domain.model.VodsModel
import javax.inject.Inject


open class VodsMapper @Inject constructor() : Mapper<VodsEntity, VodsModel> {
    override fun mapFromEntity(type: VodsEntity): VodsModel {
        TODO("Implement Mapper mapFromEntity")
//        return VodsModel(type.title, type.thumbnail, type.status, type.m3u8Link)
    }

    override fun mapToEntity(type: VodsModel): VodsEntity {
        TODO("Implement Mapper mapToEntity")
    }

}
