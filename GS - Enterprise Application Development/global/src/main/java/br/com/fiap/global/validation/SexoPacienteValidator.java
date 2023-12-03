package br.com.fiap.global.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SexoPacienteValidator implements ConstraintValidator <SexoPaciente, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equals("MASCULINO") || value.equals("FEMININO"));
    }
}
