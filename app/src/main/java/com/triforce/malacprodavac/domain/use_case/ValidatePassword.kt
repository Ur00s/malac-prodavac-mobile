package com.triforce.malacprodavac.domain.use_case

class ValidatePassword {
    fun execute(password: String):ValidationResult {
        if(password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "Lozinka mora da sadrži barem 8 karaktera"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "Lozinka mora da sadrži barem 1 broj i slovo"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}