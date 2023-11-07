package com.triforce.malacprodavac.domain.use_case

class ValidateLastName {
    fun execute(lastName: String):ValidationResult {
        if(lastName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Prezime ne može biti prazno"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}