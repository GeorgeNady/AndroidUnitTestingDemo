package dev.george.unittestingdemo

object RegistrationUtil {

    private const val TAG = "RegistrationUtil"
    private val fakeInternalRepo = listOf("George", "Joseph")

    /**
     * the input is not valid if...
     * ...the user/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as real password
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username:String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        val isUsernameValid = validateUsernameInput(username)
//        Log.d(TAG,"isUsernameValid = $isUsernameValid")
        val isPasswordValid = validatePassword(password)
//        Log.d(TAG,"isPasswordValid = $isPasswordValid")
        val isConfirmedPasswordValid = validateConfirmedPassword(password, confirmedPassword)
//        Log.d(TAG,"isConfirmedPasswordValid = $isConfirmedPasswordValid")
        return isUsernameValid && isPasswordValid && isConfirmedPasswordValid
    }


    /**
     * the username is not valid if...
     * ...is empty
     * ...is already taken
     */
    private fun validateUsernameInput(username: String): Boolean {
        val isUsernameAlreadyTaken = fakeInternalRepo.contains(username)
        val isUsernameEmpty = username.isEmpty()
        return !isUsernameAlreadyTaken && !isUsernameEmpty
    }

    /**
     * the password is not valid if...
     * ...is empty
     * ...is contains less than 2 digits
     */
    private fun validatePassword(password: String) : Boolean {
        val isPasswordEmpty = password.isEmpty()

        var digitsCounter = 0
        password.forEach {
            if (it.isDigit()) digitsCounter++
        }
        val isPasswordContainsTwoDigest = digitsCounter >= 2
        return !isPasswordEmpty && isPasswordContainsTwoDigest
    }

    /**
     * the confirmed password is not valid if...
     * ...the confirmed password is not the same as real password
     */
    private fun validateConfirmedPassword(password: String, confirmedPassword: String): Boolean {
        val isConfirmedPasswordNotEqualsPassword = confirmedPassword != password
        return !isConfirmedPasswordNotEqualsPassword
    }

}