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
    
    // DEFAULT (package-private) - Acessível no pacote mx.florinda.modelo
    ItemCardapio(long id, String nome, ...) {
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
- **Construtores**: `default` (controlar criação dentro do pacote)
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

// Evita erros como:
// categoria = "sobremesa"  // Erro de digitação
// categoria = "DOCES"      // Categoria inválida
```

### ✅ Onde foi usado
- `CategoriaCardapio` - Define categorias válidas do cardápio

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

### ✅ Onde foi usado
- Todas as classes do modelo têm construtores
- Subclasses usam `super()` para chamar construtor do pai

---

## 📊 Resumo de Conceitos por Classe/Tópico

| Classe/Tópico | Encapsulamento | Herança | Polimorfismo | Composição | Enum | String |
|---------------|----------------|---------|--------------|------------|------|--------|
| `Restaurante` | ✅ | ❌ | ❌ | ✅ (tem Cardapio) | ❌ | ❌ |
| `Cardapio` | ✅ | ❌ | ❌ | ✅ (tem ItemCardapio[]) | ❌ | ❌ |
| `ItemCardapio` | ✅ | ✅ (pai) | ✅ | ❌ | ✅ (usa CategoriaCardapio) | ❌ |
| `ItemCardapioBebida` | ✅ | ✅ (filho) | ✅ (override) | ❌ | ❌ | ❌ |
| `ItemCardapioIsento` | ✅ | ✅ (filho) | ✅ (override) | ❌ | ❌ | ❌ |
| `ItemCardapioSemGluten` | ✅ | ✅ (filho) | ✅ (override) | ❌ | ❌ | ❌ |
| `CategoriaCardapio` | ❌ | ❌ | ❌ | ❌ | ✅ (é enum) | ❌ |
| `TesteString` | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ (manipulação) |
| Exercícios Aula 12 | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ (validação) |

---

## 🎯 Princípios SOLID Aplicados

### Single Responsibility (Responsabilidade Única)
- ✅ Cada classe tem uma responsabilidade clara
  - `Restaurante` - Gerencia dados do restaurante
  - `Cardapio` - Gerencia coleção de itens
  - `ItemCardapio` - Representa um item individual

### Open/Closed (Aberto/Fechado)
- ✅ Fácil adicionar novos tipos de itens sem modificar código existente
  - Criar nova subclasse de `ItemCardapio`

### Liskov Substitution (Substituição de Liskov)
- ✅ Subclasses podem substituir classe pai sem quebrar o código
  - `ItemCardapioBebida` pode ser usado onde `ItemCardapio` é esperado

---

## 9. Manipulação de Strings

### 📖 Teoria
Strings em Java são objetos **imutáveis** da classe `String` que representam sequências de caracteres. Isso significa que qualquer operação que "modifica" uma string na verdade cria uma nova string.

### 🎯 Imutabilidade

```java
String nome = "Refresco";
String nomeMaiusculo = nome.toUpperCase();

IO.println(nome);           // "Refresco" (original não mudou!)
IO.println(nomeMaiusculo);  // "REFRESCO" (nova string criada)
```

**Por que imutáveis?**
- ✅ Segurança em multithreading
- ✅ Pool de strings (economia de memória)
- ✅ Strings podem ser usadas como chaves em HashMap
- ✅ Segurança (não podem ser alteradas após criação)

### 💻 Aplicação no Projeto

**Classe TesteString.java:**
```java
String nomeItem1 = "Refresco do Chaves";

// Informações
nomeItem1.length();        // 18
nomeItem1.charAt(0);       // 'R'
nomeItem1.isEmpty();       // false

// Verificações
nomeItem1.contains("Chaves");      // true
nomeItem1.startsWith("Refresco");  // true
nomeItem1.endsWith("Chaves");      // true

// Divisão
String[] pedacos = nomeItem1.split(" ");
// ["Refresco", "do", "Chaves"]

// Transformações
nomeItem1.toUpperCase();              // "REFRESCO DO CHAVES"
nomeItem1.toLowerCase();              // "refresco do chaves"
nomeItem1.replace(" ", "-");          // "Refresco-do-Chaves"
nomeItem1.substring(0, 8);            // "Refresco"
nomeItem1.substring(12);              // "Chaves"
nomeItem1.trim();                     // Remove espaços nas extremidades
nomeItem1.concat(" gelado");          // "Refresco do Chaves gelado"
```

### ⚠️ Comparação de Strings - MUITO IMPORTANTE!

```java
String digitado = IO.readln("Digite: ");

// ❌ ERRADO - Compara referências, não conteúdo
if (nomeItem1 == digitado) { ... }

// ✅ CORRETO - Compara conteúdo (case-sensitive)
if (nomeItem1.equals(digitado)) { ... }

// ✅ CORRETO - Compara conteúdo (ignora maiúsculas/minúsculas)
if (nomeItem1.equalsIgnoreCase(digitado)) { ... }
```

**Por que não usar `==`?**
- `==` compara **referências** (endereços de memória)
- `equals()` compara **conteúdo** (caracteres)

### 🎯 Métodos Principais Categorizados

**Informações:**
- `length()` - Tamanho da string
- `charAt(int index)` - Caractere em determinada posição
- `isEmpty()` - Verifica se está vazia

**Verificações:**
- `contains(CharSequence s)` - Contém substring?
- `startsWith(String prefix)` - Começa com?
- `endsWith(String suffix)` - Termina com?

**Comparações:**
- `equals(Object obj)` - Conteúdo igual? (case-sensitive)
- `equalsIgnoreCase(String another)` - Conteúdo igual? (case-insensitive)
- `compareTo(String another)` - Comparação lexicográfica

**Transformações:**
- `toUpperCase()` - Converte para maiúsculas
- `toLowerCase()` - Converte para minúsculas
- `trim()` - Remove espaços nas extremidades
- `replace(char old, char new)` - Substitui caracteres
- `concat(String str)` - Concatena strings

**Extração:**
- `substring(int begin)` - Do índice até o final
- `substring(int begin, int end)` - Entre índices
- `split(String regex)` - Divide em array
- `toCharArray()` - Converte para array de chars

### 💡 Casos de Uso no Projeto

**1. Processamento de Nomes (Exercício 1):**
```java
String nomeCompleto = "João da Silva";
String[] partes = nomeCompleto.split(" ");
String saudacao = "Olá, " + partes[0] + " " + partes[partes.length - 1];
// "Olá, João Silva"
```

**2. Validação de URL (Exercício 2):**
```java
String url = "https://exemplo.com.br";
boolean inicioValido = url.startsWith("http://") || 
                       url.startsWith("https://") || 
                       url.startsWith("HTTP://");
boolean fimValido = url.endsWith(".com") || url.endsWith(".com.br");
// URL válida se ambos forem true
```

**3. Geração de Slugs:**
```java
String nomeItem = "Refresco do Chaves";
String slug = nomeItem.toLowerCase().replace(" ", "-");
// "refresco-do-chaves"
```

**4. Formatação de Exibição:**
```java
String nome = "   Churros   ";
String limpo = nome.trim();  // "Churros"
```

### 🔍 Armadilhas Comuns

**1. NullPointerException:**
```java
String nome = null;
nome.length();  // ❌ ERRO! NullPointerException

// ✅ CORRETO: Sempre verifique null primeiro
if (nome != null && nome.length() > 0) { ... }
```

**2. IndexOutOfBoundsException:**
```java
String texto = "ABC";
char c = texto.charAt(5);  // ❌ ERRO! Índice não existe

// ✅ CORRETO: Verifique o tamanho primeiro
if (index < texto.length()) {
    char c = texto.charAt(index);
}
```

**3. split() com array vazio:**
```java
String nome = "João";
String[] partes = nome.split(" ");
String sobrenome = partes[1];  // ❌ ERRO! Pode não existir

// ✅ CORRETO: Verifique o tamanho do array
if (partes.length > 1) {
    String sobrenome = partes[partes.length - 1];
}
```

### ✅ Onde foi usado
- `TesteString.java` - Demonstração de todos os métodos
- Exercício 1 - Processador de Nomes com `split()`
- Exercício 2 - Validador de URL com `startsWith()` e `endsWith()`
- Possíveis aplicações futuras: validação de entrada, formatação de dados

---

## 💡 Boas Práticas Aplicadas

1. ✅ **Nomes significativos**: Classes e métodos com nomes descritivos
2. ✅ **Convenções Java**: CamelCase para classes, camelCase para métodos
3. ✅ **Getters/Setters**: Padrão JavaBeans
4. ✅ **Anotação @Override**: Documentar sobrescrita de métodos
5. ✅ **Construtores package-private**: Controlar instanciação
6. ✅ **Organização em pacotes**: Separar responsabilidades
7. ✅ **Comparação de Strings**: Sempre usar `equals()`, nunca `==`
8. ✅ **Validação de entrada**: Verificar null e índices antes de acessar
9. ✅ **Imutabilidade**: Entender que métodos String retornam novas strings

---

## 📚 Referências

- [Oracle Java Tutorials - OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Effective Java - Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- Slides e materiais do curso Java Elite - UNIPDS

---

_Documento atualizado em: Fevereiro 2026_
_Última revisão: Aula 12_