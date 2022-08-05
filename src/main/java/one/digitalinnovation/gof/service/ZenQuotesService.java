package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zenquotes", url = "https://zenquotes.io/api")
public interface ZenQuotesService {

    @GetMapping("/quotes/")
    Quote getAllQuotes();

    @GetMapping("/today/")
    Quote getTodayQuote();
    @GetMapping("/random/")
    Quote[] getRandomQuote();
}
