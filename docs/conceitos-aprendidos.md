# 🎓 Conceitos de POO Aprendidos

Este documento consolida os **conceitos de Programação Orientada a Objetos (POO)** aplicados no projeto do Restaurante da Dona Florinda.

---

## 📚 Índice

1. [Classes e Objetos](#1-classes-e-objetos)
2. [Encapsulamento](#2-encapsulamento)
3. [Herança](#3-herança)
4. [Polimorfismo](#4-polimorfismo)
5. [Composição e Agregação](#5-composição-e-agregação)
6. [Modificadores de Acesso](#6-modificadores-de-acesso)
7. [Enums](#7-enums)
8. [Construtores](#8-construtores)
9. [Manipulação de Strings](#9-manipulação-de-strings)
10. [StringBuilder e Performance](#10-stringbuilder-e-performance)
11. [Modificador Final](#11-modificador-final)
12. [Classes Imutáveis](#12-classes-imutáveis)
13. [Manipulação de Arquivos](#13-manipulação-de-arquivos)
14. [Tratamento de Exceções](#14-tratamento-de-exceções)

---

## 1. Classes e Objetos

### 📖 Teoria
- **Classe**: Modelo/template que define atributos e comportamentos
- **Objeto**: Instância concreta de uma classe

### 💻 Aplicação no Projeto

```java
// Classe (modelo)
public class Restaurante {
    private String nome;
    private String endereco;
}

// Objeto (instância)
Restaurante restaurante = new Restaurante("Florinda", "Av. 123");
```

### ✅ Onde foi usado
- `Restaurante`, `Cardapio`, `ItemCardapio` e suas especializações

---

## 2. Encapsulamento

### 📖 Teoria
Princípio que protege os dados internos de uma classe, expondo apenas o necessário através de métodos públicos (getters/setters).

### 🎯 Benefícios
- ✅ Controle sobre como os dados são acessados
- ✅ Validação de valores antes de atribuir
- ✅ Facilita manutenção (mudanças internas não afetam código externo)

### 💻 Aplicação no Projeto

```java
public class Restaurante {
    // Atributos PRIVADOS
    private String nome;
    private String endereco;
    private Cardapio cardapio;

    // Acesso controlado via métodos PÚBLICOS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // Aqui poderíamos adicionar validações
        this.nome = nome;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
}
```

### ✅ Onde foi usado
- Todas as classes do modelo (`Restaurante`, `ItemCardapio`, etc.)

---

## 3. Herança

### 📖 Teoria
Mecanismo que permite criar novas classes baseadas em classes existentes, reutilizando código e criando hierarquias.

### 🎯 Relação "É-UM"
- `ItemCardapioBebida` **É-UM** `ItemCardapio`
- `ItemCardapioIsento` **É-UM** `ItemCardapio`
- `ItemCardapioSemGluten` **É-UM** `ItemCardapio`

### 💻 Aplicação no Projeto

```java
// Classe PAI (superclasse)
public class ItemCardapio {
    private long id;
    private String nome;
    private double preco;
    // ...
}

// Classe FILHA (subclasse)
public class ItemCardapioBebida extends ItemCardapio {
    
    public ItemCardapioBebida(long id, String nome, String descricao, 
                              double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria); // Chama construtor do pai
    }
    
    // Herda todos os atributos e métodos da classe pai
}
```

### ✅ Hierarquia de Classes

```
         ItemCardapio (classe base)
                |
    ┌───────────┼───────────┐
    |           |           |
Bebida      Isento    SemGluten
```

---

## 4. Polimorfismo

### 📖 Teoria
Capacidade de objetos de classes diferentes responderem ao mesmo método de formas diferentes.

### 🎯 Tipos
- **Sobrescrita (Override)**: Subclasse redefine método da superclasse
- **Sobrecarga (Overload)**: Múltiplos métodos com mesmo nome mas parâmetros diferentes

### 💻 Aplicação no Projeto

#### Sobrescrita de Métodos

```java
// Na classe PAI
public class ItemCardapio {
    public double getImposto() {
        return preco * 0.1; // 10% de imposto padrão
    }
}

// Na classe FILHA
public class ItemCardapioBebida extends ItemCardapio {
    @Override
    public double getImposto() {
        return getPreco() * 0.5; // 50% de imposto para bebidas
    }
}

// Na classe FILHA
public class ItemCardapioIsento extends ItemCardapio {
    @Override
    public double getImposto() {
        return 0.0; // Isento de imposto
    }
}
```

#### Polimorfismo em Ação

```java
ItemCardapio[] itens = new ItemCardapio[3];
itens[0] = new ItemCardapioBebida(...);    // Bebida: 50% imposto
itens[1] = new ItemCardapioIsento(...);     // Isento: 0% imposto
itens[2] = new ItemCardapio(...);           // Padrão: 10% imposto

// Mesmo método, comportamentos diferentes!
for (ItemCardapio item : itens) {
    System.out.println(item.getImposto()); // Chama versão apropriada
}
```

### ✅ Onde foi usado
- `getImposto()` - Calculado diferentemente em cada tipo de item
- `ehSemGluten()` - Retorna `true` apenas em `ItemCardapioSemGluten`

---

## 5. Composição e Agregação

### 📖 Teoria

#### Composição (HAS-A forte)
- Objeto "pertence" a outro
- Ciclo de vida dependente
- Parte não existe sem o todo

#### Agregação (HAS-A fraca)
- Objeto "usa" outro
- Ciclo de vida independente
- Parte pode existir sem o todo

### 💻 Aplicação no Projeto

#### Composição

```java
public class Restaurante {
    private Cardapio cardapio; // Restaurante TEM-UM Cardapio
    
    // O cardápio faz parte do restaurante
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
}
```

#### Agregação

```java
public class Cardapio {
    private ItemCardapio[] itens; // Cardápio TEM-VÁRIOS itens
    
    // Os itens podem existir independentemente do cardápio
}
```

### 🎯 Diferença Visual

```
Composição (forte):
Restaurante ◆────── Cardapio
(Se restaurante é destruído, cardápio também é)

Agregação (fraca):
Cardapio ◇────── ItemCardapio
(Itens podem existir sem estar em um cardápio)
```

### ✅ Onde foi usado
- `Restaurante` **compõe** `Cardapio`
- `Cardapio` **agrega** `ItemCardapio[]`

---

## 6. Modificadores de Acesso

### 📖 Teoria

| Modificador | Classe | Pacote | Subclasse | Global |
|-------------|--------|--------|-----------|--------|
| `private`   | ✅     | ❌     | ❌        | ❌     |
| `default`   | ✅     | ✅     | ❌        | ❌     |
| `protected` | ✅     | ✅     | ✅        | ❌     |
| `public`    | ✅     | ✅     | ✅        | ✅     |

### 💻 Aplicação no Projeto

```java
public class ItemCardapio {
    // PRIVATE - Só acessível dentro da classe
    private long id;
    private String nome;
    
    // PROTECTED - Acessível no pacote e subclasses
    protected ItemCardapio(long id, String nome, ...) {
        this.id = id;
        this.nome = nome;
    }
    
    // PUBLIC - Acessível de qualquer lugar
    public long getId() {
        return id;
    }
}
```

### 🎯 Estratégia Usada
- **Atributos**: `private` (proteger dados)
- **Construtores**: `protected` (controlar criação, permitir herança)
- **Getters/Setters**: `public` (interface de acesso)
- **Métodos de negócio**: `public` (funcionalidades expostas)

---

## 7. Enums

### 📖 Teoria
Tipo especial que representa um conjunto fixo de constantes.

### 🎯 Benefícios
- ✅ Tipagem forte (evita valores inválidos)
- ✅ Código mais legível
- ✅ Autocomplete na IDE
- ✅ Segurança em tempo de compilação

### 💻 Aplicação no Projeto

```java
public enum CategoriaCardapio {
    ENTRADA,
    PRATOS_PRINCIPAIS,
    SOBREMESAS,
    BEBIDAS
}

// Uso
ItemCardapio item = new ItemCardapio(
    1L, 
    "Churros", 
    "Delicioso churros", 
    4.99, 
    CategoriaCardapio.SOBREMESAS  // Tipo seguro!
);

// Conversão de String para Enum (Aula 14)
String categoriaStr = "BEBIDAS";
CategoriaCardapio categoria = CategoriaCardapio.valueOf(categoriaStr);
```

### ✅ Onde foi usado
- `CategoriaCardapio` - Define categorias válidas do cardápio
- Aula 14: Conversão de String para Enum ao ler CSV

---

## 8. Construtores

### 📖 Teoria
Método especial chamado ao criar um objeto. Inicializa o estado do objeto.

### 💻 Aplicação no Projeto

```java
public class Restaurante {
    private String nome;
    private String endereco;
    
    // Construtor - inicializa o objeto
    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
}

// Uso
Restaurante restaurante = new Restaurante("Florinda", "Av. 123");
```

#### Construtor com Super

```java
public class ItemCardapioBebida extends ItemCardapio {
    
    public ItemCardapioBebida(long id, String nome, String descricao, 
                              double preco, CategoriaCardapio categoria) {
        // Chama o construtor da classe PAI
        super(id, nome, descricao, preco, categoria);
    }
}
```

#### Construtor com Exceções (Aula 14)

```java
public Cardapio(String nomeArquivo) throws IOException {
    // Construtor que pode lançar exceção
    Path arquivo = Path.of(nomeArquivo);
    String conteudo = Files.readString(arquivo);
    // ... parsing
}
```

### ✅ Onde foi usado
- Todas as classes do modelo têm construtores
- Subclasses usam `super()` para chamar construtor do pai
- Aula 14: Construtor do Cardapio com `throws IOException`

---

## 9. Manipulação de Strings

### 📖 Teoria
Strings em Java são objetos **imutáveis** da classe `String` que representam sequências de caracteres.

### 💻 Métodos Principais

**Informações:**
- `length()` - Tamanho da string
- `charAt(index)` - Caractere em uma posição
- `isEmpty()` - Verifica se está vazia

**Verificações:**
- `contains(String)` - Contém substring?
- `startsWith(String)` - Começa com?
- `endsWith(String)` - Termina com?

**Transformações:**
- `toUpperCase()` / `toLowerCase()` - Converte case
- `trim()` / `strip()` - Remove espaços
- `replace(old, new)` - Substitui texto

**Extração:**
- `substring(start, end)` - Extrai substring
- `split(delimiter)` - Divide em array

### 💻 Aplicação na Aula 14 (CSV)

```java
// Leitura do arquivo
String conteudoArquivo = Files.readString(arquivo);

// Divisão em linhas
String[] linhasArquivo = conteudoArquivo.split("\n");

// Para cada linha
String linha = linhasArquivo[i].strip();  // Remove espaços

// Verifica se linha está vazia
if (linha.isEmpty()) {
    continue;
}

// Verifica tipo de arquivo
if (nomeArquivo.endsWith(".csv")) {
    // Divide em colunas (mantém vazias com -1)
    String[] partes = linha.split(";", -1);
}

// Verifica campos vazios
if (descontoStr == null || descontoStr.isBlank()) {
    throw new IOException("Campo obrigatório vazio");
}
```

### ✅ Onde foi usado
- Aula 12: TesteString com métodos básicos
- Aula 13: Comparação de performance (String vs StringBuilder)
- **Aula 14: Parsing de CSV** ⭐

---

## 10. StringBuilder e Performance

### 📖 Teoria
`StringBuilder` é uma classe **mutável** para construção eficiente de strings.

### 💻 Comparação

```java
// ❌ String (cria muitos objetos)
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i + ", ";
}

// ✅ StringBuilder (modifica mesmo objeto)
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(", ");
}
String resultado = sb.toString();
```

### ✅ Onde foi usado
- Aula 13: Teste de performance
- Exercício: Geração de relatórios

---

## 11. Modificador Final

### 📖 Teoria
O modificador `final` impõe restrições de imutabilidade.

### 🎯 Aplicações

**1. Classes final (não podem ser herdadas):**
```java
public final class String { }
```

**2. Atributos final (só podem ser atribuídos uma vez):**
```java
private final double x;
```

**3. Variáveis locais final:**
```java
final double PI = 3.14159;
```

### ✅ Onde foi usado
- Aula 13: Classe `Coordenada` imutável

---

## 12. Classes Imutáveis

### 📖 Teoria
Classe cujos objetos não podem ter estado modificado após criação.

### 📋 Checklist

1. ✅ Classe `final`
2. ✅ Atributos `private final`
3. ✅ Inicialização apenas no construtor
4. ✅ Sem setters
5. ✅ Métodos retornam novos objetos

### 💻 Exemplo

```java
public final class Coordenada {
    private final double x;
    private final double y;
    
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    
    public Coordenada mover(double dx, double dy) {
        return new Coordenada(x + dx, y + dy);
    }
}
```

### ✅ Onde foi usado
- Aula 13: Classe `Coordenada`

---

## 13. Manipulação de Arquivos

### 📖 Teoria
Java oferece APIs modernas para trabalhar com arquivos no pacote `java.nio.file`.

### 💻 Conceitos da Aula 14

#### 1. Path - Representa caminho de arquivo

```java
import java.nio.file.Path;

Path arquivo = Path.of("itens-cardapio.csv");
Path absoluto = Path.of("/home/usuario/dados.csv");
```

#### 2. Files - Operações com arquivos

```java
import java.nio.file.Files;

// Ler arquivo inteiro como String
String conteudo = Files.readString(arquivo);

// Outras operações (não usadas ainda)
boolean existe = Files.exists(arquivo);
long tamanho = Files.size(arquivo);
```

#### 3. Leitura e Parsing

```java
public Cardapio(String nomeArquivo) throws IOException {
    // 1. Criar Path
    Path arquivo = Path.of(nomeArquivo);
    
    // 2. Ler conteúdo
    String conteudoArquivo = Files.readString(arquivo);
    
    // 3. Dividir em linhas
    String[] linhas = conteudoArquivo.split("\n");
    
    // 4. Processar cada linha
    for (String linha : linhas) {
        linha = linha.strip();
        
        if (linha.isEmpty()) {
            continue;
        }
        
        // 5. Dividir em colunas
        String[] partes = linha.split(";", -1);
        
        // 6. Extrair dados
        long id = Long.parseLong(partes[0]);
        String nome = partes[1];
        // ...
    }
}
```

### 🎯 Parsing de Dados

**Conversão de Strings para Tipos Primitivos:**

```java
// String → long
long id = Long.parseLong("123");

// String → double
double preco = Double.parseDouble("4.99");

// String → boolean
boolean ativo = Boolean.parseBoolean("true");

// String → Enum
CategoriaCardapio categoria = CategoriaCardapio.valueOf("BEBIDAS");
```

### ⚠️ Tratamento de Campos Vazios

```java
// split normal: ignora campos vazios no final
String[] partes1 = "1;nome;".split(";");    // 2 elementos

// split com -1: mantém campos vazios
String[] partes2 = "1;nome;".split(";", -1); // 3 elementos

// Verificar se campo está vazio
if (campo == null || campo.isBlank()) {
    // Campo vazio
}
```

### 📊 Formato CSV Usado

```
Coluna 0: id (long)
Coluna 1: nome (String)
Coluna 2: descricao (String)
Coluna 3: preco (double)
Coluna 4: categoria (String → Enum)
Coluna 5: emPromocao (String → boolean)
Coluna 6: precoComDesconto (String → double, pode estar vazio)
Coluna 7: impostoIsento (String → boolean)
Coluna 8: ehSemGluten (String → boolean)
```

### 💡 Validações Implementadas

```java
// 1. Número de colunas
if (partes.length < 9) {
    throw new IOException("Linha CSV inválida: esperado 9 colunas");
}

// 2. Regra de negócio
if (emPromocao && descontoStr.isBlank()) {
    throw new IOException("Item em promoção deve ter desconto");
}

// 3. Tipo de arquivo
if (!nomeArquivo.endsWith(".csv")) {
    System.out.println("Formato inválido");
}
```

### 🎯 Instanciação Dinâmica

```java
ItemCardapio item;

// Escolhe subclasse baseado nos flags
if (impostoIsento) {
    item = new ItemCardapioIsento(...);
} else if (ehSemGluten) {
    item = new ItemCardapioSemGluten(...);
} else if (categoria == CategoriaCardapio.BEBIDAS) {
    item = new ItemCardapioBebida(...);
} else {
    item = new ItemCardapio(...);
}

// Configura promoção se necessário
if (emPromocao) {
    item.setPromocao(precoComDesconto);
}
```

### ✅ Onde foi usado
- **Aula 14: Leitura de CSV completa** ⭐
- Construtor do Cardapio refatorado
- Validação de dados estruturados
- Conversão de tipos

---

## 14. Tratamento de Exceções

### 📖 Teoria
Exceções são eventos anormais que ocorrem durante a execução de um programa. Java oferece mecanismos para tratar esses erros de forma elegante.

### 🎯 IOException

`IOException` é uma **exceção checked** (verificada) que deve ser tratada ou declarada.

**O que é checked exception?**
- Compilador obriga a tratar ou declarar
- Geralmente representa problemas recuperáveis
- Comum em operações de I/O (Input/Output)

### 💻 Declarando Exceção (throws)

```java
public Cardapio(String nomeArquivo) throws IOException {
    // Se algo der errado, lança a exceção
    Path arquivo = Path.of(nomeArquivo);
    String conteudo = Files.readString(arquivo);  // Pode lançar IOException
}
```

**O que `throws` significa:**
- "Este método PODE lançar IOException"
- Quem chamar o método DEVE tratar ou propagar a exceção
- Não trata o erro aqui, passa responsabilidade para cima

### 💻 Lançando Exceção (throw)

```java
if (partes.length < 9) {
    throw new IOException("Linha CSV inválida: esperado 9 colunas, veio " + partes.length);
}

if (emPromocao && descontoStr.isBlank()) {
    throw new IOException("Item em promoção sem desconto");
}
```

**O que `throw` significa:**
- "LANCE esta exceção agora"
- Cria uma nova exceção com mensagem
- Interrompe execução normal do método

### 💻 Tratando Exceção (try-catch)

```java
// No Main (quem chama)
try {
    String nomeArquivo = IO.readln("Digite o nome do arquivo: ");
    Cardapio cardapio = new Cardapio(nomeArquivo);
    // Código continua normalmente
} catch (IOException e) {
    System.out.println("Erro ao ler arquivo: " + e.getMessage());
    // Programa não quebra, tratou o erro
}
```

### 🎯 Diferença: throws vs throw

| `throws` | `throw` |
|----------|---------|
| Na **assinatura do método** | **Dentro do método** |
| **Declara** que pode lançar | **Lança** a exceção |
| `throws IOException` | `throw new IOException()` |
| Pode listar múltiplas | Lança uma por vez |

### 📊 Fluxo de Exceções

```
Main.java
    ↓ chama
Cardapio(String) throws IOException  ← Declara que pode lançar
    ↓ lê arquivo
Files.readString() throws IOException  ← Pode lançar
    ↓ arquivo não existe
IOException é lançada ← throw
    ↓ propaga
volta para Main
    ↓ tratamento
try-catch captura ← catch
    ↓
Programa continua
```

### 💡 Por que usar Exceções?

**Antes (sem exceções):**
```java
public boolean carregarCardapio(String arquivo) {
    // Retorna true/false
    // Como saber O QUE deu errado?
    return false;
}
```

**Depois (com exceções):**
```java
public void carregarCardapio(String arquivo) throws IOException {
    // Lança exceção com mensagem detalhada
    throw new IOException("Arquivo não encontrado: " + arquivo);
}
```

**Vantagens:**
- ✅ Mensagens de erro detalhadas
- ✅ Separa código normal de tratamento de erros
- ✅ Pode capturar em níveis diferentes
- ✅ Stack trace para debug

### 🎯 Tipos de Exceções

**1. Checked (Verificadas):**
- Compilador obriga a tratar
- Exemplo: `IOException`, `FileNotFoundException`
- Problemas recuperáveis

**2. Unchecked (Não Verificadas):**
- Compilador não obriga a tratar
- Exemplo: `NullPointerException`, `ArrayIndexOutOfBoundsException`
- Erros de programação

**3. Errors:**
- Problemas graves do sistema
- Exemplo: `OutOfMemoryError`
- Geralmente não devem ser capturados

### ⚠️ Erros Comuns na Aula 14

**1. Arquivo não encontrado:**
```java
Path arquivo = Path.of("cardapio.csv");  // Arquivo não existe
Files.readString(arquivo);  // IOException: arquivo não encontrado
```

**2. Parsing inválido:**
```java
long id = Long.parseLong("abc");  // NumberFormatException
double preco = Double.parseDouble("R$4.99");  // NumberFormatException
```

**3. Enum inválido:**
```java
CategoriaCardapio.valueOf("LANCHES");  // IllegalArgumentException
```

**4. Array index:**
```java
String[] partes = linha.split(";");  // 2 elementos
String campo = partes[5];  // ArrayIndexOutOfBoundsException
```

### 💻 Exemplo Completo

```java
// Cardapio.java (declara que pode lançar)
public Cardapio(String nomeArquivo) throws IOException {
    try {
        Path arquivo = Path.of(nomeArquivo);
        String conteudo = Files.readString(arquivo);
        
        // ... validações
        if (partes.length < 9) {
            throw new IOException("CSV inválido");  // Lança exceção
        }
        
        // ... parsing pode lançar NumberFormatException (unchecked)
        long id = Long.parseLong(partes[0]);
        
    } catch (NumberFormatException e) {
        // Captura exceção de parsing e relança como IOException
        throw new IOException("Erro ao converter número: " + e.getMessage());
    }
}

// Main.java (trata a exceção)
public static void main(String[] args) {
    try {
        Cardapio cardapio = new Cardapio("itens-cardapio.csv");
        System.out.println("Cardápio carregado!");
    } catch (IOException e) {
        System.out.println("Erro: " + e.getMessage());
        e.printStackTrace();  // Mostra stack trace para debug
    }
}
```

### ✅ Onde foi usado
- **Aula 14: IOException em operações de arquivo** ⭐
- Declaração: `throws IOException` no construtor
- Lançamento: `throw new IOException(...)` nas validações
- Tratamento: `try-catch` no Main (será implementado na Aula 19)

---

## 📊 Resumo de Conceitos por Aula

| Aula | Conceitos Principais |
|------|---------------------|
| Aula 10 | Composição, Encapsulamento, Getters/Setters |
| Aula 11 | Modificador Protected, Geradores IDE |
| Aula 12 | Manipulação de Strings, Comparação (equals) |
| Aula 13 | StringBuilder, Final, Classes Imutáveis |
| **Aula 14** | **Arquivos (Path, Files), Parsing CSV, IOException, Conversão de Tipos** |

---

## 💡 Boas Práticas Aplicadas

1. ✅ **Nomes significativos**: Classes e métodos com nomes descritivos
2. ✅ **Convenções Java**: CamelCase para classes, camelCase para métodos
3. ✅ **Getters/Setters**: Padrão JavaBeans
4. ✅ **Anotação @Override**: Documentar sobrescrita de métodos
5. ✅ **Construtores protected**: Controlar instanciação
6. ✅ **Organização em pacotes**: Separar responsabilidades
7. ✅ **Comparação de Strings**: Sempre usar `equals()`, nunca `==`
8. ✅ **Validação de entrada**: Verificar null e índices antes de acessar
9. ✅ **Imutabilidade**: Entender que métodos String retornam novas strings
10. ✅ **StringBuilder em loops**: Usar para concatenação eficiente
11. ✅ **Final para constantes**: Atributos que não mudam devem ser `final`
12. ✅ **Classes imutáveis**: Usar `final` + atributos `final` para objetos de valor
13. ✅ **Separação dados/lógica**: Dados em arquivos, lógica no código
14. ✅ **Validações robustas**: Verificar estrutura antes de processar
15. ✅ **Exceções descritivas**: Mensagens claras sobre o erro
16. ✅ **split com -1**: Preservar campos vazios no CSV

---

## 📚 Referências

- [Oracle Java Tutorials - OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Oracle Java Tutorials - File I/O](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Oracle Java Tutorials - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Effective Java - Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- Slides e materiais do curso Java Elite - UNIPDS

---

_Documento atualizado em: Fevereiro 2026_
_Última revisão: Aula 14_