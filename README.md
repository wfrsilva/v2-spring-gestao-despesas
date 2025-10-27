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

**Figura 2 – Console H2 após inserção**

> Mostrando a tabela `DESPESA` criada e os registros armazenados.

---
