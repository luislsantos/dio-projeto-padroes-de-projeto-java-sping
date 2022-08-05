package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Template;
import one.digitalinnovation.gof.model.TemplateRepository;
import one.digitalinnovation.gof.model.Quote;
import one.digitalinnovation.gof.model.QuoteRepository;
import one.digitalinnovation.gof.service.TemplateService;
import one.digitalinnovation.gof.service.ZenQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private ZenQuotesService zenQuotesService;

    @Override
    public Iterable<Template> buscarTodos() {
        return templateRepository.findAll();
    }

    @Override
    public Template buscarPorId(Long id) {
        Optional<Template> template = templateRepository.findById(id);
        return template.get();
    }

    @Override
    public void inserir(Template template) {
        // Verificamos se a pessoa inseriu algo no campo quote
        if (template.getQuote() != null) {
        Quote submittedQuote = template.getQuote();
            // Se inseriu, vamos ver se está no banco. Para isso, formatamos a quote para servir de ID. Não é o ideal, mas
            // é a melhor solução no momento.
            String submittedId = submittedQuote.generateId();
            Quote fullQuote = quoteRepository.findById(submittedId)
                    // Se tiver, vamos obter os outros dados (como o autor).
                    // Se nao tiver, vamos inserir uma nova quote aleatoria agora
                    .orElseGet(this::registerNewQuote);
            template.setQuote(fullQuote);
        } else {
            template.setQuote(registerNewQuote());
        }
        templateRepository.save(template);
    }

    private Quote registerNewQuote() {
        Quote randomQuote = zenQuotesService.getRandomQuote()[0];
        randomQuote.setId(randomQuote.generateId());
        quoteRepository.save(randomQuote);
        return randomQuote;
    }

    @Override
    public void atualizar(Long id, Template template) {
        // Buscar template por ID, caso exista
        Optional<Template> templateBd = templateRepository.findById(id);
        if (templateBd.isPresent()) {
            // Antes de salvar, substituir campos do template que estejam vazios,
            // para não deixar a versão atualizada com menos conteúdo que a original.
            if (template.getTitle() == null) template.setTitle(templateBd.get().getTitle());
            if (template.getQuote() == null) template.setQuote(templateBd.get().getQuote());
            if (template.getImgUrl() == null) template.setImgUrl(templateBd.get().getImgUrl());
            templateRepository.save(template);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar template por ID
        templateRepository.deleteById(id);
    }

}
