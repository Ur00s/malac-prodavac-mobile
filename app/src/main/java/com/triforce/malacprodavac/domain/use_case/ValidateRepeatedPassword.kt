package com.triforce.malacprodavac.domain.use_case

class ValidateRepeatedPassword {
    fun execute(password: String, repeatedPassword: String):ValidationResult {
        if(password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "Lozinka se ne poklapa"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}