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

**Bloco 5 - Arquivos e Dados (Aulas 14-15)** ← **VOCÊ ESTÁ AQUI**
- Praticando com Arquivo CSV
- Praticando com Arquivo JSON

**Bloco 6 - Design Avançado (Aulas 16-19)**
- Refatoração e Interfaces
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

#### 💡 Aprendizado Chave

**Protected permite acesso por:**
- ✅ Classes no **mesmo pacote**
- ✅ **Subclasses** (mesmo em outros pacotes)
- ❌ NÃO permite acesso público geral

**Diferença dos Modificadores:**

| Modificador | Mesma Classe | Mesmo Pacote | Subclasse (outro pacote) | Qualquer Classe |
|-------------|--------------|--------------|--------------------------|-----------------|
| `private`   | ✅           | ❌           | ❌                       | ❌              |
| `default`   | ✅           | ✅           | ❌                       | ❌              |
| `protected` | ✅           | ✅           | ✅                       | ❌              |
| `public`    | ✅           | ✅           | ✅                       | ✅              |

#### 🛠️ Funcionalidades da IDE Aprendidas
- **Geração de Getters/Setters:** `Alt + Insert` → Generate → Getters and Setters
- Seleção automática de atributos
- Geração em lote (todos de uma vez)

#### 🎯 Por que usar Getters e Setters?
- ✅ **Encapsulamento:** Protege atributos privados
- ✅ **Validação:** Pode adicionar lógica antes de setar valores
- ✅ **Flexibilidade:** Permite mudar implementação interna sem quebrar código externo
- ✅ **Padrão JavaBeans:** Convenção da linguagem

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

#### 📚 Métodos String Aprendidos

**Informações sobre a String:**
- `length()` - Retorna tamanho da string
- `charAt(index)` - Retorna caractere em uma posição
- `isEmpty()` - Verifica se está vazia

**Verificações:**
- `contains(String)` - Verifica se contém uma substring
- `startsWith(String)` - Verifica se começa com determinado texto
- `endsWith(String)` - Verifica se termina com determinado texto

**Comparações:**
- `==` - Compara referências (NÃO usar para conteúdo!)
- `equals(String)` - Compara conteúdo (case-sensitive)
- `equalsIgnoreCase(String)` - Compara conteúdo (ignora maiúsculas/minúsculas)

**Transformações:**
- `toUpperCase()` - Converte para maiúsculas
- `toLowerCase()` - Converte para minúsculas
- `replace(old, new)` - Substitui caracteres/texto
- `trim()` - Remove espaços nas extremidades
- `concat(String)` - Concatena strings

**Extração:**
- `substring(start)` - Extrai do índice até o final
- `substring(start, end)` - Extrai entre índices
- `split(delimiter)` - Divide string em array

#### 💻 Código de Exemplo - TesteString.java

```java
String nomeItem1 = "Refresco do Chaves";

// Tamanho e acesso a caracteres
IO.println(nomeItem1.length());        // 18
IO.println(nomeItem1.charAt(0));       // 'R'

// Verificações
IO.println(nomeItem1.contains("Chaves"));      // true
IO.println(nomeItem1.startsWith("Refresco"));  // true
IO.println(nomeItem1.endsWith("Chaves"));      // true

// Divisão de string
String[] pedacos = nomeItem1.split(" ");
// ["Refresco", "do", "Chaves"]

// Comparação (IMPORTANTE!)
String digitado = IO.readln("Digite: ");
IO.println(nomeItem1 == digitado);             // ❌ Não use!
IO.println(nomeItem1.equals(digitado));        // ✅ Use este!
IO.println(nomeItem1.equalsIgnoreCase(digitado)); // ✅ Ignora case

// Transformações
IO.println(nomeItem1.toUpperCase());   // "REFRESCO DO CHAVES"
IO.println(nomeItem1.toLowerCase());   // "refresco do chaves"
IO.println(nomeItem1.replace(" ", "-")); // "Refresco-do-Chaves"
IO.println(nomeItem1.substring(0, 8)); // "Refresco"
```

#### 🎯 Exercícios Realizados

**Exercício 1 - Processador de Nomes:**
```java
String nomeCompleto = IO.readln("Informe seu nome completo: ");
String[] nomeSobrenome = nomeCompleto.split(" ");
IO.println("Olá, " + nomeSobrenome[0] + " " + nomeSobrenome[nomeSobrenome.length - 1]);
// Entrada: "João da Silva"
// Saída: "Olá, João Silva"
```

**Exercício 2 - Validador de URL:**
```java
String url = IO.readln("Digite uma URL: ");
boolean inicioValido = url.startsWith("http://") || 
                       url.startsWith("https://") || 
                       url.startsWith("HTTP://");
boolean fimValido = url.endsWith(".com") || url.endsWith(".com.br");

if (inicioValido && fimValido) {
    IO.println("URL válida");
} else {
    IO.println("URL inválida");
}
```

#### 💡 Lições Importantes

**1. Strings são Imutáveis:**
```java
String nome = "Refresco";
String nomeMaiusculo = nome.toUpperCase();
IO.println(nome);           // "Refresco" (não mudou!)
IO.println(nomeMaiusculo);  // "REFRESCO" (nova string)
```

**2. Use `equals()` para Comparar:**
```java
// ❌ ERRADO
if (nome == "Refresco") { ... }

// ✅ CORRETO
if (nome.equals("Refresco")) { ... }
```

**3. Cuidado com `split()`:**
- Retorna um array
- Sempre verifique se array tem elementos suficientes
- Exemplo: "João" → só 1 elemento (sem sobrenome)

#### 📝 Estrutura de Pacotes Atualizada

```
mx.florinda/
├── cli/
│   ├── Main.java
│   └── TesteString.java  ← NOVO
└── modelo/
    └── ...

guisleri.exercicios.aula12.string/  ← NOVO (exercícios separados)
└── Main.java
```

#### 🔗 Aplicações Práticas no Projeto

- Validação de nomes de itens
- Formatação de textos para exibição
- Processamento de entrada do usuário
- Geração de URLs/slugs (ex: "Refresco do Chaves" → "refresco-do-chaves")

---

### Aula 13 - Imutabilidade, StringBuilder e Final

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Conceito de imutabilidade
- StringBuilder vs String
- Palavra-chave `final` em variáveis, métodos e classes

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

#### 📊 Teste de Performance

**Comparação String vs StringBuilder:**
```java
// Concatenação com String (LENTO)
long inicio = System.currentTimeMillis();
String teste = "";
for (int i = 0; i < 1_000; i++) {
    teste += i + ", ";  // Cria NOVO objeto a cada iteração
}
long fim = System.currentTimeMillis();
IO.println("Tempo String: " + (fim - inicio));  // Ex: 4-6 ms

// Concatenação com StringBuilder (RÁPIDO)
long inicioSB = System.currentTimeMillis();
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 1_000; i++) {
    builder.append(i).append(", ");  // Modifica MESMO objeto
}
long fimSB = System.currentTimeMillis();
IO.println("Tempo StringBuilder: " + (fimSB - inicioSB));  // Ex: 0-1 ms
```

**Resultado:** StringBuilder é **4-6x mais rápido** neste exemplo!

#### 💡 Aprendizado Chave - Imutabilidade

**String é Imutável:**
```java
String nome = "Refresco do Chaves";
nome.toUpperCase();  // Cria NOVA string, mas não altera 'nome'
IO.println(nome);    // Ainda é "Refresco do Chaves"

// Para "modificar", precisa reatribuir:
nome = nome.toUpperCase();  // Agora 'nome' aponta para novo objeto
IO.println(nome);           // "REFRESCO DO CHAVES"
```

**Por que String é imutável?**
- ✅ Segurança em ambientes multi-thread
- ✅ String Pool (economia de memória)
- ✅ Pode ser usada como chave em HashMap
- ✅ Segurança (valores não podem ser alterados)

#### 🎯 Modificador `final`

**1. Final em Classes:**
```java
public final class Coordenada {  // Não pode ser herdada
    // ...
}

// ❌ ERRO: Não pode estender classe final
public class CoordenadaTridimensional extends Coordenada { }
```

**2. Final em Atributos:**
```java
public class Coordenada {
    private final double x;  // Só pode ser atribuído UMA vez
    private final double y;
    
    public Coordenada(double x, double y) {
        this.x = x;  // Atribuição no construtor
        this.y = y;
    }
    
    // ❌ Não há setters! Atributos são final
}
```

**3. Final em Variáveis Locais:**
```java
void calcular() {
    final double PI = 3.14159;  // Constante local
    // PI = 3.14;  // ❌ ERRO: não pode reatribuir
}
```

#### 📝 Exercício 1 - Construtor de Relatórios

**Classe Produto:**
```java
public class Produto {
    private String nome;
    private double preco;
    
    // Método 1: String (ineficiente em loops)
    public static String relatorioComString(Produto[] produtos) {
        String relatorio = "";
        for (Produto p : produtos) {
            relatorio += p.getNome() + " - R$ " + p.getPreco() + "\n";
        }
        return relatorio;
    }
    
    // Método 2: StringBuilder (eficiente)
    public static String relatorioComStringBuilder(Produto[] produtos) {
        StringBuilder sb = new StringBuilder();
        for (Produto p : produtos) {
            sb.append(p.getNome())
              .append(" - R$ ")
              .append(p.getPreco())
              .append("\n");
        }
        return sb.toString();
    }
}
```

**Aprendizado:**
- String cria múltiplos objetos intermediários
- StringBuilder modifica o mesmo objeto
- Use StringBuilder para concatenação em loops!

#### 📝 Exercício 2 - Classe Imutável

**Classe Coordenada:**
```java
public final class Coordenada {  // 1. Classe final (não herda)
    
    private final double x;  // 2. Atributos final (não mudam)
    private final double y;
    
    public Coordenada(double x, double y) {  // 3. Valores definidos no construtor
        this.x = x;
        this.y = y;
    }
    
    // 4. Apenas getters (sem setters!)
    public double getX() { return x; }
    public double getY() { return y; }
    
    // 5. Métodos retornam novos objetos se precisarem "modificar"
    public double distancia(Coordenada outra) {
        double dx = outra.x - this.x;
        double dy = outra.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
```

**Características de Classe Imutável:**
1. ✅ Classe `final` (não pode ser herdada)
2. ✅ Todos os atributos `private final`
3. ✅ Valores definidos apenas no construtor
4. ✅ Sem setters
5. ✅ Métodos que "modificam" retornam novos objetos

**Benefícios:**
- Thread-safe (seguro em concorrência)
- Pode ser compartilhado livremente
- Ótimo para valores, coordenadas, datas, etc.

#### 📂 Nova Estrutura de Pacotes

```
guisleri.exercicios.aula13.stringbuilder/
├── exe01/
│   ├── Main.java
│   └── Produto.java
└── exe02/
    ├── Main.java
    └── Coordenada.java (final class)

mx.florinda/
├── cli/
│   ├── Main.java
│   └── TesteString.java (atualizado com teste de performance)
└── modelo/
    └── ...
```

#### 🔍 Quando Usar Cada Um?

| Situação | Use |
|----------|-----|
| Concatenação simples | String com `+` |
| Loop concatenando strings | **StringBuilder** |
| Ambiente multi-thread | StringBuffer |
| Valores que não mudam | Atributos `final` |
| Classes de valor | Classe `final` + atributos `final` |

#### ⚠️ Observações Importantes

**Final vs Imutabilidade:**
- `final` = referência não pode mudar
- Imutável = conteúdo do objeto não pode mudar

```java
final StringBuilder sb = new StringBuilder("Oi");
sb.append(" mundo");  // ✅ OK! O conteúdo pode mudar
sb = new StringBuilder();  // ❌ ERRO! A referência não pode mudar
```

**Tipos Primitivos com Final:**
- `final double` ✅ Funciona normalmente
- `final boolean` ✅ Funciona normalmente
- `final int` ✅ Funciona normalmente

---

### Aula 14 - Praticando com Arquivo CSV

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Leitura e escrita de arquivos CSV
- Parsing de dados
- Manipulação de arquivos em Java

---

### Aula 15 - Praticando com Arquivo JSON

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Leitura e escrita de arquivos JSON
- Bibliotecas JSON em Java
- Serialização e desserialização

---

### Aula 16 - Refatoração e Interfaces

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Técnicas de refatoração
- Conceito de Interfaces
- Programação para interfaces
- Contratos e implementações

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

---

## 📊 Métricas do Projeto

| Métrica | Valor Atual |
|---------|-------------|
| Classes criadas | 12+ |
| Linhas de código | ~700+ |
| Conceitos de POO aplicados | 8 |
| Exercícios resolvidos | 6 (aulas 10-13) |
| Aulas versionadas | 4 de 19 |
| Aulas concluídas | 13 de 19 |

---

## 🎯 Próximos Passos

**Bloco 4 - POO Avançada:**
- [x] Aula 11 - Protected ✅
- [x] Aula 12 - String ✅
- [x] Aula 13 - Imutabilidade, StringBuilder e Final ✅

**Bloco 5 - Arquivos e Dados:**
- [ ] Aula 14 - Praticando com Arquivo CSV
- [ ] Aula 15 - Praticando com Arquivo JSON

**Bloco 6 - Design Avançado:**
- [ ] Aula 16 - Refatoração e Interfaces
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

---

## 📌 Notas de Desenvolvimento

### Decisões de Design

**Por que usar composição?**
- Um restaurante sempre deve ter um cardápio
- O ciclo de vida do cardápio está vinculado ao restaurante
- Facilita a manutenção e evolução do código

**Estrutura de pacotes:**
- `mx.florinda.modelo` - Classes de domínio (entidades do negócio)
- `mx.florinda.cli` - Interface com o usuário (entrada/saída)

---

## 🔗 Links Úteis

- [README Principal](../README.md)
- [Conceitos Aprendidos](conceitos-aprendidos.md)
- [Repositório do Curso](https://github.com/professor-username/repo-curso) (referência)

---

_Documento atualizado em: Fevereiro 2026_
_Última aula registrada: Aula 13_