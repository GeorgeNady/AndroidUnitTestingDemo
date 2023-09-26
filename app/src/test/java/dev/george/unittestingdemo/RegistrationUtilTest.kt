package dev.george.unittestingdemo

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `already existing username return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "George",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Nady",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password that not contains at least 2 digits return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Nady",
            "NO DIGITS IN PASSWORD",
            "NO DIGITS IN PASSWORD",
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid inputs return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Nady",
            "12",
            "12"
        )
        assertThat(result).isTrue()
    }

}