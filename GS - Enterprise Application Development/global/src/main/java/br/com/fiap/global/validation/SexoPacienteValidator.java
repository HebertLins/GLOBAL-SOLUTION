package br.com.fiap.global.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SexoPacienteValidator implements ConstraintValidator <SexoPaciente, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("MASCULINO") || value.equals("FEMININO");
    }
}
