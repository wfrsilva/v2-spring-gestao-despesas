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
  "email": "wfrsilva@gmail.com",
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
| bf8549bf-a98e-4992-9c7a-693cdf09b0c7 | refeição   | 2025-06-09  | 2025-10-27    | Almoço de Segunda | wfrsilva@gmail.com | 45.00 |
| 4b070b84-d371-481d-b1d3-0d17c990766b | refeição   | 2025-06-10  | 2025-10-27    | Almoço de Terça   | wfrsilva@gmail.com | 30.00 |
| 87d0ab95-e14d-408d-8d37-585161e1cd02 | refeição   | 2025-06-11  | 2025-10-27    | Cafe de Quarta    | wfrsilva@gmail.com | 15.00 |

*(3 rows, 4 ms)*

---

