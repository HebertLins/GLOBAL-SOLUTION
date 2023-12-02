package br.com.fiap.global.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SexoPacienteValidator.class)
public @interface  SexoPaciente {

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    public String message() default "As únicas opções de sexo aceitas no momento são MASCULINO e FEMININO em letras maiúsculas";

}
