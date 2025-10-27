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
