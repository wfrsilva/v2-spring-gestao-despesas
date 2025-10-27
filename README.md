# v2-spring-gestao-despesas

Spring Boot - Backend Gestao de Despesas V2- Professora Daniele Leão

Realizando o projeto pela segunda vez, com algumas pequenas alteracoes


## CURSO DE SPRING BOOT | JAVA - Do Absoluto ZERO ao DEPLOY! - Daniele Leão #Java #Spring #SpringBoot

Neste vídeo te mostro como fazer seu primeiro sistema usando Spring boot, totalmente do zero até o deploy em produção!

https://www.youtube.com/watch?v=0V8OKTYNeU8


https://github.com/danileao/javadevweek

### Criando a primeira classe Controller
[38:15 - Primeira Controller](https://youtu.be/0V8OKTYNeU8?t=2295)

```java

 package dev.wfrsilva.gestao_despesas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class PrimeiraController {

    @GetMapping("/codorna")
    public String helloCoturnix()
    {
        //http://localhost:8080/v2/codorna
        return "Olá Codornas!";
    }//helloCoturnix
    
}//PrimeiraController


```

#### Comando para rodar no WSL

wendel@​wfrsilva.dev:~/cursosSpring/gestao-despesas$ `chmod +x mvnw`


wendel@​wfrsilva.dev:~/cursosSpring/gestao-despesas$ `./mvnw spring-boot:run`


(...)


http://localhost:8080/v2/codorna

<img width="354" height="95" alt="image" src="https://github.com/user-attachments/assets/334a9fcc-bf21-4fbf-af15-af91602b1562" />


---



