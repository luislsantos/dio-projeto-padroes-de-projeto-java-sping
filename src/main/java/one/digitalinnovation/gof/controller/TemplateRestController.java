package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Template;
import one.digitalinnovation.gof.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("templates")
public class TemplateRestController {

    @Autowired
    private TemplateService templateService;

    @GetMapping
    public ResponseEntity<Iterable<Template>> buscarTodos() {
        return ResponseEntity.ok(templateService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(templateService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Template> inserir(@RequestBody Template template) {
        templateService.inserir(template);
        return ResponseEntity.ok(template);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Template> atualizar(@PathVariable Long id, @RequestBody Template template) {
        templateService.atualizar(id, template);
        return ResponseEntity.ok(template);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        templateService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
