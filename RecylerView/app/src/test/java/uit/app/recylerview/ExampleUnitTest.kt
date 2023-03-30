package uit.app.recylerview

import android.content.Context
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.manipulation.Ordering
import org.mockito.MockedConstruction
import org.mockito.Mockito.mock
import uit.app.recylerview.adapter.ItemAdapter
import uit.app.recylerview.model.Affirmation

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {
        val data = listOf(
            Affirmation(R.string.affirmation1,R.drawable.image1),
            Affirmation(R.string.affirmation10,R.drawable.image10)

        )
        val adapter = ItemAdapter(context,data)
        assertEquals("ItemAdapter is not the correct size",data.size,adapter.itemCount)
    }
}