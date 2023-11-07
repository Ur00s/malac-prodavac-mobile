package com.triforce.malacprodavac.domain.use_case

class ValidateTerms {
    fun execute(acceptedTerms: Boolean):ValidationResult {
        if(!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Molim Vas prihvatite uslove"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}