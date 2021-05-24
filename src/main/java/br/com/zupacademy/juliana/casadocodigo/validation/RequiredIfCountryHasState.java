package br.com.zupacademy.juliana.casadocodigo.validation;

import br.com.zupacademy.juliana.casadocodigo.request.NovoClienteRequisicao;
import br.com.zupacademy.juliana.casadocodigo.validation.interfaces.RequiredIfCondition;

import javax.persistence.EntityManager;

public class RequiredIfCountryHasState implements RequiredIfCondition<NovoClienteRequisicao> {

    @Override
    public Boolean isRequired(EntityManager manager, NovoClienteRequisicao request) {
        var resultList =  manager
                .createQuery("from State s where s.country.id = " + request.getPaisId())
                .getResultList();
        return !resultList.isEmpty();
    }
}