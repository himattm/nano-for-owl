package test.factory

import io.github.matthewcmckenna.owl.nano.remote.vods.model.DataItem
import io.github.matthewcmckenna.owl.nano.remote.vods.model.VodsResponse
import test.factory.DataFactory.Factory.randomUuid


/**
 * Factory class for Bufferoo related instances
 */
class VodsFactory {

    companion object Factory {

        fun makeVodsResponse() = VodsResponse(data = makeVodDataItemList(5))

        fun makeVodDataItemList(count: Int): List<DataItem> {
            val vodEntities = mutableListOf<DataItem>()
            repeat(count) {
                vodEntities.add(makeVodsDataItem())
            }
            return vodEntities
        }

        fun makeVodsDataItem() = DataItem(
                title = randomUuid(),
                status = randomUuid(),
                thumbnail = randomUuid()
        )

    }

}
