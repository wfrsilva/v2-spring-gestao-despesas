package dev.wfrsilva.gestao_despesas.performance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.wfrsilva.gestao_despesas.entity.Despesa;
import dev.wfrsilva.gestao_despesas.repository.DespesaRepository;

//@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {
    
    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String ... args) throws Exception
    {
        List <Despesa> despesas = new ArrayList<>();
        System.out.println("Iniciando geração de seed");

        for (int i =0; i <=150000; i++)
        {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto nº: " + i);
            despesa.setValor(BigDecimal.valueOf((10 + (i % 50))));
            despesa.setData(LocalDate.now().minusDays(i % 30));
            despesa.setCategoria("TESTE V2");
            despesa.setEmail("v2-performance@gmail.com");

            despesas.add(despesa);

        }//for

        despesaRepository.saveAll(despesas);
        System.out.println("Finalizou geração de seed");

    }//run

}//GestaoDeDespesaSeeder
