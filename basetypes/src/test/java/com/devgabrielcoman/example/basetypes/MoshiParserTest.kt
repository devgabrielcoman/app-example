package com.devgabrielcoman.example.basetypes

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.io.EOFException

class MoshiParserTest {

    private val parser = MoshiParser()

    @Test
    fun `testParser ToReturn CorrectValue`() = runBlocking {
        // given
        val json = "{\"id\":3, \"name\":\"test\"}"

        // when
        val model = parser.parse(Mock::class.java, json)

        //  then
        Assert.assertEquals(3, model.id)
        Assert.assertEquals("test", model.name)
    }

    @Test
    fun `testParser ToNotReturn CorrectValue`() = runBlocking {
        // given
        val json = ""

        // when
        try {
            val model = parser.parse(Mock::class.java, json)
        } catch (e: Exception) {
            // then
            Assert.assertEquals("End of input", e.message)
            Assert.assertEquals(EOFException::class.java, e::class.java)
        }
    }

    data class Mock(val id: Int, val name: String)
}