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

## 10. StringBuilder e Performance

### 📖 Teoria
`StringBuilder` é uma classe **mutável** projetada para construção eficiente de strings, especialmente em loops. Diferente de `String`, que é imutável, o `StringBuilder` pode ser modificado sem criar novos objetos a cada operação.

### 🎯 Problema da Concatenação com String

```java
// ❌ INEFICIENTE - Cria MUITOS objetos
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i + ", ";  // Cada += cria um NOVO objeto String
}
// Milhares de objetos criados e descartados!
```

**O que acontece internamente:**
1. Cria novo objeto String
2. Copia conteúdo antigo + novo
3. Descarta objeto anterior
4. Repete 1000 vezes!

### 💻 Solução com StringBuilder

```java
// ✅ EFICIENTE - Modifica o MESMO objeto
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(", ");  // Adiciona ao mesmo objeto
}
String resultado = sb.toString();  // Converte para String no final
```

### 📊 Teste de Performance (Aula 13)

```java
// String (LENTO)
long inicio = System.currentTimeMillis();
String teste = "";
for (int i = 0; i < 1_000; i++) {
    teste += i + ", ";
}
long fim = System.currentTimeMillis();
System.out.println("Tempo String: " + (fim - inicio));  // 4-6 ms

// StringBuilder (RÁPIDO)
long inicioSB = System.currentTimeMillis();
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 1_000; i++) {
    builder.append(i).append(", ");
}
long fimSB = System.currentTimeMillis();
System.out.println("Tempo StringBuilder: " + (fimSB - inicioSB));  // 0-1 ms
```

**Resultado:** StringBuilder é **4-6x mais rápido**!

### 🎯 Métodos Principais

```java
StringBuilder sb = new StringBuilder();

sb.append("texto");          // Adiciona ao final
sb.append(123);              // Adiciona número
sb.insert(0, "início ");     // Insere em posição específica
sb.delete(0, 7);             // Remove caracteres
sb.reverse();                // Inverte a string
sb.length();                 // Tamanho atual
sb.toString();               // Converte para String
```

### 🔍 StringBuilder vs StringBuffer

| Característica | StringBuilder | StringBuffer |
|----------------|---------------|--------------|
| **Thread-safe** | ❌ Não | ✅ Sim |
| **Performance** | ✅ Mais rápido | Mais lento |
| **Quando usar** | Uso normal | Multi-threading |

**Recomendação:** Use `StringBuilder` (mais rápido) a menos que precise de sincronização (thread-safe).

### ✅ Onde foi usado
- `TesteString.java` - Comparação de performance
- Exercício 1 - Método `relatorioComStringBuilder()`

---

## 11. Modificador Final

### 📖 Teoria
O modificador `final` impõe restrições que tornam o código mais seguro e previsível. Seu comportamento varia conforme onde é aplicado:

### 🎯 1. Final em Classes

Uma classe `final` **não pode ser herdada**.

```java
public final class String {
    // Ninguém pode fazer: class MinhaString extends String
}

public final class Coordenada {
    // Classe imutável que não pode ser estendida
}

// ❌ ERRO DE COMPILAÇÃO
public class CoordenadaTridimensional extends Coordenada {
    // Cannot inherit from final 'Coordenada'
}
```

**Quando usar:**
- Classes que não devem ser estendidas por segurança
- Classes imutáveis (como String)
- Classes de utilitários

### 🎯 2. Final em Atributos

Um atributo `final` só pode ser atribuído **UMA vez**, na declaração ou no construtor.

```java
public class Coordenada {
    private final double x;  // Só pode ser definido uma vez
    private final double y;
    
    public Coordenada(double x, double y) {
        this.x = x;  // ✅ Atribuição no construtor
        this.y = y;  // ✅ Atribuição no construtor
    }
    
    public void mover(double novoX) {
        // this.x = novoX;  // ❌ ERRO! Não pode reatribuir
    }
    
    // ✅ Apenas getters (sem setters)
    public double getX() { return x; }
    public double getY() { return y; }
}
```

**Quando usar:**
- Constantes
- Valores que não devem mudar após criação do objeto
- Classes imutáveis

### 🎯 3. Final em Variáveis Locais

```java
void calcular() {
    final double PI = 3.14159;  // Constante local
    final int MAX_TENTATIVAS = 3;
    
    // PI = 3.14;  // ❌ ERRO! Não pode reatribuir
    
    for (final int i = 0; i < 10; i++) {  // ✅ Válido
        // i = 5;  // ❌ ERRO dentro do loop
    }
}
```

**Quando usar:**
- Constantes locais
- Parâmetros que não devem ser modificados
- Variáveis de loop (menos comum)

### ⚠️ Final vs Imutabilidade

**IMPORTANTE:** `final` não torna o objeto imutável, apenas a referência!

```java
final StringBuilder sb = new StringBuilder("Oi");
sb.append(" mundo");  // ✅ OK! O conteúdo pode mudar
IO.println(sb);       // "Oi mundo"

sb = new StringBuilder();  // ❌ ERRO! A referência não pode mudar

final List<String> lista = new ArrayList<>();
lista.add("item");    // ✅ OK! O conteúdo pode mudar
lista = new ArrayList<>();  // ❌ ERRO! A referência não pode mudar
```

### 💻 Aplicação no Projeto

**Exercício 2 - Classe Coordenada:**
```java
public final class Coordenada {  // ← classe final
    private final double x;      // ← atributos final
    private final double y;
    
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
```

### ✅ Onde foi usado
- Exercício 2 - Classe `Coordenada` (final class + final attributes)

---

## 12. Classes Imutáveis

### 📖 Teoria
Uma **classe imutável** é aquela cujos objetos não podem ter seu estado modificado após a criação. Uma vez criado, o objeto permanece exatamente como foi inicializado.

### 🎯 Benefícios

- ✅ **Thread-safe**: Seguro em ambientes concorrentes (não precisa sincronização)
- ✅ **Cacheable**: Pode ser compartilhado livremente
- ✅ **Simples**: Sem efeitos colaterais inesperados
- ✅ **Confiável**: Estado previsível

### 📋 Checklist para Criar Classe Imutável

1. ✅ Declare a classe como `final` (não pode ser herdada)
2. ✅ Todos os atributos `private final`
3. ✅ Inicialize atributos apenas no construtor
4. ✅ **Sem setters** (apenas getters)
5. ✅ Métodos que "modificam" retornam novos objetos

### 💻 Exemplo Completo - Classe Coordenada

```java
// 1. Classe final
public final class Coordenada {
    
    // 2. Atributos private final
    private final double x;
    private final double y;
    
    // 3. Inicialização apenas no construtor
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // 4. Apenas getters (sem setters!)
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    // 5. Métodos retornam novos objetos
    public Coordenada mover(double deltaX, double deltaY) {
        return new Coordenada(this.x + deltaX, this.y + deltaY);
    }
    
    public double distancia(Coordenada outra) {
        double dx = outra.x - this.x;
        double dy = outra.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
```

### 🎯 Uso da Classe Imutável

```java
Coordenada c1 = new Coordenada(2, 3);
Coordenada c2 = c1.mover(3, 4);  // Retorna NOVA coordenada

System.out.println(c1);  // (2, 3) - original não mudou!
System.out.println(c2);  // (5, 7) - novo objeto

double dist = c1.distancia(c2);
System.out.println("Distância: " + dist);
```

### 📊 Exemplos de Classes Imutáveis em Java

| Classe | Descrição |
|--------|-----------|
| `String` | Texto imutável |
| `Integer`, `Double`, etc. | Wrappers de primitivos |
| `LocalDate`, `LocalTime` | Datas e horas (Java 8+) |
| `BigDecimal` | Números decimais precisos |

### ⚠️ Cuidado com Objetos Mutáveis

```java
public final class Pessoa {
    private final String nome;
    private final List<String> hobbies;  // ⚠️ List é mutável!
    
    public Pessoa(String nome, List<String> hobbies) {
        this.nome = nome;
        // ❌ ERRADO: guarda referência direta
        this.hobbies = hobbies;
        
        // ✅ CORRETO: cria cópia defensiva
        this.hobbies = new ArrayList<>(hobbies);
    }
    
    public List<String> getHobbies() {
        // ❌ ERRADO: expõe lista interna
        return hobbies;
        
        // ✅ CORRETO: retorna cópia
        return new ArrayList<>(hobbies);
    }
}
```

### 🎯 Quando Usar Classes Imutáveis

**Use para:**
- ✅ Objetos de valor (coordenadas, dinheiro, datas)
- ✅ Objetos de domínio simples
- ✅ Chaves de HashMap/HashSet
- ✅ Dados que não mudam (configurações, constantes)

**Não use para:**
- ❌ Objetos com estado que muda frequentemente
- ❌ Entidades de banco de dados (geralmente mutáveis)
- ❌ Builders e configuradores

### ✅ Onde foi usado
- Exercício 2 - Classe `Coordenada` (exemplo completo de classe imutável)

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
10. ✅ **StringBuilder em loops**: Usar para concatenação eficiente
11. ✅ **Final para constantes**: Atributos que não mudam devem ser `final`
12. ✅ **Classes imutáveis**: Usar `final` + atributos `final` para objetos de valor

---

## 📚 Referências

- [Oracle Java Tutorials - OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Effective Java - Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- Slides e materiais do curso Java Elite - UNIPDS

---

_Documento atualizado em: Fevereiro 2026_
_Última revisão: Aula 13_