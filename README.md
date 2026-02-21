# 🍽️ Sistema de Restaurante - POO em Java

[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Concluído-brightgreen.svg)]()
[![Módulo](https://img.shields.io/badge/Módulo%201-100%25-success.svg)]()

Sistema de gerenciamento para o **Restaurante da Dona Florinda**, desenvolvido como projeto prático do **Módulo 1 - Introdução ao Java** do curso **Java Elite** da **UNIPDS**.

**✅ PROJETO CONCLUÍDO** - 19 aulas implementadas com sucesso!

---

## 📋 Sobre o Projeto

Sistema de cardápio digital completo inspirado no universo do **Chaves**, evoluindo de código procedural até uma **arquitetura orientada a objetos robusta** com:

### 🎯 Características Principais

- ✅ **Múltiplos Formatos de Dados:** CSV, JSON, XML
- ✅ **Arquitetura Extensível:** Interfaces + Classes Abstratas + Factory
- ✅ **Padrões de Design:** Factory Method, Template Method, Strategy
- ✅ **Tratamento de Exceções:** Custom exceptions + validações
- ✅ **Código Limpo:** SOLID principles aplicados
- ✅ **Polimorfismo Avançado:** Herança, Interfaces, Classes Abstratas
- ✅ **Biblioteca Externa:** Google GSON para JSON
- ✅ **Records:** DTOs imutáveis (Java 14+)

---

## 🏗️ Estrutura do Projeto

```
sistema-restaurante-poo-java/
├── .idea/                                  # Configurações IntelliJ IDEA
├── docs/                                   # 📚 Documentação
│   ├── conceitos-aprendidos.md
│   └── evolucao-do-projeto.md
├── out/                                    # Compilados (.class)
├── src/                                    # 💻 Código-fonte
│   └── mx/florinda/
│       ├── cli/
│       │   └── Main.java                   # 🎯 Ponto de entrada
│       ├── leitor/                         # 📄 Leitores de arquivo
│       │   ├── ItemCardapioJsonDTO.java    # Record DTO
│       │   ├── LeitorItensCardapio.java    # Interface + Factory
│       │   ├── LeitorItensCardapioBase.java # Classe Abstrata
│       │   ├── LeitorItensCardapioCSV.java # Implementação CSV
│       │   ├── LeitorItensCardapioGSON.java # Implementação JSON
│       │   └── LeitorItensCardapioXML.java # Implementação XML
│       └── modelo/                         # 🏛️ Modelo de domínio
│           ├── isento/
│           │   └── ItemCardapioIsento.java # Item isento de imposto
│           ├── Cardapio.java               # Agregador de itens
│           ├── CategoriaCardapio.java      # Enum de categorias
│           ├── FlorindaException.java      # Exception customizada
│           ├── ItemCardapio.java           # Classe base
│           ├── ItemCardapioBebida.java     # Bebida (50% imposto)
│           ├── ItemCardapioSemGluten.java  # Sem glúten (5% imposto)
│           └── Restaurante.java            # Entidade restaurante
├── .gitignore
├── gson-2.13.2.jar                         # 📦 Biblioteca GSON
├── com.google.gson/                        # GSON expandido
├── META-INF/
├── itens-cardapio.csv                      # 📊 Dados CSV
├── itens-cardapio.json                     # 📊 Dados JSON
├── itens-cardapio.xml                      # 📊 Dados XML
├── LICENSE
├── README.md
└── sistema-restaurante-poo-java.iml        # Módulo IntelliJ
```

---

## 🏆 Conquistas Técnicas

### Conceitos de POO Aplicados (20+)
- Classes e Objetos
- Encapsulamento (Getters/Setters)
- Herança (múltiplos níveis)
- Polimorfismo (Override + Interface + Abstrata)
- Interfaces
- Classes Abstratas
- Modificador Final
- Classes Imutáveis (Records)
- Enums
- Exceções Customizadas
- Static Factory Methods
- Wrappers (Double vs double)

### Padrões de Design
- **Factory Method:** Criação polimórfica de leitores
- **Template Method:** Reutilização em classe abstrata
- **Strategy:** Algoritmos intercambiáveis de parsing
- **DTO:** Separação dados/domínio com Records

### Manipulação de Dados
- Parsing CSV manual
- JSON com GSON (biblioteca externa)
- XML com parsing customizado
- Validações robustas
- Conversão de tipos

---

## 🚀 Funcionalidades

### Sistema de Cardápio
- 📝 Carregamento dinâmico de múltiplos formatos
- 🏷️ Categorização (Entradas, Pratos Principais, Sobremesas, Bebidas)
- 💰 Sistema de promoções com cálculo automático
- 🧾 Cálculo de impostos diferenciado por tipo
- 🌾 Suporte a itens sem glúten
- 🆓 Suporte a itens isentos de impostos
- 🔍 Busca de itens por ID
- 📊 Relatórios e estatísticas

### Validações Implementadas
- ✅ Preço não pode ser negativo (FlorindaException)
- ✅ Descrição não pode ser vazia (FlorindaException)
- ✅ Promoção requer preço com desconto
- ✅ Estrutura de arquivo validada
- ✅ Extensão de arquivo verificada

---

## 💻 Como Executar

### Pré-requisitos
- Java 21 ou superior
- IntelliJ IDEA (recomendado)
- GSON library (já incluída: `gson-2.13.2.jar`)

### Passos

1. **Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/sistema-restaurante-poo-java.git
cd sistema-restaurante-poo-java
```

2. **Abra no IntelliJ IDEA**
    - File → Open → Selecione a pasta do projeto
    - A IDE reconhecerá automaticamente o `gson-2.13.2.jar`

3. **Execute o Main.java:**
    - Navegue até `src/mx/florinda/cli/Main.java`
    - Clique com botão direito → Run 'Main.main()'

4. **Escolha o arquivo de dados:**
```
Digite o nome do arquivo: itens-cardapio.csv
```
ou
```
Digite o nome do arquivo: itens-cardapio.json
```
ou
```
Digite o nome do arquivo: itens-cardapio.xml
```

### Saída Esperada

```
Restaurante: Florinda
Endereço: Av. 123 - Araras/SP
----------------------------------------------
Digite um id de um item de cardápio: 2

== Item do Cardápio ==
Id: 2
Nome: Sanduíche de Presunto do Chaves
Item em promoção! 🤑
Preco: de 3.50 por 2.99
Porcentagem de desconto: 14.57
Este item não contém glúten.
Categoria: PRATOS_PRINCIPAIS
Imposto: 0.1495
----------------------------------------------
Soma dos preços: 58.86
Total de itens em promoção: 5
O primeiro preço que é maior que 10.0: 12.99
```

---

## 📄 Formatos de Dados Suportados

### CSV (`itens-cardapio.csv`)
```csv
id;nome;descricao;preco;categoria;emPromocao;precoComDesconto;impostoIsento;semGlutem
1;Refresco do Chaves;Suco de limão...;2.99;BEBIDAS;false;;false;false
2;Sanduíche de Presunto;...;3.50;PRATOS_PRINCIPAIS;true;2.99;false;true
```

### JSON (`itens-cardapio.json`)
```json
[
  {
    "id": 1,
    "nome": "Refresco do Chaves",
    "descricao": "Suco de limão...",
    "preco": 2.99,
    "categoria": "BEBIDAS",
    "emPromocao": false,
    "precoComDesconto": null,
    "impostoIsento": false,
    "semGluten": false
  }
]
```

### XML (`itens-cardapio.xml`)
```xml
<menu>
    <item>
        <id>1</id>
        <nome>Refresco do Chaves</nome>
        <descricao>Suco de limão...</descricao>
        <preco>2.99</preco>
        <categoria>BEBIDAS</categoria>
        <emPromocao>false</emPromocao>
        <precoComDesconto></precoComDesconto>
        <impostoIsento>false</impostoIsento>
        <semGlutem>false</semGlutem>
    </item>
</menu>
```

---

## 🎯 Padrões de Design

### 1. Factory Method Pattern
```java
// Interface com static factory method
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo);
    
    static LeitorItensCardapio criaLeitor(String arquivo) {
        if (arquivo.endsWith(".csv")) return new LeitorItensCardapioCSV(arquivo);
        if (arquivo.endsWith(".json")) return new LeitorItensCardapioGSON(arquivo);
        if (arquivo.endsWith(".xml")) return new LeitorItensCardapioXML();
        throw new IllegalArgumentException("Extensão inválida");
    }
}
```

### 2. Template Method Pattern
```java
// Classe abstrata define o template
public abstract class LeitorItensCardapioBase {
    public ItemCardapio[] processaArquivo(String arquivo) {
        // 1. Lê arquivo (código comum)
        // 2. Split em linhas (código comum)
        // 3. Processa linha (HOOK - cada subclasse implementa)
        processaLinha(linha);
    }
    
    protected abstract ItemCardapio processaLinha(String linha);
}
```

### 3. Strategy Pattern
```java
// Cliente usa estratégia sem saber qual é
LeitorItensCardapio leitor = LeitorItensCardapio.criaLeitor(arquivo);
ItemCardapio[] itens = leitor.processaArquivo(arquivo);
```

### 4. Data Transfer Object (DTO)
```java
// Record imutável para transferência de dados JSON
public record ItemCardapioJsonDTO(
    long id,
    String nome,
    String descricao,
    double preco,
    String categoria,
    boolean emPromocao,
    Double precoComDesconto,  // Wrapper permite null
    boolean impostoIsento,
    boolean semGluten
) {}
```

---

## 📊 Hierarquia de Classes

### Modelo de Domínio
```
ItemCardapio (classe base)
├── ItemCardapioBebida (50% imposto)
├── ItemCardapioSemGluten (5% imposto)  
└── ItemCardapioIsento (0% imposto)

Restaurante ◆─── Cardapio ◇─── ItemCardapio[]
(composição)     (agregação)
```

### Sistema de Leitura
```
LeitorItensCardapio (interface + static factory)
├── LeitorItensCardapioBase (abstract - Template Method)
│   └── LeitorItensCardapioCSV (extends Base)
├── LeitorItensCardapioGSON (implements Interface)
└── LeitorItensCardapioXML (implements Interface)
```

---

## 🎓 Evolução do Projeto

### Aula 10-13: Fundamentos POO
- Composição, Encapsulamento, Herança
- Strings, StringBuilder, Final, Imutabilidade

### Aula 14: CSV Manual
```java
String[] partes = linha.split(";", -1);
long id = Long.parseLong(partes[0]);
```

### Aula 15: JSON Manual
```java
linha = linha.replace("[", "").replace("]", "");
String[] campos = linha.split(",\\s*\"");
```

### Aula 16: Refatoração + Interfaces
```java
// De 120 linhas → 10 linhas (92% redução!)
LeitorItensCardapio leitor = criaLeitor(arquivo);
itens = leitor.processaArquivo(arquivo);
```

### Aula 17: Classes Abstratas
```java
public abstract class LeitorItensCardapioBase {
    // Template Method Pattern
}
```

### Aula 18: GSON + Records + Wrappers
```java
// Biblioteca externa + Records
ItemCardapioJsonDTO[] dtos = new Gson().fromJson(json, ItemCardapioJsonDTO[].class);
```

### Aula 19: Exceções Customizadas
```java
public class FlorindaException extends RuntimeException {
    // Validações de negócio
}

if (preco < 0) throw new FlorindaException("Preço negativo");
```

---

## 📊 Estatísticas Finais

| Métrica | Valor |
|---------|-------|
| **Aulas Concluídas** | 19/19 (100%) ✅ |
| **Classes Java** | 15 |
| **Interfaces** | 1 |
| **Classes Abstratas** | 1 |
| **Records** | 1 |
| **Enums** | 1 |
| **Exceções Custom** | 1 |
| **Pacotes** | 3 (cli, modelo, leitor) |
| **Linhas de Código** | ~800+ |
| **Conceitos POO** | 20+ |
| **Padrões de Design** | 4 |
| **Formatos de Dados** | 3 (CSV, JSON, XML) |
| **Redução por Refatoração** | 92% (120→10 linhas) |
| **Bibliotecas Externas** | 1 (GSON 2.13.2) |

---

## 🛠️ Tecnologias

- **Linguagem:** Java 21+
- **IDE:** IntelliJ IDEA
- **Paradigma:** POO (Programação Orientada a Objetos)
- **I/O:** java.nio.file (Path, Files)
- **Parsing:** Manual (CSV, XML) + GSON (JSON)
- **Biblioteca:** Google GSON 2.13.2
- **Build:** IntelliJ (.iml)
- **VCS:** Git + GitHub

---

## 🎓 Sobre o Curso

**Curso:** Java Elite  
**Instituição:** UNIPDS (Pós-Graduação)  
**Módulo:** 01 - Introdução ao Java  
**Status:** ✅ CONCLUÍDO  
**Período:** Fevereiro 2026

### 📚 Módulo 1 - 19 Aulas

1. ✅ O Que é Java?
2. ✅ JVM, JSR e JEP
3. ✅ Variáveis, Operadores e Condicionais
4. ✅ Arrays e Laços de Repetição
5. ✅ Classes, Atributos e Objetos
6. ✅ Métodos e Construtores
7. ✅ Arrays de Objetos, Composição e Enums
8. ✅ IntelliJ IDE e Debug
9. ✅ Organizando em Arquivos e Herança
10. ✅ Pacotes, Modificadores de Acesso, Getters e Setters
11. ✅ Protected
12. ✅ String
13. ✅ Imutabilidade, StringBuilder e Final
14. ✅ Praticando com Arquivo CSV
15. ✅ Praticando com Arquivo JSON
16. ✅ Refatoração e Interfaces
17. ✅ Classes Abstratas e Static
18. ✅ Object, Classes Wrapper e Javadoc
19. ✅ JARs e Exceptions

---

## 🏆 Conquistas

### Arquiteturais
- ✅ Separação responsabilidades (3 pacotes: cli, modelo, leitor)
- ✅ Baixo acoplamento (interfaces + abstratas)
- ✅ Alta coesão (classes focadas)
- ✅ Extensível (adicionar YAML = criar 1 classe)
- ✅ SOLID principles

### Técnicas
- ✅ 3 parsers diferentes (CSV manual, JSON GSON, XML manual)
- ✅ Biblioteca externa (GSON)
- ✅ Polimorfismo multi-nível
- ✅ Exceções customizadas
- ✅ Validações de negócio

### Qualidade
- ✅ Mensagens descritivas
- ✅ Código DRY
- ✅ Nomes claros
- ✅ Imutabilidade (Records)
- ✅ Template methods

---

## 💡 Principais Lições

### 1. Interface vs Abstrata vs Herança
- **Interface:** Contratos (o quê fazer)
- **Abstrata:** Template (como fazer parcialmente)
- **Herança:** Relação "é-um"

### 2. Quando usar cada Parser
- **CSV:** Dados tabulares simples
- **JSON:** Estruturas complexas, APIs
- **XML:** Hierarquias, configurações

### 3. SOLID na Prática
- **S**ingle: Cada classe 1 motivo mudar
- **O**pen/Closed: XML sem mudar código
- **L**iskov: Subclasses substituem
- **I**nterface: Interface enxuta
- **D**ependency: Usar interface, não classe concreta

### 4. Padrões Emergem
- Factory: necessidade de decidir criação
- Template: código comum + variações
- Strategy: trocar algoritmo runtime
- DTO: separar formato de domínio

---

## 🚀 Evoluções Futuras

### Técnicas
- [ ] Banco de dados (JDBC/JPA)
- [ ] API REST (Spring Boot)
- [ ] Testes (JUnit + Mockito)
- [ ] GUI (JavaFX)
- [ ] Maven/Gradle

### Funcionalidades
- [ ] CRUD completo
- [ ] Sistema de pedidos
- [ ] Estoque
- [ ] Relatórios
- [ ] Auth

---

## 📚 Documentação

- [🎓 Conceitos POO](docs/conceitos-aprendidos.md) - 20+ conceitos explicados
- [📈 Evolução](docs/evolucao-do-projeto.md) - Histórico aula por aula

---

## 📝 Licença

MIT License - Ver [LICENSE](LICENSE)

---

## 👨‍💻 Autor

Projeto educacional - **Java Elite (UNIPDS)**

---

## 📬 Contato

Issues: [GitHub Issues](../../issues)

---

<div align="center">

# 🎉 MÓDULO 1 CONCLUÍDO! 🎉

**19 Aulas • 800+ Linhas • 20+ Conceitos • 4 Padrões**

---

### 📊 Jornada Completa

```
Aula 10  ████░░░░░░░░░░░░░░░░  Composição
Aula 11  █████░░░░░░░░░░░░░░░  Protected
Aula 12  ██████░░░░░░░░░░░░░░  Strings
Aula 13  ███████░░░░░░░░░░░░░  StringBuilder + Final
Aula 14  ████████░░░░░░░░░░░░  CSV
Aula 15  █████████░░░░░░░░░░░  JSON
Aula 16  ██████████░░░░░░░░░░  Interfaces + Refatoração
Aula 17  ███████████░░░░░░░░░  Classes Abstratas
Aula 18  ████████████░░░░░░░░  Records + GSON
Aula 19  █████████████████████  Exceções ✅
```

### 🎯 Transformação

**Início (Aula 10):**
```java
itens[0] = new ItemCardapio(1, "Refresco", ...);
// hard-coded, sem validações
```

**Final (Aula 19):**
```java
LeitorItensCardapio leitor = LeitorItensCardapio.criaLeitor(arquivo);
itens = leitor.processaArquivo(arquivo);
// CSV, JSON, XML → validado, extensível ✨
```

---

**⭐ Star se te inspirou! ⭐**

Feito com ☕ e muito aprendizado!

</div>