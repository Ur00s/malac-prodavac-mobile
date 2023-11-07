package com.triforce.malacprodavac.domain.use_case

import android.util.Patterns as Patterns

class ValidateEmail {

    fun execute(email: String):ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Email adresa ne može biti prazna"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "To nije važeća email adresa"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}