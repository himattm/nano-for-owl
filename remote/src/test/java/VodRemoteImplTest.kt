import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.github.matthewcmckenna.owl.nano.data.model.VodsEntity
import io.github.matthewcmckenna.owl.nano.remote.OwlService
import io.github.matthewcmckenna.owl.nano.remote.vods.VodsRemoteImpl
import io.github.matthewcmckenna.owl.nano.remote.vods.mapper.VodsEntityMapper
import io.github.matthewcmckenna.owl.nano.remote.vods.model.VodsResponse
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import test.factory.VodsFactory


@RunWith(JUnit4::class)
class VodRemoteImplTest {

    private lateinit var entityMapper: VodsEntityMapper
    private lateinit var vodService: OwlService

    private lateinit var vodRemoteImpl: VodsRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        vodService = mock()
        vodRemoteImpl = VodsRemoteImpl(vodService, entityMapper)
    }

    //<editor-fold desc="Get Vods">
    @Test
    fun getVodsCompletes() {
        stubVodsServiceGetVods(Flowable.just(VodsFactory.makeVodsResponse()))
        val testObserver = vodRemoteImpl.getVods().test()
        testObserver.assertComplete()
    }

    @Test
    fun getVodsReturnsData() {
        val vodResponse = VodsFactory.makeVodsResponse()
        stubVodsServiceGetVods(Flowable.just(vodResponse))
        val vodEntities = mutableListOf<VodsEntity>()
        vodResponse.data?.filterNotNull()?.forEach {
            vodEntities.add(entityMapper.mapFromRemote(it))
        }

        val testObserver = vodRemoteImpl.getVods().test()
        testObserver.assertValue(vodEntities)
    }
    //</editor-fold>

    private fun stubVodsServiceGetVods(observable: Flowable<VodsResponse>) {
        whenever(vodService.getVods()).thenReturn(observable)
    }
}
