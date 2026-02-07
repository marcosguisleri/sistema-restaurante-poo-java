# 📈 Evolução do Projeto

Este documento registra a evolução do **Sistema de Restaurante POO** ao longo das 19 aulas do **Módulo 1 - Introdução ao Java** do curso Java Elite.

---

## 🎯 Objetivo

Acompanhar a transformação progressiva do código, desde uma implementação estruturada até um sistema orientado a objetos completo com interfaces, classes abstratas, manipulação de arquivos (CSV/JSON) e tratamento de exceções.

---

## 📚 Estrutura do Módulo 1

### Blocos de Conteúdo

**Bloco 1 - Fundamentos (Aulas 1-4)**
- O Que é Java?, JVM, JSR e JEP
- Variáveis, Operadores e Condicionais
- Arrays e Laços de Repetição

**Bloco 2 - Orientação a Objetos Básica (Aulas 5-7)**
- Classes, Atributos e Objetos
- Métodos e Construtores
- Arrays de Objetos, Composição e Enums

**Bloco 3 - Ferramentas e Organização (Aulas 8-10)**
- IntelliJ IDE e Debug
- Organizando em Arquivos e Herança
- Pacotes, Modificadores de Acesso, Getters e Setters

**Bloco 4 - POO Avançada (Aulas 11-13)**
- Protected ✅
- String ✅
- Imutabilidade, StringBuilder e Final ✅

**Bloco 5 - Arquivos e Dados (Aulas 14-15)**
- Praticando com Arquivo CSV ✅
- Praticando com Arquivo JSON ✅

**Bloco 6 - Design Avançado (Aulas 16-19)** ← **VOCÊ ESTÁ AQUI**
- Refatoração e Interfaces ✅
- Classes Abstratas e Static
- Object, Classes Wrapper e Javadoc
- JARs e Exceptions

---

## 📖 Histórico de Aulas

### Aula 10 - Pacotes, Modificadores de Acesso, Getters e Setters

**Data de Versionamento:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Exercício 1:** Criação da classe `Restaurante`
- Atributos: `nome`, `endereco`
- Encapsulamento com getters e setters
- Método `apresentarRestaurante()` para exibir informações

**Exercício 2:** Composição - Associando Cardápio ao Restaurante
- Adicionado atributo `Cardapio` na classe `Restaurante`
- Implementado getter e setter para o cardápio
- Relação "tem-um" (composição) entre Restaurante e Cardápio
- Acesso ao cardápio através do restaurante: `restaurante.getCardapio().getItensPorId(id)`

#### 🎓 Conceitos Aplicados
- ✅ Encapsulamento (atributos private + getters/setters)
- ✅ Modificadores de acesso (private, public)
- ✅ Composição (Restaurante HAS-A Cardapio)
- ✅ Organização em pacotes (`mx.florinda.modelo`, `mx.florinda.cli`)

#### 📝 Estrutura de Classes

```
Restaurante
├── nome: String
├── endereco: String
└── cardapio: Cardapio (composição)

Cardapio
└── itens: ItemCardapio[] (agregação)

ItemCardapio (classe base)
├── ItemCardapioBebida
├── ItemCardapioIsento
└── ItemCardapioSemGluten
```

---

### Aula 11 - Protected

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Modificador de Acesso Protected:**
- Alterado construtor de `ItemCardapio` de `default` (package-private) para `protected`
- Permite acesso do construtor por subclasses em pacotes diferentes
- Aprendi que `protected` é acessível por:
  - Classes no mesmo pacote
  - Subclasses (mesmo em pacotes diferentes)

**Geração Automática de Código (IntelliJ):**
- Aprendi a gerar getters e setters automaticamente com a IDE
- Atalho: `Alt + Insert` (ou `Code → Generate`)
- Entendi o motivo dos getters/setters: encapsulamento e controle de acesso

#### 🎓 Conceitos Aplicados
- ✅ Modificador de acesso `protected`
- ✅ Visibilidade entre pacotes e herança
- ✅ Geração automática de getters/setters
- ✅ Encapsulamento

---

### Aula 12 - String

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Classe de Teste no Projeto Principal:**
- Criada classe `TesteString` no pacote `mx.florinda.cli`
- Pratica métodos da classe String usando itens do cardápio
- Demonstração de manipulação de strings no contexto do projeto

**Exercícios Práticos (Pacote Separado):**
- Criado pacote `guisleri.exercicios.aula12.string`
- **Exercício 1 - Processador de Nomes:** Extrai primeiro e último nome usando `split()`
- **Exercício 2 - Validador de URL:** Valida URLs usando `startsWith()` e `endsWith()`

#### 🎓 Conceitos Aplicados
- ✅ Manipulação de Strings em Java
- ✅ Métodos principais da classe String
- ✅ Comparação de Strings (== vs equals())
- ✅ Imutabilidade de Strings
- ✅ Case-sensitivity

---

### Aula 13 - Imutabilidade, StringBuilder e Final

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**No Projeto Principal - TesteString.java:**
- Adicionado teste de performance comparando String vs StringBuilder
- Demonstração prática da ineficiência de concatenação em loops
- Medição de tempo de execução com `System.currentTimeMillis()`

**Exercícios Práticos (Pacotes Separados):**
- Criado pacote `guisleri.exercicios.aula13.stringbuilder`
- **Exercício 1 - Construtor de Relatórios:**
  - Classe `Produto` com atributos `nome` e `preco`
  - Dois métodos estáticos: `relatorioComString()` e `relatorioComStringBuilder()`
  - Comparação de abordagens de construção de strings
- **Exercício 2 - Classe Imutável:**
  - Classe `Coordenada` imutável com `final` na classe e atributos
  - Atributos `x` e `y` do tipo `double` com `final`
  - Método `distancia()` para cálculo euclidiano
  - Demonstração de imutabilidade completa

#### 🎓 Conceitos Aplicados
- ✅ Imutabilidade de Strings (teoria + prática)
- ✅ StringBuilder para performance
- ✅ Modificador `final` em classes
- ✅ Modificador `final` em atributos
- ✅ Modificador `final` em variáveis locais
- ✅ Medição de performance com `System.currentTimeMillis()`
- ✅ Criação de classes imutáveis

---

### Aula 14 - Praticando com Arquivo CSV

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Arquivos de Dados Externos:**
- Criado `itens-cardapio.csv` na raiz do projeto com 7 itens
- Criado `itens-cardapio.json` (preparação para Aula 15)
- Formato CSV: 9 colunas separadas por ponto-e-vírgula (;)

**Refatoração do Construtor do Cardápio:**
- Novo construtor aceita `String nomeArquivo` como parâmetro
- Implementado parsing automático de CSV
- Validações de estrutura de dados (9 colunas obrigatórias)
- Tratamento de exceções com `IOException`
- Instanciação dinâmica das subclasses corretas baseado nos flags

**Atualização do Main:**
- Adicionado input para usuário escolher arquivo de dados
- Mantém compatibilidade com fluxo anterior do programa

**Remoção de Código de Teste:**
- Removida classe `TesteString.java` (exercícios salvos localmente)
- Mantém foco no projeto do restaurante

#### 🎓 Conceitos Aplicados
- ✅ Manipulação de arquivos com `java.nio.file.Path` e `Files`
- ✅ Parsing de strings com `split(";", -1)`
- ✅ Tratamento de exceções (`IOException`)
- ✅ Conversão de tipos (`Long.parseLong`, `Double.parseDouble`, `Boolean.parseBoolean`)
- ✅ Validação de dados estruturados
- ✅ Separação de dados e lógica de negócio
- ✅ Enum.valueOf() para conversão de strings em enums

---

### Aula 15 - Praticando com Arquivo JSON

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Suporte para Leitura de JSON:**
- Implementado parsing manual de JSON no construtor do Cardápio
- Detecta tipo de arquivo por extensão (`.json`)
- Processa estrutura JSON através de manipulação de strings
- Mantém compatibilidade total com CSV existente

**Lógica de Parsing JSON:**
- Remove caracteres estruturais: `[`, `]`, `{`, `}`, `"`
- Split por regex para identificar separadores de campos: `",\\s*\""`
- Extração de pares chave-valor com split limitado
- Tratamento de valores `null` do JSON

**Validações Específicas JSON:**
- Verificação de campos `null` (string "null" vs null Java)
- Tratamento de descrições com vírgulas internas
- Split com limite `2` para campos que podem conter dois-pontos
- Limpeza de aspas remanescentes após splits

#### 🎓 Conceitos Aplicados
- ✅ Parsing manual de JSON (abordagem pedagógica)
- ✅ Expressões regulares (regex) para split avançado
- ✅ Manipulação complexa de strings
- ✅ Tratamento de valores null em JSON
- ✅ Split com limite para preservar conteúdo
- ✅ Verificação de tipo de arquivo por extensão

---

### Aula 16 - Refatoração e Interfaces

**Status:** ✅ Concluída  
**Data:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Criação do Pacote `leitor`:**
- Novo pacote `mx.florinda.leitor` para organizar lógica de leitura de arquivos
- Separação de responsabilidades: modelo vs leitura de dados

**Interface `LeitorItensCardapio`:**
```java
public interface LeitorItensCardapio {
    public abstract ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
}
```
- Define contrato para leitores de arquivo
- Método `processaArquivo()` que todas as implementações devem ter

**Classe `LeitorItensCardapioCSV`:**
- Implementa `LeitorItensCardapio`
- Contém toda a lógica de parsing CSV (movida do `Cardapio`)
- Método `processaArquivo()` retorna array de `ItemCardapio`
- ~70 linhas de código especializado em CSV

**Classe `LeitorItensCardapioJSON`:**
- Implementa `LeitorItensCardapio`
- Contém toda a lógica de parsing JSON (movida do `Cardapio`)
- Método `processaArquivo()` retorna array de `ItemCardapio`
- ~90 linhas de código especializado em JSON

**Classe `FabricaLeitorItensCardapio` (Factory Pattern):**
```java
public class FabricaLeitorItensCardapio {
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        if (nomeArquivo.endsWith(".csv")) {
            return new LeitorItensCardapioCSV();
        } else if (nomeArquivo.endsWith(".json")) {
            return new LeitorItensCardapioJSON();
        }
        return null;
    }
}
```
- Centraliza lógica de criação de leitores
- Decide qual leitor instanciar baseado na extensão do arquivo
- Padrão de projeto Factory (Simple Factory)

**Refatoração do Construtor `Cardapio`:**
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
- Reduzido de ~120 linhas para ~10 linhas (92% de redução!)
- Responsabilidade única: coordenar criação do cardápio
- Delega parsing para classes especializadas

**Atualização do Main:**
- Agora lança `Exception` ao invés de `IOException`
- Mantém mesma interface de uso para o usuário
- Funcionamento transparente da refatoração

#### 🎓 Conceitos Aplicados
- ✅ **Interfaces**: Definição de contratos entre classes
- ✅ **Refatoração**: Reestruturação de código sem alterar comportamento
- ✅ **Factory Pattern**: Padrão de criação de objetos
- ✅ **Single Responsibility Principle**: Uma classe, uma responsabilidade
- ✅ **Open/Closed Principle**: Aberto para extensão, fechado para modificação
- ✅ **Dependency Inversion**: Depender de abstrações (interface), não de concretizações
- ✅ **Polimorfismo avançado**: Via interfaces
- ✅ **Separação de responsabilidades**: Modelo, leitura e apresentação
- ✅ **Organização em pacotes**: Novo pacote `leitor`

#### 📊 Estrutura de Pacotes Atualizada

```
src/mx/florinda/
├── cli/
│   └── Main.java                       # Interface com usuário
├── leitor/                             # NOVO! Lógica de leitura ⭐
│   ├── FabricaLeitorItensCardapio.java # Factory pattern
│   ├── LeitorItensCardapio.java        # Interface (contrato)
│   ├── LeitorItensCardapioCSV.java     # Implementação CSV
│   └── LeitorItensCardapioJSON.java    # Implementação JSON
└── modelo/
    ├── isento/
    │   └── ItemCardapioIsento.java
    ├── Cardapio.java                   # Refatorado! ⭐
    ├── CategoriaCardapio.java
    ├── ItemCardapio.java
    ├── ItemCardapioBebida.java
    ├── ItemCardapioSemGluten.java
    └── Restaurante.java
```

#### 💡 Evolução do Código

**ANTES (Aula 15) - Construtor Cardapio:**
```java
public Cardapio(String nomeArquivo) throws IOException {
    Path arquivo = Path.of(nomeArquivo);
    String conteudo = Files.readString(arquivo);
    String[] linhas = conteudo.split("\n");
    itens = new ItemCardapio[linhas.length];
    
    for (int i = 0; i < linhas.length; i++) {
        String linha = linhas[i].strip();
        
        if (linha.isEmpty()) continue;
        
        if (nomeArquivo.endsWith(".csv")) {
            // 50+ linhas de parsing CSV
            String[] partes = linha.split(";", -1);
            // ... validações ...
            // ... conversões ...
            // ... instanciação ...
        } else if (nomeArquivo.endsWith(".json")) {
            // 60+ linhas de parsing JSON
            linha = linha.replace("[", "").replace("]", "");
            // ... limpeza ...
            // ... split com regex ...
            // ... extração de valores ...
        } else {
            System.out.println("Formato inválido");
        }
    }
}
```

**Problemas identificados:**
- ❌ Construtor gigante (~120 linhas)
- ❌ Múltiplas responsabilidades (criar + ler + parsear CSV + parsear JSON)
- ❌ Violação do Single Responsibility Principle
- ❌ Difícil de testar individualmente
- ❌ Difícil adicionar novos formatos (XML, YAML, etc.)
- ❌ Código duplicado entre CSV e JSON
- ❌ Alto acoplamento

**DEPOIS (Aula 16) - Construtor Cardapio:**
```java
public Cardapio(String nomeArquivo) throws Exception {
    // Responsabilidade: coordenar criação
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

**Benefícios alcançados:**
- ✅ Construtor reduzido de ~120 para ~10 linhas (92% redução!)
- ✅ Responsabilidade única: criar cardápio
- ✅ Lógica de parsing em classes especializadas
- ✅ Fácil adicionar XML, YAML, etc. (só criar `LeitorItensCardapioXML`)
- ✅ Cada classe testável independentemente
- ✅ Código mais legível e manutenível
- ✅ Baixo acoplamento (usa interface, não implementação)
- ✅ Alta coesão (cada classe faz uma coisa bem feita)

#### 🔄 Técnicas de Refatoração Aplicadas

**1. Extract Class (Extrair Classe):**
- Lógica CSV → `LeitorItensCardapioCSV`
- Lógica JSON → `LeitorItensCardapioJSON`
- Lógica de criação → `FabricaLeitorItensCardapio`

**2. Extract Interface (Extrair Interface):**
- Criação de `LeitorItensCardapio`
- Define comportamento comum de todos os leitores

**3. Replace Conditional with Polymorphism:**
- ANTES: `if (csv) { ... } else if (json) { ... }`
- DEPOIS: `leitor.processaArquivo()` (polimorfismo decide)

**4. Introduce Factory:**
- Centraliza criação de objetos em `FabricaLeitorItensCardapio`
- Cliente (`Cardapio`) não sabe qual classe concreta é instanciada

#### 📊 Impacto nas Métricas

| Métrica | Antes (Aula 15) | Depois (Aula 16) | Melhoria |
|---------|-----------------|-------------------|----------|
| Linhas no construtor | ~120 | ~10 | ✅ 92% redução |
| Classes envolvidas | 1 | 5 | Responsabilidades distribuídas |
| Pacotes | 2 | 3 | ✅ Novo pacote `leitor` |
| Responsabilidades do Cardapio | 4 | 1 | ✅ SRP respeitado |
| Testabilidade | Baixa | Alta | ✅ Classes independentes |
| Extensibilidade | Baixa | Alta | ✅ Fácil adicionar formatos |
| Acoplamento | Alto | Baixo | ✅ Usa interfaces |
| Coesão | Baixa | Alta | ✅ Cada classe faz uma coisa |

#### 🎯 Lições Aprendidas

1. **Interfaces definem contratos**: Garantem que classes tenham comportamento esperado
2. **Refatoração incremental**: Pequenas mudanças, testes frequentes
3. **Factory simplifica criação**: Cliente não precisa saber qual classe instanciar
4. **SRP facilita manutenção**: Uma classe, uma responsabilidade = código mais claro
5. **Polimorfismo via interface**: Mesma variável, comportamentos diferentes
6. **Open/Closed na prática**: Adicionar XML sem modificar código existente
7. **Separação de responsabilidades**: Modelo (o quê) vs Leitor (como)
8. **Código menor ≠ código pior**: 10 linhas bem organizadas > 120 linhas confusas

#### 🚀 Extensibilidade Demonstrada

**Adicionar suporte a XML (futuro):**

```java
// 1. Criar nova classe (Open/Closed: aberto para extensão)
public class LeitorItensCardapioXML implements LeitorItensCardapio {
    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Implementação XML
        return itens;
    }
}

// 2. Atualizar apenas a fábrica
public class FabricaLeitorItensCardapio {
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        if (nomeArquivo.endsWith(".csv")) return new LeitorItensCardapioCSV();
        if (nomeArquivo.endsWith(".json")) return new LeitorItensCardapioJSON();
        if (nomeArquivo.endsWith(".xml")) return new LeitorItensCardapioXML(); // NOVO!
        return null;
    }
}

// 3. ZERO mudanças em: Cardapio, Main, ItemCardapio, Restaurante
```

**Vantagens:**
- ✅ Cardapio não muda
- ✅ Main não muda
- ✅ Modelo não muda
- ✅ Só adiciona código novo
- ✅ Sem risco de quebrar código existente

#### 🔗 Conexão com Aulas Anteriores

**Aula 14 (CSV) + Aula 15 (JSON) → Aula 16 (Refatoração):**
- Todo código de parsing foi preservado
- Só foi **reorganizado** em classes especializadas
- Comportamento externo permanece idêntico
- Qualidade interna drasticamente melhorada

**Conhecimentos anteriores aplicados:**
- Aula 10: Composição (Cardapio usa LeitorItensCardapio)
- Aula 11: Protected (mantido nas classes de modelo)
- Aula 12-13: String/StringBuilder (usado nos leitores)
- Aula 14-15: Parsing (movido para classes especializadas)

---

### Aula 17 - Classes Abstratas e Static

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Classes abstratas vs interfaces
- Métodos abstratos
- Palavra-chave `static`
- Membros de classe vs membros de instância

---

### Aula 18 - Object, Classes Wrapper e Javadoc

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Classe Object e seus métodos
- Classes Wrapper (Integer, Double, etc.)
- Autoboxing e Unboxing
- Documentação com Javadoc

---

### Aula 19 - JARs e Exceptions

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Criação de arquivos JAR
- Tratamento de exceções (try-catch-finally)
- Exceções checked vs unchecked
- Criação de exceções customizadas

---

## 🔄 Mudanças Principais por Versão

### v0.10 - Composição de Objetos (Aula 10)

**Antes:**
```java
// Cardápio e Restaurante existiam separadamente
Cardapio cardapio = new Cardapio();
Restaurante restaurante = new Restaurante("Florinda", "Av. 123");
```

**Depois:**
```java
// Restaurante contém o cardápio (composição)
Restaurante restaurante = new Restaurante("Florinda", "Av. 123");
Cardapio cardapio = new Cardapio();
restaurante.setCardapio(cardapio);

// Acesso através do restaurante
ItemCardapio item = restaurante.getCardapio().getItensPorId(1L);
```

**Benefícios:**
- ✅ Modelagem mais próxima do mundo real
- ✅ Melhor organização do código
- ✅ Encapsulamento da lógica de negócio

### v0.14 - Leitura de Arquivos CSV (Aula 14)

**Antes:**
```java
// Instanciação manual de todos os itens
public Cardapio() {
    itens = new ItemCardapio[7];
    itens[0] = new ItemCardapio(1, "Refresco", ...);
    // ... dezenas de linhas
}
```

**Depois:**
```java
// Leitura dinâmica de arquivo
Cardapio cardapio = new Cardapio("itens-cardapio.csv");
// Todos os itens carregados automaticamente!
```

**Benefícios:**
- ✅ Código drasticamente reduzido
- ✅ Dados separados da lógica
- ✅ Fácil adicionar/remover/modificar itens
- ✅ Não precisa recompilar para mudar dados
- ✅ Escalabilidade ilimitada

### v0.15 - Suporte a JSON (Aula 15)

**Antes:**
```java
// Suportava apenas CSV
if (nomeArquivo.endsWith(".csv")) {
    // parsing CSV
} else {
    System.out.println("Formato inválido");
}
```

**Depois:**
```java
// Suporta CSV E JSON!
if (nomeArquivo.endsWith(".csv")) {
    // parsing CSV
} else if (nomeArquivo.endsWith(".json")) {
    // parsing JSON
} else {
    System.out.println("Formato inválido");
}
```

**Benefícios:**
- ✅ Flexibilidade de formato de dados
- ✅ Mesmo código para múltiplos formatos
- ✅ Detecção automática por extensão
- ✅ Preparação para refatoração (Aula 16)

### v0.16 - Refatoração com Interfaces e Factory (Aula 16) ⭐

**Antes:**
```java
public class Cardapio {
    public Cardapio(String nomeArquivo) throws IOException {
        // 120 linhas de código
        // Lógica CSV inline
        // Lógica JSON inline
        // Múltiplas responsabilidades
    }
}
```

**Depois:**
```java
// Cardapio (10 linhas - coordena)
public class Cardapio {
    public Cardapio(String nomeArquivo) throws Exception {
        FabricaLeitorItensCardapio fabrica = new FabricaLeitorItensCardapio();
        LeitorItensCardapio leitor = fabrica.criaLeitor(nomeArquivo);
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        }
    }
}

// Interface (contrato)
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
}

// Implementações especializadas
public class LeitorItensCardapioCSV implements LeitorItensCardapio { ... }
public class LeitorItensCardapioJSON implements LeitorItensCardapio { ... }

// Factory (criação centralizada)
public class FabricaLeitorItensCardapio {
    public LeitorItensCardapio criaLeitor(String nomeArquivo) { ... }
}
```

**Benefícios:**
- ✅ **92% redução** no construtor (120 → 10 linhas)
- ✅ **SRP**: Cada classe uma responsabilidade
- ✅ **OCP**: Fácil adicionar XML, YAML sem modificar código existente
- ✅ **DIP**: Depende de abstração (interface), não concretização
- ✅ **Testabilidade**: Cada componente testável isoladamente
- ✅ **Manutenibilidade**: Código organizado em classes coesas
- ✅ **Extensibilidade**: Adicionar formatos = criar nova classe
- ✅ **Baixo acoplamento**: Cardapio não sabe qual leitor é usado

---

## 📊 Métricas do Projeto

## 📊 Métricas do Projeto

| Métrica | Valor Atual |
|---------|-------------|
| Classes criadas | 17+ |
| Linhas de código | ~850+ |
| Conceitos de POO aplicados | 13 |
| Exercícios resolvidos | 7 (aulas 10-13 + Aula 16 Ex. 2) |
| Aulas versionadas | 7 de 19 |
| Aulas concluídas | 16 de 19 |
| Arquivos de dados | 3 (CSV, JSON e XML) |
| Formatos suportados | 3 (CSV, JSON e XML) |
| Pacotes organizados | 3 (cli, modelo, leitor) |
| Interfaces criadas | 1 (LeitorItensCardapio) |
| Padrões de projeto | 1 (Factory) |

---

## 🎯 Próximos Passos

**Bloco 4 - POO Avançada:**
- [x] Aula 11 - Protected ✅
- [x] Aula 12 - String ✅
- [x] Aula 13 - Imutabilidade, StringBuilder e Final ✅

**Bloco 5 - Arquivos e Dados:**
- [x] Aula 14 - Praticando com Arquivo CSV ✅
- [x] Aula 15 - Praticando com Arquivo JSON ✅

**Bloco 6 - Design Avançado:**
- [x] Aula 16 - Refatoração e Interfaces ✅
- [ ] Aula 17 - Classes Abstratas e Static
- [ ] Aula 18 - Object, Classes Wrapper e Javadoc
- [ ] Aula 19 - JARs e Exceptions (Conclusão do Módulo 1)

---

## 💡 Lições Aprendidas

### Aula 10
1. **Composição vs Agregação**: Entendimento claro da diferença entre relacionamentos "tem-um"
2. **Encapsulamento**: Importância de proteger atributos e expor apenas interfaces necessárias
3. **Modelagem de domínio**: Como traduzir conceitos do mundo real em código

### Aula 11
1. **Protected**: Modificador perfeito para herança entre pacotes
2. **Geração de Código**: Usar recursos da IDE para produtividade (Alt+Insert)
3. **Getters/Setters**: Não são apenas "formalidade", garantem encapsulamento

### Aula 12
1. **Imutabilidade de Strings**: Métodos sempre retornam novas strings
2. **equals() vs ==**: Sempre usar equals() para comparar conteúdo de strings
3. **Métodos String**: Java oferece métodos poderosos para manipulação de texto

### Aula 13
1. **StringBuilder para Performance**: Concatenação em loops é ineficiente com String
2. **Final para Imutabilidade**: Classe `final` + atributos `final` = classe imutável
3. **Medição de Performance**: `System.currentTimeMillis()` para comparar abordagens
4. **Classes Imutáveis**: Úteis para valores, coordenadas, objetos de domínio

### Aula 14
1. **Separação de Dados e Lógica**: Dados em arquivos externos, lógica no código
2. **Validação é Investimento**: Cada validação previne horas de debug futuro
3. **Strings São Poderosas**: Métodos de String da Aula 13 foram essenciais
4. **Refatoração Traz Clareza**: Código menor E mais poderoso ao mesmo tempo
5. **Hard-coding é Limitante**: Fácil no começo, pesadelo depois
6. **IOException**: Importância do tratamento de exceções em I/O

### Aula 15
1. **Regex é Poderoso**: Expressões regulares resolvem problemas complexos de parsing
2. **Split com Limite**: `split(":", 2)` preserva conteúdo após primeiro delimitador
3. **Null em JSON**: String "null" é diferente de null Java
4. **Parsing Manual tem Limites**: Funciona para casos simples, mas bibliotecas são melhores
5. **Prática Pedagógica**: Entender estrutura interna antes de usar bibliotecas
6. **Multi-Formato**: Um sistema pode suportar múltiplos formatos simultaneamente
7. **Regex para Delimitadores**: `",\\s*\""` captura vírgulas seguidas de aspas
8. **Aprendizado Progressivo**: CSV → JSON manual → Refatoração (próxima aula)

### Aula 16
1. **Interfaces são contratos**: Garantem comportamento comum sem impor implementação
2. **Refatoração preserva comportamento**: Reestrutura internamente, não externamente
3. **Factory centraliza criação**: Cliente não precisa saber qual classe instanciar
4. **SRP na prática**: Uma responsabilidade = código mais fácil de entender e testar
5. **Polimorfismo via interface**: Flexibilidade sem conhecer tipos concretos
6. **Open/Closed é poderoso**: Adicionar funcionalidades sem modificar código existente
7. **Baixo acoplamento é meta**: Depender de abstrações, não de concretizações
8. **Código menor pode ser melhor**: 10 linhas bem organizadas > 120 linhas confusas
9. **Organização em pacotes**: Agrupa classes por responsabilidade
10. **Pequenas refatorações somam**: Extrair classe, interface, método = grande impacto
11. **Testabilidade vem de design**: Classes coesas e desacopladas são fáceis de testar
12. **Padrões resolvem problemas comuns**: Factory, Strategy, etc. são ferramentas úteis

---

### Aula 16 - Exercício 2: Suporte a XML

**Data de Implementação:** Fevereiro 2026

#### ✨ Novidades Implementadas

**Classe LeitorItensCardapioXML:**
- Terceira implementação da interface LeitorItensCardapio
- Parsing de XML linha a linha sem bibliotecas externas
- Métodos auxiliares para extração de conteúdo entre tags
- Controle de estado para acumular dados de cada item

**Atualização da FabricaLeitorItensCardapio:**
- Adicionada detecção de arquivos .xml
- Retorna LeitorItensCardapioXML quando apropriado
- Mantém compatibilidade total com CSV e JSON

**Estrutura do Arquivo XML:**
- Tag raiz: menu
- Tags item para cada produto
- Tags internas: id, nome, descricao, preco, categoria, etc.

#### 💻 Estratégia de Implementação

**1. Contagem de Itens:**
- Primeiro loop conta quantos tags item existem
- Cria array com tamanho exato

**2. Controle de Estado:**
- Variáveis temporárias acumulam dados de cada item
- Quando encontra item, reseta variáveis
- Quando encontra /item, cria objeto e adiciona ao array

**3. Extração de Conteúdo:**
- Método extrairConteudoTag localiza conteúdo entre tags
- Métodos específicos para cada tipo de dado (Long, String, Double, Boolean, Enum)

#### 🎓 Conceitos Aplicados

**Extensibilidade do Factory Pattern:**
- ZERO mudanças em: Cardapio, Main, Restaurante, ItemCardapio
- Apenas ADICIONADO: LeitorItensCardapioXML + uma linha na Factory

**Open/Closed Principle em Ação:**
- Sistema aberto para extensão (nova classe XML)
- Sistema fechado para modificação (código existente intacto)

**Polimorfismo via Interface:**
- Mesmo código funciona para CSV, JSON e agora XML
- Cliente não precisa saber qual formato está usando

#### 📊 Comparação: XML vs CSV vs JSON

| Aspecto | CSV | JSON | XML |
|---------|-----|------|-----|
| Linhas de código | ~70 | ~90 | ~120 |
| Complexidade | Baixa | Média | Média-Alta |
| Legibilidade arquivo | Baixa | Alta | Muito Alta |
| Estrutura | Linear | Aninhada | Hierárquica |
| Parsing | Split simples | Regex + Split | Tags + Estado |

#### 💡 Lições Aprendidas

1. **Factory Pattern facilita extensão** - Adicionar XML foi trivial
2. **Interface garante compatibilidade** - Nova implementação funcionou imediatamente
3. **Parsing manual ensina estrutura** - Entender XML ajuda a usar bibliotecas depois
4. **Organização em métodos** - Métodos auxiliares evitam repetição
5. **Arrays são suficientes** - Não precisa de List para estruturas simples

#### 🎯 Exercício Concluído

**Objetivo:** Adicionar suporte a XML sem modificar código existente  
**Status:** ✅ Completo  
**Resultado:** Sistema agora suporta 3 formatos de forma transparente  
**Aprendizado:** Factory Pattern + Interfaces = extensibilidade poderosa

---

## 📌 Notas de Desenvolvimento

### Decisões de Design

**Por que usar composição?**
- Um restaurante sempre deve ter um cardápio
- O ciclo de vida do cardápio está vinculado ao restaurante
- Facilita a manutenção e evolução do código

**Por que usar arquivos CSV?**
- Separação clara entre dados e lógica
- Fácil edição sem recompilar
- Escalável (qualquer quantidade de itens)
- Formato simples e legível

**Por que adicionar JSON?**
- Formato mais expressivo que CSV
- Suporta estruturas aninhadas (futuro)
- Padrão da indústria para APIs
- Preparação para refatoração

**Por que criar interfaces? (Aula 16)**
- Define contrato claro entre componentes
- Permite polimorfismo (mesmo tipo, diferentes implementações)
- Desacopla código (Cardapio não conhece leitores concretos)
- Facilita testes (pode criar mock de LeitorItensCardapio)
- Prepara para extensões futuras (XML, YAML, banco de dados)

**Por que usar Factory Pattern? (Aula 16)**
- Centraliza lógica de criação de objetos
- Cliente não precisa saber qual classe instanciar
- Fácil adicionar novos tipos (só atualiza factory)
- Encapsula regras de decisão (extensão → tipo de leitor)

**Por que refatorar? (Aula 16)**
- Código estava complexo e difícil de manter (120 linhas)
- Múltiplas responsabilidades em uma classe
- Difícil adicionar novos formatos
- Impossível testar parsing isoladamente
- Violava princípios SOLID

**Estrutura de pacotes:**
- `mx.florinda.cli` - Interface com usuário (entrada/saída)
- `mx.florinda.modelo` - Classes de domínio (entidades do negócio)
- `mx.florinda.leitor` - Lógica de leitura de arquivos ⭐ NOVO!

**Estrutura de arquivos:**
- Raiz do projeto: arquivos de dados (CSV, JSON)
- `src/`: código-fonte Java
- `docs/`: documentação do projeto

---

## 🏗️ Arquitetura do Projeto (Aula 16)

```
┌─────────────────────────────────────────────────┐
│                    Main                         │
│              (Interface usuário)                │
└────────────────────┬────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────┐
│                 Restaurante                     │
│          (Coordena componentes)                 │
└────────────────────┬────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────┐
│                  Cardapio                       │
│         (Usa Factory para criar)                │
└────────────────────┬────────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────────┐
│          FabricaLeitorItensCardapio             │
│         (Decide qual leitor criar)              │
└──────────┬──────────────────────┬────────────────┘
           │                      │
    .csv   │                      │  .json
           ▼                      ▼
┌──────────────────┐    ┌──────────────────────┐
│  LeitorCSV       │    │  LeitorJSON          │
│  (implements     │    │  (implements         │
│  LeitorItens...) │    │  LeitorItens...)     │
└──────────────────┘    └──────────────────────┘
           │                      │
           └──────────┬───────────┘
                      ▼
           ┌────────────────────┐
           │ LeitorItensCardapio│
           │    (interface)      │
           └────────────────────┘
                      │
                      ▼
           ┌────────────────────┐
           │  ItemCardapio[]     │
           │  (retorno)          │
           └────────────────────┘
```

**Fluxo de execução:**
1. Main solicita criação de Cardapio
2. Cardapio usa FabricaLeitorItensCardapio
3. Factory cria LeitorCSV ou LeitorJSON (baseado em extensão)
4. Leitor processa arquivo e retorna ItemCardapio[]
5. Cardapio armazena itens
6. Restaurante usa Cardapio
7. Main exibe informações ao usuário

**Vantagens da arquitetura:**
- ✅ Separação clara de responsabilidades
- ✅ Cada componente testável isoladamente
- ✅ Fácil adicionar novos formatos (XML, YAML)
- ✅ Baixo acoplamento entre componentes
- ✅ Alta coesão dentro de cada componente

---

## 🔗 Links Úteis

- [README Principal](../README.md)
- [Conceitos Aprendidos](conceitos-aprendidos.md)
- [Repositório do Curso](https://github.com/professor-username/repo-curso) (referência)

---

_Documento atualizado em: Fevereiro 2026_
_Última aula registrada: Aula 16_
