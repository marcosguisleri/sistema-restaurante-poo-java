# 🎓 Conceitos de POO Aprendidos

Este documento consolida os **conceitos de Programação Orientada a Objetos (POO)** aplicados no projeto do Restaurante da Dona Florinda.

---

## 📚 Índice Rápido

1. Classes e Objetos
2. Encapsulamento
3. Herança
4. Polimorfismo
5. Composição e Agregação
6. Modificadores de Acesso
7. Enums
8. Interfaces
9. Classes Abstratas
10. Exceções
11. Records
12. Padrões de Design

---

## 1. Classes e Objetos

**Teoria:** Classe = template, Objeto = instância

**Aplicação:**
```java
// Classe
public class Restaurante {
    private String nome;
}

// Objeto
Restaurante restaurante = new Restaurante("Florinda", "Av. 123");
```

**Onde:** `Restaurante`, `Cardapio`, `ItemCardapio`, leitores, etc.

---

## 2. Encapsulamento

**Teoria:** Proteger dados internos, expor via métodos públicos

**Aplicação:**
```java
public class Restaurante {
    private String nome;           // PRIVATE
    
    public String getNome() {      // PUBLIC
        return nome;
    }
}
```

**Benefícios:**
- ✅ Controle de acesso
- ✅ Validação possível
- ✅ Flexibilidade interna

**Onde:** Todas as classes do modelo

---

## 3. Herança

**Teoria:** Reutilizar código, criar hierarquias

**Aplicação:**
```
ItemCardapio (classe base)
├── ItemCardapioBebida (50% imposto)
├── ItemCardapioSemGluten (5% imposto)
└── ItemCardapioIsento (0% imposto)
```

**Código:**
```java
public class ItemCardapioBebida extends ItemCardapio {
    @Override
    public double getImposto() {
        return getPreco() * 0.5;  // 50%
    }
}
```

**Onde:** Hierarquia de itens do cardápio

---

## 4. Polimorfismo

**Teoria:** Mesmo método, comportamentos diferentes

**Tipos:**
- Override (sobrescrita)
- Polimorfismo via interface

**Aplicação:**
```java
ItemCardapio[] itens = new ItemCardapio[3];
itens[0] = new ItemCardapioBebida(...);   // 50%
itens[1] = new ItemCardapioIsento(...);   // 0%
itens[2] = new ItemCardapio(...);         // 10%

for (ItemCardapio item : itens) {
    item.getImposto();  // Chama versão apropriada!
}
```

**Polimorfismo via Interface (Aula 16):**
```java
LeitorItensCardapio leitor;
leitor = new LeitorItensCardapioCSV();    // ou
leitor = new LeitorItensCardapioGSON();   // ou
leitor = new LeitorItensCardapioXML();

leitor.processaArquivo(arquivo);  // Comportamento varia!
```

**Onde:** `getImposto()`, `processaArquivo()`, `ehSemGluten()`

---

## 5. Composição e Agregação

**Composição (HAS-A forte):**
```java
Restaurante ◆─── Cardapio
// Se Restaurante destruído → Cardapio também
```

**Agregação (HAS-A fraca):**
```java
Cardapio ◇─── ItemCardapio[]
// Itens podem existir sem Cardapio
```

**Dependência via Interface:**
```java
Cardapio ────► LeitorItensCardapio (interface)
                      ▲
                      |
          ┌───────────┼───────────┐
          |           |           |
      LeitorCSV  LeitorGSON  LeitorXML
```

**Onde:** Restaurante-Cardapio, Cardapio-Itens, Cardapio-Leitor

---

## 6. Modificadores de Acesso

| Modificador | Classe | Pacote | Subclasse | Global |
|-------------|--------|--------|-----------|--------|
| `private`   | ✅ | ❌ | ❌ | ❌ |
| `default`   | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public`    | ✅ | ✅ | ✅ | ✅ |

**Aplicação:**
```java
public class ItemCardapio {
    private long id;                    // PRIVATE
    protected ItemCardapio(...) {}      // PROTECTED
    public long getId() { return id; }  // PUBLIC
}
```

**Onde:** ItemCardapio (protected constructor), todos os atributos (private)

---

## 7. Enums

**Teoria:** Conjunto fixo de constantes tipadas

**Aplicação:**
```java
public enum CategoriaCardapio {
    ENTRADA,
    PRATOS_PRINCIPAIS,
    SOBREMESAS,
    BEBIDAS
}

// Uso
CategoriaCardapio categoria = CategoriaCardapio.BEBIDAS;

// Conversão String → Enum
categoria = CategoriaCardapio.valueOf("BEBIDAS");
```

**Benefícios:**
- ✅ Tipagem forte
- ✅ Autocomplete
- ✅ Segurança compilação

**Onde:** `CategoriaCardapio`

---

## 8. Interfaces

**Teoria:** Contrato que classes devem implementar

**Aplicação (Aula 16):**
```java
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String arquivo);
    
    static LeitorItensCardapio criaLeitor(String arquivo) {
        if (arquivo.endsWith(".csv")) return new LeitorCSV();
        if (arquivo.endsWith(".json")) return new LeitorGSON();
        if (arquivo.endsWith(".xml")) return new LeitorXML();
        throw new IllegalArgumentException("Extensão inválida");
    }
}
```

**Benefícios:**
- ✅ Define contrato
- ✅ Polimorfismo
- ✅ Desacoplamento
- ✅ Extensibilidade

**Quando usar:**
- ✅ Comportamento comum sem relação "é-um"
- ✅ Múltiplas implementações diferentes
- ✅ Herança múltipla de tipos

**Onde:** `LeitorItensCardapio`

---

## 9. Classes Abstratas

**Teoria:** Classe base com código comum + métodos abstratos

**Aplicação (Aula 17):**
```java
public abstract class LeitorItensCardapioBase implements LeitorItensCardapio {
    
    @Override
    public ItemCardapio[] processaArquivo(String arquivo) {
        // Código COMUM: lê arquivo, split linhas
        Path path = Path.of(arquivo);
        String conteudo = Files.readString(path);
        
        for (String linha : linhas) {
            ItemCardapio item = processaLinha(linha);  // HOOK
        }
    }
    
    // Método ABSTRATO (cada subclasse implementa)
    protected abstract ItemCardapio processaLinha(String linha);
}
```

**Hierarquia:**
```
LeitorItensCardapio (interface)
├── LeitorItensCardapioBase (abstract)
│   └── LeitorItensCardapioCSV (extends Base)
├── LeitorItensCardapioGSON (implements Interface)
└── LeitorItensCardapioXML (implements Interface)
```

**Interface vs Abstrata:**

| Aspecto | Interface | Abstrata |
|---------|-----------|----------|
| Métodos concretos | ⚠️ Só default/static | ✅ Sim |
| Atributos | ❌ Só constantes | ✅ Sim |
| Construtor | ❌ Não | ✅ Sim |
| Herança múltipla | ✅ implements múltiplos | ❌ extends 1 |
| Uso | Contrato | Código comum |

**Quando usar abstrata:**
- ✅ Código comum reutilizável
- ✅ Relação "é-um"
- ✅ Atributos necessários

**Onde:** `LeitorItensCardapioBase`

---

## 10. Exceções

**Teoria:** Tratar erros elegantemente

**Exceção Customizada (Aula 19):**
```java
public class FlorindaException extends RuntimeException {
    public FlorindaException(String message) {
        super(message);
    }
}
```

**Uso:**
```java
public ItemCardapio(...) throws FlorindaException {
    if (preco < 0) {
        throw new FlorindaException("Preço negativo: " + preco);
    }
    if (descricao == null || descricao.isBlank()) {
        throw new FlorindaException("Descrição vazia");
    }
}
```

**Checked vs Unchecked:**

| Tipo | Extends | Obriga try-catch | Uso |
|------|---------|------------------|-----|
| Checked | `Exception` | ✅ Sim | Problemas recuperáveis |
| Unchecked | `RuntimeException` | ❌ Não | Erros programação |

**Por que RuntimeException?**
- ✅ Não obriga try-catch
- ✅ Erros de validação/programação
- ✅ Não esperamos recuperação

**Onde:** `FlorindaException`, validações em `ItemCardapio`

---

## 11. Records (Aula 18)

**Teoria:** Classes imutáveis automáticas (Java 14+)

**Aplicação:**
```java
public record ItemCardapioJsonDTO(
    long id,
    String nome,
    String descricao,
    double preco,
    String categoria,
    boolean emPromocao,
    Double precoComDesconto,  // Wrapper: permite null
    boolean impostoIsento,
    boolean semGluten
) {}
```

**O que Record gera automaticamente:**
- ✅ Constructor
- ✅ Getters (nome(), preco(), etc.)
- ✅ equals() e hashCode()
- ✅ toString()
- ✅ Imutabilidade (final fields)

**Equivalente manual = ~50 linhas vs 1 linha!**

**Por que Wrapper `Double`?**
- `double` primitivo: não pode ser null
- `Double` wrapper: pode ser null
- JSON: `"precoComDesconto": null` → precisa wrapper

**Onde:** `ItemCardapioJsonDTO`

---

## 12. Padrões de Design

### Factory Method Pattern (Aula 16)

**Problema:** Cliente não deve saber qual classe instanciar

**Solução:**
```java
// Static factory method na interface
static LeitorItensCardapio criaLeitor(String arquivo) {
    if (arquivo.endsWith(".csv")) return new LeitorCSV();
    if (arquivo.endsWith(".json")) return new LeitorGSON();
    if (arquivo.endsWith(".xml")) return new LeitorXML();
    throw new IllegalArgumentException("Extensão inválida");
}

// Uso
LeitorItensCardapio leitor = LeitorItensCardapio.criaLeitor(arquivo);
```

**Benefícios:**
- ✅ Centraliza criação
- ✅ Cliente não conhece classes concretas
- ✅ Fácil adicionar tipos

---

### Template Method Pattern (Aula 17)

**Problema:** Código comum + variações específicas

**Solução:**
```java
abstract class LeitorBase {
    // Template method (concreto)
    public ItemCardapio[] processaArquivo(String arquivo) {
        // 1. Código COMUM
        String conteudo = Files.readString(Path.of(arquivo));
        
        // 2. Código COMUM
        String[] linhas = conteudo.split("\n");
        
        // 3. Hook method (abstrato - varia)
        processaLinha(linha);
    }
    
    // Hook method
    protected abstract ItemCardapio processaLinha(String linha);
}
```

**Benefícios:**
- ✅ Reutiliza código comum
- ✅ Customiza onde necessário
- ✅ Evita duplicação

---

### Strategy Pattern (Aula 16)

**Problema:** Trocar algoritmo em runtime

**Solução:**
```java
// Interface define estratégia
interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String arquivo);
}

// Estratégias concretas
class LeitorCSV implements LeitorItensCardapio { ... }
class LeitorJSON implements LeitorItensCardapio { ... }

// Uso (troca estratégia)
LeitorItensCardapio leitor = criaLeitor(arquivo);
itens = leitor.processaArquivo(arquivo);  // Comportamento varia
```

**Benefícios:**
- ✅ Algoritmos intercambiáveis
- ✅ Sem if/else no cliente
- ✅ Open/Closed Principle

---

### DTO Pattern (Aula 18)

**Problema:** Separar formato de dados do domínio

**Solução:**
```java
// DTO (formato JSON)
record ItemCardapioJsonDTO(
    Double precoComDesconto  // null permitido
) {}

// Domínio
class ItemCardapio {
    private double precoComDesconto;  // 0.0 se não em promoção
}

// Conversão DTO → Domínio
ItemCardapioJsonDTO dto = ...;
if (dto.precoComDesconto() != null) {
    item.setPromocao(dto.precoComDesconto());
}
```

**Benefícios:**
- ✅ Separa formato externo de lógica interna
- ✅ Validações no domínio
- ✅ Flexibilidade para mudar JSON

---

## 🎯 SOLID Principles Aplicados

### Single Responsibility (Aula 16)
**Antes:** Cardapio fazia tudo (ler + parsear CSV + parsear JSON)  
**Depois:** Cardapio coordena, leitores parseiam

### Open/Closed (Aula 16)
**Adicionar XML:** Criar `LeitorXML`, atualizar factory  
**Código existente:** ZERO mudanças

### Liskov Substitution
Qualquer `LeitorItensCardapio` pode substituir outro

### Interface Segregation
Interface `LeitorItensCardapio` tem 1 método (enxuta)

### Dependency Inversion (Aula 16)
**Antes:** `Cardapio` dependia de `LeitorCSV`, `LeitorJSON` (concreto)  
**Depois:** `Cardapio` depende de `LeitorItensCardapio` (interface)

---

## 📊 Resumo por Aula

| Aula | Conceitos |
|------|-----------|
| 10 | Composição, Encapsulamento |
| 11 | Protected |
| 12 | Strings |
| 13 | StringBuilder, Final |
| 14 | Arquivos, CSV, IOException |
| 15 | JSON manual, Regex |
| 16 | **Interfaces, Refatoração, Factory** ⭐ |
| 17 | **Classes Abstratas, Template Method** ⭐ |
| 18 | **Records, GSON, Wrappers** ⭐ |
| 19 | **Exceções Customizadas** ⭐ |

---

## 💡 Quando Usar Cada Conceito

**Interface:**
- Contrato entre componentes
- Múltiplas implementações diferentes
- Sem código comum

**Classe Abstrata:**
- Código comum + variações
- Relação "é-um"
- Atributos/construtores necessários

**Herança:**
- Relação "é-um" clara
- Reutilizar implementação base
- Especialização de comportamento

**Composição:**
- Relação "tem-um"
- Flexibilidade > herança
- Evitar hierarquias profundas

**Records:**
- DTOs
- Objetos de valor
- Dados imutáveis

**Exceptions:**
- RuntimeException: validações, erros programação
- Checked: problemas recuperáveis

---

_Documento atualizado em: Fevereiro 2026_  
_Projeto: 100% Concluído ✅_  
_Total: 20+ conceitos POO aplicados_