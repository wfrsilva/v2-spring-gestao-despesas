# v2-spring-gestao-despesas

Spring Boot - Backend Gestao de Despesas V2- Professora Daniele Leão

Realizando o projeto pela segunda vez, com algumas pequenas alteracoes


## CURSO DE SPRING BOOT | JAVA - Do Absoluto ZERO ao DEPLOY! - Daniele Leão #Java #Spring #SpringBoot

Neste vídeo te mostro como fazer seu primeiro sistema usando Spring boot, totalmente do zero até o deploy em produção!

https://www.youtube.com/watch?v=0V8OKTYNeU8


https://github.com/danileao/javadevweek


# Post Funcionando

## 🔧 Correções aplicadas na Versão 2

Durante a reimplementação do projeto a partir do README da versão 1, o Spring Boot não iniciava corretamente.  
Abaixo estão as correções realizadas até a aplicação voltar a funcionar e o endpoint POST responder com sucesso.

### 🧩 Ajustes de código e configuração

| Arquivo | Problema encontrado | Solução aplicada |
|----------|--------------------|------------------|
| **GestaoDespesaController.java** | Falta de `;` após criação de `ErrorMessage` | Adicionado ponto e vírgula |
| **CadastroDespesaUseCase.java** | Imports ausentes impedindo injeção de dependência | Incluídos imports corretos e anotação `@Service` |
| **DespesaRepository.java** | Import incorreto de `Pageable` (`SpringDataWebProperties.Pageable`) | Corrigido para `org.springframework.data.domain.Pageable` |
| **application.properties** | Erros de digitação nas chaves (`dll-auto` e `driveClassName`) | Corrigido para `spring.jpa.hibernate.ddl-auto` e `spring.datasource.driverClassName` |
| **Banco H2** | Arquivo criado vazio (sem tabela `despesa`) | Removido `data/gestao-despesa.mv.db` e recriado após correção das configs |

### 🚀 Resultado

- Aplicação inicia normalmente (`Tomcat started on port 8080`)
- Endpoint `POST /gestao/create` funcionando (dados sendo persistidos)
- Console H2 acessível em: `http://localhost:8080/h2-console`
- Tabela `DESPESA` criada automaticamente pelo Hibernate

---

### 📸 Prints de funcionamento

**Figura 1 – Requisição POST bem-sucedida (`/gestao/create`)**

> Mostrando retorno `200 OK` e corpo com os dados persistidos.
<img width="1767" height="768" alt="image" src="https://github.com/user-attachments/assets/d363bf2f-7ffb-4130-8bbd-ed42be53f713" />

```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 27 Oct 2025 23:06:38 GMT
Connection: close

{
  "id": "87d0ab95-e14d-408d-8d37-585161e1cd02",
  "descricao": "Cafe de Quarta",
  "data": "2025-06-11",
  "valor": 15,
  "categoria": "refeição",
  "email": "v2@gmail.com",
  "data_criacao": "2025-10-27"
}
```

**Figura 2 – Console H2 após inserção**


http://localhost:8080/h2-console/login.do?jsessionid=7ea3a7012efd8db733e3d5ff9861892c

```sql
SELECT * FROM DESPESA 
```

> Mostrando a tabela `DESPESA` criada e os registros armazenados.
<img width="1104" height="526" alt="image" src="https://github.com/user-attachments/assets/f37893b6-eecf-4110-a07d-a8f18ad2f71d" />

| ID                                   | CATEGORIA | DATA       | DATA_CRIACAO | DESCRICAO         | EMAIL              | VALOR |
|-------------------------------------|------------|-------------|---------------|-------------------|--------------------|--------|
| bf8549bf-a98e-4992-9c7a-693cdf09b0c7 | refeição   | 2025-06-09  | 2025-10-27    | Almoço de Segunda | v2@gmail.com | 45.00 |
| 4b070b84-d371-481d-b1d3-0d17c990766b | refeição   | 2025-06-10  | 2025-10-27    | Almoço de Terça   | v2@gmail.com | 30.00 |
| 87d0ab95-e14d-408d-8d37-585161e1cd02 | refeição   | 2025-06-11  | 2025-10-27    | Cafe de Quarta    | v2@gmail.com | 15.00 |

*(3 rows, 4 ms)*

---

# http://localhost:8080/gestao/v2@gmail.com

para diferenciar, mudei no h2 de v2 para v2
mudei o post.http tambem


**Requisição POST (via `post.http`)**
```http
POST http://localhost:8080/gestao/create
Content-Type: application/json

{
  "categoria": "refeição",
  "data": "2025-06-09",
  "descricao": "Almoço de Segunda",
  "email": "v2@gmail.com",
  "valor": 45.00
}

(...)

```
http://localhost:8080/h2-console/login.do?jsessionid=7ea3a7012efd8db733e3d5ff9861892c

| ID                                   | CATEGORIA | DATA       | DATA_CRIACAO | DESCRICAO         | EMAIL              | VALOR |
|-------------------------------------|------------|-------------|---------------|-------------------|--------------------|--------|
| bf8549bf-a98e-4992-9c7a-693cdf09b0c7 | refeição   | 2025-06-09  | 2025-10-27    | Almoço de Segunda | **v2@gmail.com** | 45.00 |
| 4b070b84-d371-481d-b1d3-0d17c990766b | refeição   | 2025-06-10  | 2025-10-27    | Almoço de Terça   | **v2@gmail.com** | 30.00 |
| 87d0ab95-e14d-408d-8d37-585161e1cd02 | refeição   | 2025-06-11  | 2025-10-27    | Cafe de Quarta    | **v2@gmail.com** | 15.00 |


*(3 rows, 4 ms)*


<img width="1097" height="477" alt="image" src="https://github.com/user-attachments/assets/d8ff88de-50e1-48b2-a731-2928e8aee5be" />


http://localhost:8080/gestao/v2@gmail.com

<img width="555" height="737" alt="image" src="https://github.com/user-attachments/assets/fc87dea8-55fb-470d-b715-2c72be1ce888" />

```json
[
  {
    "id": "bf8549bf-a98e-4992-9c7a-693cdf09b0c7",
    "descricao": "Almoço de Segunda",
    "data": "2025-06-09",
    "valor": 45,
    "categoria": "refeição",
    "email": "v2@gmail.com",
    "data_criacao": "2025-10-27"
  },
  {
    "id": "4b070b84-d371-481d-b1d3-0d17c990766b",
    "descricao": "Almoço de Terça",
    "data": "2025-06-10",
    "valor": 30,
    "categoria": "refeição",
    "email": "v2@gmail.com",
    "data_criacao": "2025-10-27"
  },
  {
    "id": "87d0ab95-e14d-408d-8d37-585161e1cd02",
    "descricao": "Cafe de Quarta",
    "data": "2025-06-11",
    "valor": 15,
    "categoria": "refeição",
    "email": "v2@gmail.com",
    "data_criacao": "2025-10-27"
  }
]
```



# Gerando Seeds
```
2025-10-29T19:15:36.284-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [  restartedMain] .w.g.GestaoDeDespesasPessoaisApplication : Started GestaoDeDespesasPessoaisApplication in 0.491 seconds (process running for 44.017)
Iniciando geracao de seed
Finalizou geração de seed
2025-10-29T19:15:45.353-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged
```

<img width="1914" height="196" alt="image" src="https://github.com/user-attachments/assets/b40c4422-e47a-4901-99c0-f76ecce18bd0" />

http://localhost:8080/h2-console/login.do?jsessionid=e431910b18a55878db8a63c33129476e

## SELECT count(*) FROM DESPESA


| COUNT(*) | 
|----------|
| 300005 |

(1 row, 3 ms)

<img width="711" height="414" alt="image" src="https://github.com/user-attachments/assets/c1bbeb01-e18f-4401-b178-919f7f0a9796" />


## Sem paginacao

```java
package dev.wfrsilva.gestao_despesas.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wfrsilva.gestao_despesas.entity.Despesa;
import dev.wfrsilva.gestao_despesas.repository.DespesaRepository;

@RequestMapping("/gestao/performance")
@RestController
@EnableCaching    
public class GestaoDespesaPerformance {
    
    @Autowired
    DespesaRepository repository;


    @GetMapping("/sem-paginacao")
    public ResponseEntity < List <Despesa>> listarSemPaginacao()
    {
        long inicio = System.currentTimeMillis();
        var despesas = repository.findAll();

        long fim = System.currentTimeMillis();
        System.out.println("Tempo (sem paginação): " + (fim - inicio) + " ms");
        return ResponseEntity.ok(despesas);
    }//listarSemPaginacao

    
}//GestaoDespesaPerformance
```

### WSL sem paginacao


<img width="1898" height="396" alt="image" src="https://github.com/user-attachments/assets/99fe9ded-123b-4f9f-b4c1-9632cad2abe1" />

```
2025-10-29T19:32:47.720-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-10-29T19:32:47.726-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [  restartedMain] .w.g.GestaoDeDespesasPessoaisApplication : Started GestaoDeDespesasPessoaisApplication in 0.601 seconds (process running for 1075.46)
Iniciando geração de seed
Finalizou geração de seed
2025-10-29T19:33:06.925-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged
```


### http://localhost:8080/gestao/performance/sem-paginacao

muitas requisicoes

SELECT count(*) FROM DESPESA;
COUNT(*)  
1200011
(1 row, 1 ms)

<img width="736" height="320" alt="image" src="https://github.com/user-attachments/assets/4a5d1557-b16e-4892-a988-4725033746c1" />


precisei zerar o banco via **application.properties**

spring.jpa.hibernate.ddl-auto=create

```
spring.application.name=Gestao de Despesas Pessoais V2

# ===== CONFIGURACOES H2 ======
spring.datasource.url=jdbc:h2:file:./data/gestao-despesa
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
# spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.ddl-auto=create
```


# http://localhost:8080/gestao/performance/sem-paginacao

<img width="1898" height="189" alt="image" src="https://github.com/user-attachments/assets/f6faf53d-7200-4392-9d90-62aa49a3a9f7" />

```
2025-10-29T19:47:48.734-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [nio-8080-exec-9] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-10-29T19:47:48.735-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [nio-8080-exec-9] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Tempo (sem paginação): 2159 ms
```

<img width="1868" height="771" alt="image" src="https://github.com/user-attachments/assets/2bf47485-cb20-4fcf-a4df-f8670920fd19" />


# http://localhost:8080/gestao/performance/sem-paginacao

<img width="1898" height="189" alt="image" src="https://github.com/user-attachments/assets/f6faf53d-7200-4392-9d90-62aa49a3a9f7" />

```
2025-10-29T19:47:48.734-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [nio-8080-exec-9] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-10-29T19:47:48.735-03:00  INFO 76850 --- [Gestao de Despesas Pessoais V2] [nio-8080-exec-9] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Tempo (sem paginação): 2159 ms
```

<img width="1868" height="771" alt="image" src="https://github.com/user-attachments/assets/2bf47485-cb20-4fcf-a4df-f8670920fd19" />



# http://localhost:8080/gestao/performance/com-paginacao?page=1&size=10

<img width="949" height="976" alt="image" src="https://github.com/user-attachments/assets/322a7020-db8b-4d58-8bcd-c8233bb9dce8" />


```json

(...)



    {
      "id": "a74642f4-1332-43f4-9cc1-180531b48f5b",
      "descricao": "Gasto nº: 15",
      "data": "2025-10-14",
      "valor": 25,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "16187afb-3ede-449d-9271-d215f136c517",
      "descricao": "Gasto nº: 16",
      "data": "2025-10-13",
      "valor": 26,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 10,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 15001,
  "totalElements": 150004,
  "last": false,
  "size": 10,
  "number": 1,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "first": false,
  "numberOfElements": 10,
  "empty": false
}
```


# http://localhost:8080/gestao/performance/com-paginacao?page=1&size=10

<img width="949" height="976" alt="image" src="https://github.com/user-attachments/assets/322a7020-db8b-4d58-8bcd-c8233bb9dce8" />


```json

(...)



    {
      "id": "a74642f4-1332-43f4-9cc1-180531b48f5b",
      "descricao": "Gasto nº: 15",
      "data": "2025-10-14",
      "valor": 25,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "16187afb-3ede-449d-9271-d215f136c517",
      "descricao": "Gasto nº: 16",
      "data": "2025-10-13",
      "valor": 26,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 10,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 15001,
  "totalElements": 150004,
  "last": false,
  "size": 10,
  "number": 1,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "first": false,
  "numberOfElements": 10,
  "empty": false
}
```


# http://localhost:8080/gestao/performance/com-paginacao/v2-performance@gmail.com?page=0&size=10

```
(...)
public class GestaoDespesaPerformance {

(...)

@GetMapping("/com-paginacao/{email}")
    public ResponseEntity <Page <Despesa>> listarComPaginacao(@PathVariable String email, Pageable pageable)
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        var despesas = repository.findByEmail(email, pageable);
        stopWatch.stop();

        System.out.println("Tempo (com paginação): " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(despesas);
    }//listarComPaginacao
    
}//GestaoDespesaPerformance

```
<img width="874" height="983" alt="image" src="https://github.com/user-attachments/assets/08818b29-ade7-4b7f-93c5-37373c7f1c5f" />


```json
{
  "content": [
    {
      "id": "083ada16-d9ad-4f87-b83b-ecac9d3c8866",
      "descricao": "Gasto nº: 0",
      "data": "2025-10-29",
      "valor": 10,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "2a0aaab9-0b63-42de-b4a9-be1a37a435b4",
      "descricao": "Gasto nº: 1",
      "data": "2025-10-28",
      "valor": 11,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "3d5a3c13-e058-475b-b7b1-1806ca404f31",
      "descricao": "Gasto nº: 2",
      "data": "2025-10-27",
      "valor": 12,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "e75fa87a-5351-43dc-a5b8-c0436a25b752",
      "descricao": "Gasto nº: 3",
      "data": "2025-10-26",
      "valor": 13,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "ecde8f94-e4c4-4276-8cbb-23bfbc325e20",
      "descricao": "Gasto nº: 4",
      "data": "2025-10-25",
      "valor": 14,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "d16fcc39-e7a1-4534-b8a0-aa67a9131fcf",
      "descricao": "Gasto nº: 5",
      "data": "2025-10-24",
      "valor": 15,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "b8f90144-2794-4216-9fd0-cfce21c5cc1f",
      "descricao": "Gasto nº: 6",
      "data": "2025-10-23",
      "valor": 16,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "8e298a7a-a901-46dc-9395-b3d1a12c5e6b",
      "descricao": "Gasto nº: 7",
      "data": "2025-10-22",
      "valor": 17,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "8c856863-3f2a-407d-85c2-9501d0e48dbc",
      "descricao": "Gasto nº: 8",
      "data": "2025-10-21",
      "valor": 18,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    },
    {
      "id": "c574c4c0-dd1b-457d-b129-b13533b873a5",
      "descricao": "Gasto nº: 9",
      "data": "2025-10-20",
      "valor": 19,
      "categoria": "TESTE V2",
      "email": "v2-performance@gmail.com",
      "data_criacao": "2025-10-29"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 15001,
  "totalElements": 150001,
  "last": false,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "first": true,
  "numberOfElements": 10,
  "empty": false
}
```


---

---

