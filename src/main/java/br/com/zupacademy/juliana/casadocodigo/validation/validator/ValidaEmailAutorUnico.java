package br.com.zupacademy.juliana.casadocodigo.validation.validator;

import br.com.zupacademy.juliana.casadocodigo.model.Autor;
import br.com.zupacademy.juliana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoAutorRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ValidaEmailAutorUnico implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorRequisicao.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {


        NovoAutorRequisicao requisicao = (NovoAutorRequisicao) o;
        List<Autor> autores = autorRepository
                .findByEmail(requisicao.getEmail());

        if (!autores.isEmpty()) {
            errors.rejectValue("email", null,
                    "Autor cadastrado com esse e-mail "
                            + requisicao.getEmail());
        }
    }
}
