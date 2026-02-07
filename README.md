# 🍽️ Sistema de Restaurante - POO em Java

[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow.svg)]()

Sistema de gerenciamento para o **Restaurante da Dona Florinda**, desenvolvido como projeto prático do **Módulo 1 - Introdução ao Java** do curso **Java Elite** da **UNIPDS**.

O projeto evolui ao longo das 19 aulas, aplicando progressivamente conceitos de **Programação Orientada a Objetos (POO)**, desde código estruturado até implementações avançadas com herança, polimorfismo, **interfaces**, **refatoração**, classes abstratas e tratamento de exceções.

---

## 📋 Sobre o Projeto

Este é um sistema de cardápio digital inspirado no universo do **Chaves**, desenvolvido para consolidar conceitos fundamentais de Java e POO:

- ✅ Classes e Objetos
- ✅ Encapsulamento (Getters e Setters)
- ✅ Herança e Polimorfismo
- ✅ Modificadores de Acesso (private, protected, public)
- ✅ Enums
- ✅ Arrays e Coleções
- ✅ Composição de Objetos
- ✅ Manipulação de Strings
- ✅ StringBuilder e Performance
- ✅ Modificador Final
- ✅ Classes Imutáveis
- ✅ Leitura de Arquivos CSV e JSON
- ✅ Tratamento de Exceções
- ✅ **Interfaces** ← Novidade da Aula 16! ⭐
- ✅ **Refatoração de Código** ← Novidade da Aula 16! ⭐
- ✅ **Factory Pattern** ← Novidade da Aula 16! ⭐

---

## 🚀 Funcionalidades

- 📝 Cadastro de itens do cardápio
- 🏷️ Categorização (Entradas, Pratos Principais, Sobremesas, Bebidas)
- 💰 Sistema de promoções com cálculo automático de desconto
- 🧾 Cálculo de impostos diferenciado por tipo de item
- 🌾 Identificação de itens sem glúten
- 🔍 Busca de itens por ID
- 📊 Relatórios (soma de preços, itens em promoção, etc.)
- 📄 **Carregamento dinâmico via CSV ou JSON** ⭐
- 🏭 **Arquitetura extensível com Factory Pattern** ⭐

---

## 🏗️ Estrutura do Projeto

```
sistema-restaurante-poo-java/
├── .idea/                          # Configurações do IntelliJ IDEA
├── docs/                           # Documentação do projeto
│   ├── conceitos-aprendidos.md
│   └── evolucao-do-projeto.md
├── out/                            # Saída de compilação (binários gerados)
├── src/                            # Código-fonte principal
│   └── mx/florinda/
│       ├── cli/
│       │   └── Main.java           # Ponto de entrada da aplicação
│       ├── leitor/                 # Leitores de arquivos (CSV/JSON) ⭐ NOVO!
│       │   ├── FabricaLeitorItensCardapio.java
│       │   ├── LeitorItensCardapio.java (interface)
│       │   ├── LeitorItensCardapioCSV.java
│       │   └── LeitorItensCardapioJSON.java
│       │   └── LeitorItensCardapioXML.java
│       └── modelo/                 # Modelos e entidades do sistema
│           ├── isento/             # Subpacote para itens isentos
│           │   └── ItemCardapioIsento.java
│           ├── Cardapio.java       # Refatorado! ⭐
│           ├── CategoriaCardapio.java
│           ├── ItemCardapio.java
│           ├── ItemCardapioBebida.java
│           ├── ItemCardapioSemGluten.java
│           └── Restaurante.java
├── .gitignore                      # Arquivo de configuração do Git
├── GUIA-GIT.md                     # Guia de uso do Git
├── itens-cardapio.csv              # Dados do cardápio em formato CSV
├── itens-cardapio.json             # Dados do cardápio em formato JSON
├── LICENSE                         # Licença do projeto
├── README.md                       # Descrição geral do projeto
└── sistema-restaurante-poo-java.iml # Arquivo de configuração do IntelliJ
```

---

## 💻 Como Executar

### Pré-requisitos

- Java 21 ou superior
- IntelliJ IDEA (recomendado) ou qualquer IDE Java

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/sistema-restaurante-poo-java.git
cd sistema-restaurante-poo-java
```

2. Abra o projeto na sua IDE

3. Execute a classe `Main.java` localizada em `src/mx/florinda/cli/`

4. **Digite o nome do arquivo quando solicitado:**

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

5. Siga as instruções no console para interagir com o sistema

---

## 📄 Arquivos de Dados

### Formato CSV (itens-cardapio.csv)

O cardápio pode ser carregado de um arquivo CSV com 9 colunas separadas por ponto-e-vírgula (`;`):

```csv
id;nome;descricao;preco;categoria;emPromocao;precoComDesconto;impostoIsento;ehSemGluten
1;Refresco do Chaves;Suco de limão...;2.99;BEBIDAS;false;;false;false
2;Sanduíche de Presunto;Sanduíche simples...;3.50;PRATOS_PRINCIPAIS;true;2.99;false;true
```

### Formato JSON (itens-cardapio.json)

Ou de um arquivo JSON com objetos estruturados:

```json
[
  {
    "id": 1,
    "nome": "Refresco do Chaves",
    "descricao": "Suco de limão que parece de tamarindo e tem gosto de groselha.",
    "preco": 2.99,
    "categoria": "BEBIDAS",
    "emPromocao": false,
    "precoComDesconto": null,
    "impostoIsento": false,
    "semGlutem": false
  }
]
```

### Formato CSV (itens-cardapio.csv)

O cardápio pode ser carregado de um arquivo CSV com 9 colunas separadas por ponto-e-vírgula (`;`):

```xml
    <item>
    <id>1</id>
    <nome>Refresco do Chaves</nome>
    <descricao>Suco de limão que parece de tamarindo e tem gosto de groselha.</descricao>
    <preco>2.99</preco>
    <categoria>BEBIDAS</categoria>
    <emPromocao>false</emPromocao>
    <precoComDesconto></precoComDesconto>
    <impostoIsento>false</impostoIsento>
    <semGlutem>false</semGlutem>
</item>
```

**Vantagens:**

- ✅ Adicione itens sem recompilar o código
- ✅ Edite preços instantaneamente
- ✅ Configure promoções facilmente
- ✅ Escolha o formato que preferir (CSV ou JSON)
- ✅ Escala para qualquer quantidade de itens

---

## 📚 Conceitos de POO Aplicados

### 1. **Encapsulamento**

- Atributos privados com getters e setters
- Controle de acesso aos dados

### 2. **Herança**

```
ItemCardapio (classe pai)
    ├── ItemCardapioBebida
    ├── ItemCardapioIsento
    └── ItemCardapioSemGluten
```

### 3. **Polimorfismo**

- Sobrescrita de métodos (`@Override`)
- Comportamentos específicos em subclasses
- Exemplo: `getImposto()` calculado diferentemente em cada tipo
- **Polimorfismo via interface** (Aula 16) ⭐

### 4. **Composição**

- `Restaurante` **tem um** `Cardapio`
- `Cardapio` **tem vários** `ItemCardapio`
- `Cardapio` **usa** `LeitorItensCardapio` (interface)

### 5. **Enums**

- `CategoriaCardapio` para tipagem segura de categorias

### 6. **Interfaces** ⭐ NOVO!

```java
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
}

// Implementações
public class LeitorItensCardapioCSV implements LeitorItensCardapio { ... }
public class LeitorItensCardapioJSON implements LeitorItensCardapio { ... }
```

**Benefícios:**
- ✅ Define contrato claro entre componentes
- ✅ Permite polimorfismo (mesmo tipo, diferentes implementações)
- ✅ Desacopla código (Cardapio não conhece leitores concretos)
- ✅ Facilita testes e extensões futuras

### 7. **Refatoração** ⭐ NOVO!

- Construtor do Cardapio reduzido de **120 para 10 linhas** (92% redução!)
- Separação de responsabilidades em classes especializadas
- Código mais legível, testável e manutenível

### 8. **Factory Pattern** ⭐ NOVO!

```java
public class FabricaLeitorItensCardapio {
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        if (nomeArquivo.endsWith(".csv")) return new LeitorItensCardapioCSV();
        if (nomeArquivo.endsWith(".json")) return new LeitorItensCardapioJSON();
        return null;
    }
}
```

**Benefícios:**
- ✅ Centraliza lógica de criação de objetos
- ✅ Cliente não precisa saber qual classe instanciar
- ✅ Fácil adicionar novos formatos (XML, YAML, etc.)

### 9. **Manipulação de Arquivos**

- Leitura com `java.nio.file.Path` e `Files`
- Parsing de dados estruturados (CSV e JSON)
- Validação de integridade dos dados

### 10. **Tratamento de Exceções**

- `IOException` para erros de leitura
- Validações com mensagens descritivas
- Tratamento robusto de erros

---

## 🎯 Exemplos de Uso

### Inicialização do Sistema (CSV)

```
Digite o nome do arquivo: itens-cardapio.csv
```

### Inicialização do Sistema (JSON)

```
Digite o nome do arquivo: itens-cardapio.json
```

### Consultar item do cardápio

```
Digite um id de um item de cardápio: 1

== Item do Cardápio ==
Id: 1
Nome: Refresco do Chaves
Descrição: Suco de limão que parece de tamarindo e tem gosto de groselha.
Preco: 2.99
Categoria: BEBIDAS
Imposto: 1.495
```

### Item em promoção

```
Digite um id de um item de cardápio: 2

== Item do Cardápio ==
Id: 2
Nome: Sanduíche de Presunto do Chaves
Item em promoção! 🤑
Preco: de 3.50 por 2.99
Porcentagem de desconto: 14.57%
Este item não contém glúten.
```

---

## 🔄 Evolução do Código

### Aula 14 → Aula 15: Suporte Multi-Formato

**ANTES (Aula 14):**
```java
// Suportava apenas CSV
if (nomeArquivo.endsWith(".csv")) {
    // parsing CSV
}
```

**DEPOIS (Aula 15):**
```java
// Suporta CSV E JSON
if (nomeArquivo.endsWith(".csv")) {
    // parsing CSV
} else if (nomeArquivo.endsWith(".json")) {
    // parsing JSON
}
```

### Aula 15 → Aula 16: Refatoração com Interfaces ⭐

**ANTES (Aula 15) - Construtor com ~120 linhas:**
```java
public Cardapio(String nomeArquivo) throws IOException {
    // Leitura do arquivo
    Path arquivo = Path.of(nomeArquivo);
    String conteudo = Files.readString(arquivo);
    
    // 50+ linhas de parsing CSV
    if (nomeArquivo.endsWith(".csv")) {
        // lógica CSV inline
    }
    
    // 60+ linhas de parsing JSON
    else if (nomeArquivo.endsWith(".json")) {
        // lógica JSON inline
    }
}
```

**Problemas:**
- ❌ Construtor gigante (120 linhas)
- ❌ Múltiplas responsabilidades
- ❌ Difícil de testar
- ❌ Difícil de estender

**DEPOIS (Aula 16) - Construtor com ~10 linhas:**
```java
public Cardapio(String nomeArquivo) throws Exception {
    FabricaLeitorItensCardapio fabricaLeitor = new FabricaLeitorItensCardapio();
    LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(nomeArquivo);
    
    if (leitor != null) {
        itens = leitor.processaArquivo(nomeArquivo);
    } else {
        IO.println("O nome/extensão do arquivo é inválido(a) - " + nomeArquivo);
        itens = new ItemCardapio[0];
    }
}
```

**Melhorias:**
- ✅ **92% redução** no construtor (120 → 10 linhas)
- ✅ **Responsabilidade única**: criar cardápio
- ✅ **Lógica separada**: cada formato em sua classe
- ✅ **Fácil estender**: adicionar XML = criar `LeitorItensCardapioXML`
- ✅ **Testável**: cada componente independente
- ✅ **Baixo acoplamento**: usa interface, não implementação

---

## 🏗️ Arquitetura (Aula 16)

```
Main
  │
  └─> Restaurante
        │
        └─> Cardapio
              │
              └─> FabricaLeitorItensCardapio
                    │
                    ├─> LeitorItensCardapioCSV (implements LeitorItensCardapio)
                    │
                    └─> LeitorItensCardapioJSON (implements LeitorItensCardapio)
```

**Princípios SOLID aplicados:**
- ✅ **Single Responsibility**: Cada classe uma responsabilidade
- ✅ **Open/Closed**: Aberto para extensão, fechado para modificação
- ✅ **Dependency Inversion**: Depende de interface, não implementação

---

## 📖 Documentação Adicional

- [📈 Evolução do Projeto](docs/evolucao-do-projeto.md) - Histórico detalhado das aulas
- [🎓 Conceitos Aprendidos](docs/conceitos-aprendidos.md) - Explicações teóricas aplicadas

---

## 🎓 Sobre o Curso

**Curso:** Java Elite  
**Instituição:** UNIPDS (Pós-Graduação)  
**Módulo:** 01 - Introdução ao Java  
**Total de Aulas:** 19 videoaulas  
**Aula Atual:** 16 - Refatoração e Interfaces ✅

### 📚 Progresso do Módulo 1

**Bloco 1-3: Fundamentos (Aulas 1-10)** ✅
- Variáveis, Operadores, Arrays
- Classes, Objetos, Métodos
- Herança, Pacotes, Modificadores

**Bloco 4: POO Avançada (Aulas 11-13)** ✅
- ✅ Protected
- ✅ String
- ✅ Imutabilidade, StringBuilder e Final

**Bloco 5: Arquivos e Dados (Aulas 14-15)** ✅
- ✅ Praticando com Arquivo CSV
- ✅ Praticando com Arquivo JSON

**Bloco 6: Design Avançado (Aulas 16-19)** ← **Você está aqui!**
- ✅ **Refatoração e Interfaces** ⭐
- ⏳ Classes Abstratas e Static
- ⏳ Object, Classes Wrapper e Javadoc
- ⏳ JARs e Exceptions

> **Nota:** Este repositório documenta meu aprendizado a partir da **Aula 10**, onde começou o versionamento do código. O projeto continua evoluindo nas próximas 3 aulas do módulo.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21+
- **IDE:** IntelliJ IDEA
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Design Patterns:** Factory Pattern
- **I/O:** java.nio.file (Path, Files)
- **Formatos de Dados:** CSV, JSON
- **Controle de Versão:** Git & GitHub

---

## 🎯 Destaques da Aula 16

### Antes da Refatoração
- 1 classe gigante (Cardapio) com 120 linhas no construtor
- Múltiplas responsabilidades misturadas
- Difícil de testar e estender

### Depois da Refatoração
- 5 classes organizadas em pacotes
- 1 interface definindo contrato
- 1 factory centralizando criação
- Construtor reduzido para 10 linhas
- Código testável e extensível

### Benefícios Alcançados
✅ **Separação de responsabilidades**  
✅ **Código mais limpo e legível**  
✅ **Fácil adicionar novos formatos**  
✅ **Testabilidade individual**  
✅ **Baixo acoplamento**  
✅ **Alta coesão**

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👨‍💻 Autor

Desenvolvido como projeto de aprendizado no curso **Java Elite da UNIPDS**.

---

## 🤝 Contribuições

Como este é um projeto educacional pessoal, não estou aceitando contribuições externas no momento. Porém, feedbacks e sugestões são sempre bem-vindos!

---

## 📬 Contato

Se tiver dúvidas ou sugestões sobre o projeto, sinta-se à vontade para abrir uma [issue](../../issues).

---

<div align="center">

**⭐ Se este projeto te ajudou de alguma forma, deixe uma estrela! ⭐**

Feito com ☕ e muito aprendizado!

</div>
