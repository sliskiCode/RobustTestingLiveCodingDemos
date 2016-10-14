package io.github.sliskicode.robusttestinglivecodingdemos

import org.junit.Test

/**
 * 10
 */
class KotlinNamingArgumentsTest {

    val tested = KotlinNamingArguments()

    @Test
    fun `should make some cool suff but I do not know what`() {
        tested.foo(name = "Piotr",
                   surname = "Slesarew",
                   city = "Cracow",
                   country = "Poland")
    }

    class KotlinNamingArguments {
        fun foo(name: String,
                surname: String,
                city: String,
                country: String) = 3
    }
}