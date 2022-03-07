package by.prohor.booklib.controller;

import by.prohor.booklib.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/books", produces = "application/json")
public class WebClientController {
    private WebClient webClient;

    @PostConstruct
    private void setWebClient(){
        webClient = WebClient.create("http://localhost:4000");
    }

    @GetMapping("/{id}")
    public Mono getById(@PathVariable("id") String id){
        return webClient
                .get()
                .uri("books/{id}", id)
                .retrieve()
                .bodyToMono(Book.class);
    }
}
