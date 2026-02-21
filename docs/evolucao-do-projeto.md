# 📈 Evolução do Projeto

Este documento registra a evolução do **Sistema de Restaurante POO** ao longo das 19 aulas do **Módulo 1 - Introdução ao Java** do curso Java Elite.

---

## 🎯 Objetivo

Acompanhar a transformação progressiva do código, desde implementação estruturada até sistema orientado a objetos completo com interfaces, classes abstratas, manipulação de arquivos (CSV/JSON/XML) e tratamento de exceções.

---

## 📚 Estrutura do Módulo 1

**Bloco 1 - Fundamentos (Aulas 1-4)** ✅
- O Que é Java?, JVM, JSR e JEP
- Variáveis, Operadores e Condicionais
- Arrays e Laços de Repetição

**Bloco 2 - Orientação a Objetos Básica (Aulas 5-7)** ✅
- Classes, Atributos e Objetos
- Métodos e Construtores
- Arrays de Objetos, Composição e Enums

**Bloco 3 - Ferramentas e Organização (Aulas 8-10)** ✅
- IntelliJ IDE e Debug
- Organizando em Arquivos e Herança
- Pacotes, Modificadores de Acesso, Getters e Setters

**Bloco 4 - POO Avançada (Aulas 11-13)** ✅
- Protected
- String
- Imutabilidade, StringBuilder e Final

**Bloco 5 - Arquivos e Dados (Aulas 14-15)** ✅
- Praticando com Arquivo CSV
- Praticando com Arquivo JSON

**Bloco 6 - Design Avançado (Aulas 16-19)** ✅
- Refatoração e Interfaces
- Classes Abstratas e Static
- Object, Classes Wrapper e Javadoc
- JARs e Exceptions

---

## 📖 Histórico de Aulas (Resumido)

### Aula 10 - Pacotes, Modificadores, Getters/Setters ✅

**Novidades:**
- Classe `Restaurante` com composição
- Relação Restaurante HAS-A Cardapio
- Encapsulamento completo

**Conceitos:** Composição, Encapsulamento, Modificadores

---

### Aula 11 - Protected ✅

**Novidades:**
- Construtor `ItemCardapio` agora `protected`
- Geração automática de getters/setters (IntelliJ)

**Conceitos:** Modificador protected, Visibilidade entre pacotes

---

### Aula 12 - String ✅

**Novidades:**
- Classe `TesteString` com demonstrações
- Exercícios: Processador de Nomes, Validador de URL

**Conceitos:** Manipulação de Strings, Imutabilidade, equals() vs ==

---

### Aula 13 - Imutabilidade, StringBuilder e Final ✅

**Novidades:**
- Teste de performance String vs StringBuilder
- Classe `Coordenada` imutável (final class + final attributes)

**Conceitos:** StringBuilder, Final, Classes Imutáveis

---

### Aula 14 - Praticando com Arquivo CSV ✅

**Novidades:**
- Arquivo `itens-cardapio.csv` (7 itens)
- Parsing manual com split(";", -1)
- Validações de estrutura (9 colunas)

**Código:**
```java
public Cardapio(String nomeArquivo) throws IOException {
    String[] partes = linha.split(";", -1);
    if (partes.length < 9) throw new IOException("CSV inválido");
    // ... parsing e validações
}
```

**Conceitos:** Path, Files, Parsing CSV, IOException

---

### Aula 15 - Praticando com Arquivo JSON ✅

**Novidades:**
- Arquivo `itens-cardapio.json`
- Parsing manual com regex e replace
- Suporte multi-formato (CSV + JSON)

**Código:**
```java
linha = linha.replace("[", "").replace("]", "");
String[] campos = linha.split(",\\s*\"");
```

**Conceitos:** JSON parsing manual, Regex, Split com limite

---

### Aula 16 - Refatoração e Interfaces ✅

**GRANDE REFATORAÇÃO!** 🌟

**Antes (120 linhas):**
```java
public Cardapio(String nomeArquivo) throws IOException {
    // 50+ linhas parsing CSV inline
    if (nomeArquivo.endsWith(".csv")) { ... }
    // 60+ linhas parsing JSON inline
    else if (nomeArquivo.endsWith(".json")) { ... }
}
```

**Depois (10 linhas):**
```java
public Cardapio(String nomeArquivo) throws Exception {
    LeitorItensCardapio leitor = LeitorItensCardapio.criaLeitor(nomeArquivo);
    if (leitor != null) {
        itens = leitor.processaArquivo(nomeArquivo);
    }
}
```

**Novidades:**
- **Pacote `leitor/`** criado
- **Interface `LeitorItensCardapio`**
- **Classe `LeitorItensCardapioCSV`**
- **Classe `LeitorItensCardapioJSON`**
- **Factory Pattern** (static factory method)

**Benefícios:**
- ✅ 92% redução código (120 → 10 linhas)
- ✅ Single Responsibility Principle
- ✅ Open/Closed Principle
- ✅ Fácil adicionar XML

**Conceitos:** Interfaces, Refatoração, Factory Pattern, SOLID

---

### Aula 17 - Classes Abstratas e Static ✅

**Novidades:**
- **Classe `LeitorItensCardapioBase` (abstrata)**
- Template Method Pattern
- CSV herda de Base (reaproveita código comum)
- JSON/XML implementam direto (parsing completo)

**Código:**
```java
public abstract class LeitorItensCardapioBase implements LeitorItensCardapio {
    @Override
    public ItemCardapio[] processaArquivo(String arquivo) {
        // Código comum: lê arquivo, split linhas
        for (String linha : linhas) {
            ItemCardapio item = processaLinha(linha); // HOOK
        }
    }
    
    protected abstract ItemCardapio processaLinha(String linha);
}
```

**Hierarquia:**
```
LeitorItensCardapio (interface)
├── LeitorItensCardapioBase (abstract)
│   └── LeitorItensCardapioCSV
├── LeitorItensCardapioGSON
└── LeitorItensCardapioXML
```

**Conceitos:** Classes Abstratas, Template Method, Static methods

---

### Aula 18 - Object, Classes Wrapper e Javadoc ✅

**Novidades:**
- **Record `ItemCardapioJsonDTO`**
- **Biblioteca GSON** (gson-2.13.2.jar)
- Wrapper `Double` para permitir null

**Código:**
```java
public record ItemCardapioJsonDTO(
    long id,
    String nome,
    Double precoComDesconto  // Wrapper: pode ser null
) {}

// GSON desserialização
ItemCardapioJsonDTO[] dtos = new Gson()
    .fromJson(json, ItemCardapioJsonDTO[].class);
```

**Por que Record?**
- ✅ Imutável automático
- ✅ Constructor, getters, equals, hashCode, toString
- ✅ 1 linha vs 50 linhas

**Por que Wrapper Double?**
- `double` primitivo: não pode ser null
- `Double` wrapper: pode ser null (JSON: `"precoComDesconto": null`)

**Conceitos:** Records, Wrappers, GSON, DTOs

---

### Aula 19 - JARs e Exceptions ✅

**Novidades:**
- **Exceção `FlorindaException extends RuntimeException`**
- Validações no construtor `ItemCardapio`
- RuntimeException (unchecked)

**Código:**
```java
public class FlorindaException extends RuntimeException {
    public FlorindaException(String message) {
        super(message);
    }
}

// No ItemCardapio
public ItemCardapio(...) throws FlorindaException {
    if (preco < 0) {
        throw new FlorindaException("Preço não pode ser negativo: " + preco);
    }
    if (descricao == null || descricao.isBlank()) {
        throw new FlorindaException("Descrição vazia: " + descricao);
    }
}
```

**Por que RuntimeException?**
- ✅ Unchecked (não obriga try-catch)
- ✅ Erros de programação/validação
- ✅ Não esperamos recuperação

**Conceitos:** Exceções customizadas, RuntimeException, Validações

---

## 🔄 Evolução Código - Marcos Principais

### v0.10 - Composição (Aula 10)
```java
Restaurante ◆─── Cardapio ◇─── ItemCardapio[]
```

### v0.14 - CSV (Aula 14)
```java
// De hard-coded para arquivo CSV
Cardapio cardapio = new Cardapio("itens-cardapio.csv");
```

### v0.15 - Multi-formato (Aula 15)
```java
// CSV + JSON no mesmo construtor
if (csv) { ... } else if (json) { ... }
```

### v0.16 - Refatoração (Aula 16) 🌟
```java
// Interface + Factory + Leitores especializados
LeitorItensCardapio leitor = criaLeitor(arquivo);
```

### v0.17 - Classes Abstratas (Aula 17)
```java
// Template Method Pattern
abstract class Base { ... }
```

### v0.18 - GSON + Records (Aula 18)
```java
// Biblioteca externa + DTOs imutáveis
new Gson().fromJson(json, ItemCardapioJsonDTO[].class);
```

### v0.19 - Exceções (Aula 19) ✅
```java
// Validações com exceções customizadas
throw new FlorindaException("Erro validação");
```

---

## 📊 Métricas Finais

| Métrica | Início (Aula 10) | Final (Aula 19) | Evolução |
|---------|------------------|-----------------|----------|
| Classes | 8 | 15 | +88% |
| Conceitos POO | 5 | 20+ | +300% |
| Linhas Código | ~400 | ~800 | +100% |
| Formatos Dados | 0 | 3 | ∞ |
| Padrões Design | 0 | 4 | ∞ |
| Pacotes | 2 | 3 | +50% |
| Bibliotecas | 0 | 1 (GSON) | ∞ |

---

## 💡 Lições Aprendidas

### Aula 14
- Separação dados/lógica
- Validações previnem bugs
- Files.readString() simplifica I/O

### Aula 15
- Regex para parsing complexo
- Multi-formato é possível
- Preparação para refatoração

### Aula 16 ⭐
- Interfaces definem contratos
- Factory simplifica criação
- Refatoração melhora design
- 92% redução = mais qualidade

### Aula 17
- Abstrata compartilha código
- Template Method reutiliza
- Herança + Interface = flexível

### Aula 18
- Records economizam código
- GSON > parsing manual
- Wrappers permitem null
- DTOs separam concerns

### Aula 19
- Exceções customizadas são úteis
- RuntimeException para validação
- Mensagens descritivas ajudam

---

## 🎯 Próximos Passos (Pós-Módulo 1)

### Técnico
- [ ] Banco de dados (JDBC/JPA)
- [ ] API REST (Spring Boot)
- [ ] Testes (JUnit + Mockito)
- [ ] CI/CD
- [ ] Docker

### Funcionalidades
- [ ] CRUD completo
- [ ] Sistema de pedidos
- [ ] Controle de estoque
- [ ] Autenticação
- [ ] Dashboard

---

## 📌 Estrutura Final

```
src/mx/florinda/
├── cli/
│   └── Main.java
├── leitor/                    (Aula 16-18)
│   ├── ItemCardapioJsonDTO.java
│   ├── LeitorItensCardapio.java
│   ├── LeitorItensCardapioBase.java
│   ├── LeitorItensCardapioCSV.java
│   ├── LeitorItensCardapioGSON.java
│   └── LeitorItensCardapioXML.java
└── modelo/
    ├── isento/
    │   └── ItemCardapioIsento.java
    ├── Cardapio.java
    ├── CategoriaCardapio.java
    ├── FlorindaException.java  (Aula 19)
    ├── ItemCardapio.java
    ├── ItemCardapioBebida.java
    ├── ItemCardapioSemGluten.java
    └── Restaurante.java
```

---

_Documento atualizado em: Fevereiro 2026_  
_Projeto: 100% Concluído ✅_  
_Última aula: Aula 19 - JARs e Exceptions_