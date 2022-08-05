package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Template;

public interface TemplateService {

    Iterable<Template> buscarTodos();

    Template buscarPorId(Long id);

    void inserir(Template template);

    void atualizar(Long id, Template template);

    void deletar (Long id);
}
