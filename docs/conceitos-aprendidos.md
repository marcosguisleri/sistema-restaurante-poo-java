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
15. [Parsing de JSON](#15-parsing-de-json)
16. [Interfaces](#16-interfaces)
17. [Refatoração](#17-refatoração)
18. [Factory Pattern](#18-factory-pattern)

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
- **Aula 16:** Classes leitoras (`LeitorItensCardapioCSV`, `LeitorItensCardapioJSON`) e fábrica (`FabricaLeitorItensCardapio`)

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
- **Aula 16:** Lógica de parsing encapsulada nas classes leitoras

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

#### Polimorfismo com Interfaces (Aula 16) ⭐

```java
// Interface define o contrato
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
}

// Diferentes implementações
LeitorItensCardapio leitorCSV = new LeitorItensCardapioCSV();
LeitorItensCardapio leitorJSON = new LeitorItensCardapioJSON();

// Polimorfismo: mesma variável, comportamentos diferentes
LeitorItensCardapio leitor;

if (nomeArquivo.endsWith(".csv")) {
    leitor = new LeitorItensCardapioCSV();
} else {
    leitor = new LeitorItensCardapioJSON();
}

// Chama o método apropriado baseado no tipo real do objeto
ItemCardapio[] itens = leitor.processaArquivo(nomeArquivo);
```

### ✅ Onde foi usado
- `getImposto()` - Calculado diferentemente em cada tipo de item
- `ehSemGluten()` - Retorna `true` apenas em `ItemCardapioSemGluten`
- **Aula 16:** `processaArquivo()` - Implementado diferentemente em cada leitor ⭐

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

#### Uso de Interfaces (Aula 16)

```java
public class FabricaLeitorItensCardapio {
    // Usa a interface, não a implementação concreta
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        LeitorItensCardapio leitor = null;
        
        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCSV();
        } else if (nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioJSON();
        }
        
        return leitor;
    }
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

Dependência via Interface (Aula 16):
Cardapio ────────► LeitorItensCardapio (interface)
                         ▲
                         |
                   ┌─────┴─────┐
                   |           |
          LeitorCSV    LeitorJSON
```

### ✅ Onde foi usado
- `Restaurante` **compõe** `Cardapio`
- `Cardapio` **agrega** `ItemCardapio[]`
- **Aula 16:** `Cardapio` **usa** `LeitorItensCardapio` (interface)

---

[Seções 6-15 permanecem inalteradas...]

## 16. Interfaces

### 📖 Teoria
Interface é um **contrato** que define métodos que uma classe deve implementar, sem especificar como. É uma forma de estabelecer um **comportamento comum** entre classes não relacionadas por herança.

### 🎯 Características das Interfaces

**O que uma interface TEM:**
- ✅ Métodos abstratos (sem corpo)
- ✅ Constantes (public static final)
- ✅ Métodos default (com implementação - Java 8+)
- ✅ Métodos static (com implementação - Java 8+)

**O que uma interface NÃO TEM:**
- ❌ Atributos de instância
- ❌ Construtores
- ❌ Métodos privados (antes do Java 9)
- ❌ Estado mutável

### 💻 Aplicação na Aula 16

#### 1. Declaração da Interface

```java
package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;
import java.io.IOException;

public interface LeitorItensCardapio {
    
    // Método abstrato (implicitamente public abstract)
    public abstract ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
    
}
```

**Nota:** Em interfaces, os modificadores `public abstract` são **opcionais** pois são implícitos:

```java
// Estas três declarações são IDÊNTICAS:
public abstract ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
```

#### 2. Implementação da Interface - CSV

```java
package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;
import java.io.IOException;

public class LeitorItensCardapioCSV implements LeitorItensCardapio {
    
    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Implementação específica para CSV
        Path arquivo = Path.of(nomeArquivo);
        String conteudo = Files.readString(arquivo);
        
        // ... lógica de parsing CSV ...
        
        return itens;
    }
}
```

#### 3. Implementação da Interface - JSON

```java
package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;
import java.io.IOException;

public class LeitorItensCardapioJSON implements LeitorItensCardapio {
    
    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Implementação específica para JSON
        Path arquivo = Path.of(nomeArquivo);
        String conteudo = Files.readString(arquivo);
        
        // ... lógica de parsing JSON ...
        
        return itens;
    }
}
```

### 🎯 Benefícios das Interfaces

**1. Contrato Claro:**
```java
// Qualquer classe que implemente esta interface DEVE ter este método
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
}
```

**2. Polimorfismo:**
```java
// Variável do tipo interface pode referenciar qualquer implementação
LeitorItensCardapio leitor;

if (formato.equals("csv")) {
    leitor = new LeitorItensCardapioCSV();
} else {
    leitor = new LeitorItensCardapioJSON();
}

// Chama o método apropriado baseado no objeto real
ItemCardapio[] itens = leitor.processaArquivo(arquivo);
```

**3. Desacoplamento:**
```java
// Código depende da interface, não da implementação concreta
public class Cardapio {
    public Cardapio(String nomeArquivo) {
        LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(nomeArquivo);
        // Não importa se é CSV ou JSON!
        itens = leitor.processaArquivo(nomeArquivo);
    }
}
```

**4. Extensibilidade:**
```java
// Fácil adicionar novos formatos sem modificar código existente
public class LeitorItensCardapioXML implements LeitorItensCardapio {
    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Nova implementação para XML
        // Resto do código continua funcionando!
    }
}
```

### 📊 Interface vs Classe Abstrata

| Aspecto | Interface | Classe Abstrata |
|---------|-----------|-----------------|
| Herança múltipla | ✅ Sim (implements múltiplos) | ❌ Não (extends apenas 1) |
| Atributos de instância | ❌ Não | ✅ Sim |
| Construtores | ❌ Não | ✅ Sim |
| Métodos concretos | ⚠️ Só default/static | ✅ Sim |
| Uso típico | Comportamento comum | Classe base comum |
| Palavra-chave | `implements` | `extends` |

### 💡 Quando usar Interface?

**Use INTERFACE quando:**
- ✅ Definir um **contrato/comportamento** comum
- ✅ Não há relacionamento "É-UM" natural entre classes
- ✅ Precisa de herança múltipla de tipos
- ✅ Quer garantir que classes não relacionadas tenham os mesmos métodos

**Exemplos do projeto:**
- `LeitorItensCardapio` - Define comportamento de leitura
- `LeitorItensCardapioCSV` e `LeitorItensCardapioJSON` não têm relação de herança entre si
- Ambos **implementam** o mesmo comportamento (ler e processar arquivo)

**Use CLASSE ABSTRATA quando:**
- ✅ Há relacionamento "É-UM" claro
- ✅ Precisa compartilhar código entre subclasses
- ✅ Precisa de atributos de instância
- ✅ Precisa de construtores

**Exemplo do projeto:**
- `ItemCardapio` (classe abstrata seria apropriada)
- `ItemCardapioBebida`, `ItemCardapioIsento` **são** tipos de `ItemCardapio`
- Compartilham atributos (id, nome, preço) e comportamento comum

### ✅ Onde foi usado
- **Aula 16: Interface `LeitorItensCardapio`** ⭐
- Define contrato para leitores de arquivo
- Implementada por `LeitorItensCardapioCSV` e `LeitorItensCardapioJSON`
- Permite polimorfismo e desacoplamento no `Cardapio`

---

## 17. Refatoração

### 📖 Teoria
Refatoração é o processo de **reestruturar código existente** sem alterar seu comportamento externo. O objetivo é melhorar a qualidade interna do código: legibilidade, manutenibilidade e extensibilidade.

### 🎯 Princípios da Refatoração

**Quando refatorar:**
- ✅ Código duplicado
- ✅ Métodos muito longos
- ✅ Classes com muitas responsabilidades
- ✅ Código difícil de testar
- ✅ Necessidade de adicionar novas funcionalidades

**Como refatorar:**
1. Identifique o problema (code smell)
2. Escolha a técnica de refatoração
3. Faça pequenas mudanças incrementais
4. Teste após cada mudança
5. Commite frequentemente

### 💻 Aplicação na Aula 16

#### ANTES da Refatoração (Aula 15)

```java
public class Cardapio {
    private ItemCardapio[] itens;
    
    public Cardapio(String nomeArquivo) throws IOException {
        Path arquivo = Path.of(nomeArquivo);
        String conteudo = Files.readString(arquivo);
        String[] linhas = conteudo.split("\n");
        itens = new ItemCardapio[linhas.length];
        
        for (int i = 0; i < linhas.length; i++) {
            String linha = linhas[i].strip();
            
            if (linha.isEmpty()) {
                continue;
            }
            
            if (nomeArquivo.endsWith(".csv")) {
                // 50+ linhas de código de parsing CSV
                // ...
            } else if (nomeArquivo.endsWith(".json")) {
                // 60+ linhas de código de parsing JSON
                // ...
            } else {
                System.out.println("Formato inválido");
            }
        }
    }
}
```

**Problemas identificados:**
- ❌ Método construtor muito longo (~120 linhas)
- ❌ Múltiplas responsabilidades (criar cardápio + ler arquivo + parsear CSV + parsear JSON)
- ❌ Violação do Single Responsibility Principle
- ❌ Difícil de testar individualmente
- ❌ Difícil adicionar novos formatos
- ❌ Lógica de parsing duplicada (estrutura similar para CSV e JSON)

#### DEPOIS da Refatoração (Aula 16) ⭐

```java
public class Cardapio {
    private ItemCardapio[] itens;
    
    public Cardapio(String nomeArquivo) throws Exception {
        // Única responsabilidade: coordenar a criação do cardápio
        FabricaLeitorItensCardapio fabricaLeitor = new FabricaLeitorItensCardapio();
        LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(nomeArquivo);
        
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        } else {
            IO.println("O nome/extensão do arquivo é inválido(a) - " + nomeArquivo);
            itens = new ItemCardapio[0];
        }
    }
}
```

**Melhorias alcançadas:**
- ✅ Construtor reduzido de ~120 para ~10 linhas
- ✅ Responsabilidade única: criar cardápio
- ✅ Lógica de parsing movida para classes especializadas
- ✅ Fácil adicionar novos formatos (só criar nova classe leitora)
- ✅ Cada classe pode ser testada independentemente
- ✅ Código mais legível e manutenível

### 🔄 Técnicas de Refatoração Aplicadas

#### 1. Extract Class (Extrair Classe)

**Antes:**
```java
// Tudo em uma classe
public class Cardapio {
    // parsing CSV aqui
    // parsing JSON aqui
}
```

**Depois:**
```java
// Cada formato tem sua própria classe
public class LeitorItensCardapioCSV { ... }
public class LeitorItensCardapioJSON { ... }
```

#### 2. Extract Interface (Extrair Interface)

**Antes:**
```java
// Código acoplado a implementações concretas
LeitorItensCardapioCSV leitorCSV = new LeitorItensCardapioCSV();
```

**Depois:**
```java
// Código depende de interface, não implementação
LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(arquivo);
```

#### 3. Extract Method (Extrair Método)

**Aplicado nas classes leitoras:**
```java
// Método específico para cada responsabilidade
private ItemCardapio criarItem(String[] partes) { ... }
private void configurarPromocao(ItemCardapio item, String[] partes) { ... }
```

#### 4. Replace Conditional with Polymorphism

**Antes:**
```java
if (nomeArquivo.endsWith(".csv")) {
    // lógica CSV
} else if (nomeArquivo.endsWith(".json")) {
    // lógica JSON
}
```

**Depois:**
```java
// Polimorfismo decide qual lógica executar
LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(nomeArquivo);
itens = leitor.processaArquivo(nomeArquivo);
```

### 📊 Comparação Antes vs Depois

| Métrica | Antes (Aula 15) | Depois (Aula 16) | Melhoria |
|---------|-----------------|-------------------|----------|
| Linhas no construtor | ~120 | ~10 | ✅ 92% redução |
| Classes envolvidas | 1 | 4 | Responsabilidades distribuídas |
| Responsabilidades | 4 (criar, ler, parsear CSV, parsear JSON) | 1 (criar) | ✅ SRP respeitado |
| Testabilidade | Baixa | Alta | ✅ Classes independentes |
| Extensibilidade | Baixa | Alta | ✅ Fácil adicionar formatos |
| Acoplamento | Alto | Baixo | ✅ Usa interfaces |

### 💡 Benefícios da Refatoração (Aula 16)

**1. Separação de Responsabilidades:**
```
Antes: Cardapio fazia TUDO
Depois:
  - Cardapio: coordena criação
  - FabricaLeitorItensCardapio: decide qual leitor usar
  - LeitorItensCardapioCSV: parseia CSV
  - LeitorItensCardapioJSON: parseia JSON
```

**2. Open/Closed Principle:**
```java
// Adicionar XML sem modificar código existente:
public class LeitorItensCardapioXML implements LeitorItensCardapio {
    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Implementação XML
    }
}

// Atualizar apenas a fábrica:
public class FabricaLeitorItensCardapio {
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        if (nomeArquivo.endsWith(".csv")) return new LeitorItensCardapioCSV();
        if (nomeArquivo.endsWith(".json")) return new LeitorItensCardapioJSON();
        if (nomeArquivo.endsWith(".xml")) return new LeitorItensCardapioXML(); // Nova!
        return null;
    }
}
```

**3. Testabilidade:**
```java
// Agora pode testar cada componente isoladamente:
@Test
void testLeitorCSV() {
    LeitorItensCardapio leitor = new LeitorItensCardapioCSV();
    ItemCardapio[] itens = leitor.processaArquivo("teste.csv");
    // ...
}

@Test
void testLeitorJSON() {
    LeitorItensCardapio leitor = new LeitorItensCardapioJSON();
    ItemCardapio[] itens = leitor.processaArquivo("teste.json");
    // ...
}
```

### ✅ Onde foi usado
- **Aula 16: Refatoração completa do construtor Cardapio** ⭐
- Extração da lógica de parsing para classes especializadas
- Criação de interface para desacoplar código
- Aplicação do padrão Factory para criação de objetos
- Redução de ~120 linhas para ~10 linhas no construtor

---

## 18. Factory Pattern

### 📖 Teoria
Factory Pattern (Padrão de Fábrica) é um **padrão de criação** que fornece uma interface para criar objetos, mas permite que subclasses ou métodos decidam qual classe instanciar. Encapsula a lógica de criação de objetos.

### 🎯 Tipos de Factory

**1. Simple Factory (Fábrica Simples):**
- Método estático que retorna objetos
- Decide qual classe instanciar baseado em parâmetros

**2. Factory Method:**
- Método abstrato que subclasses implementam
- Cada subclasse cria um tipo específico

**3. Abstract Factory:**
- Interface para criar famílias de objetos relacionados
- Múltiplas fábricas concretas

### 💻 Aplicação na Aula 16 - Simple Factory ⭐

```java
package mx.florinda.leitor;

public class FabricaLeitorItensCardapio {
    
    public LeitorItensCardapio criaLeitor(String nomeArquivo) {
        
        LeitorItensCardapio leitor = null;
        
        // Lógica de decisão centralizada
        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCSV();
        } else if (nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioJSON();
        }
        
        return leitor;
    }
}
```

### 🎯 Benefícios do Factory Pattern

**1. Encapsulamento da Criação:**
```java
// SEM Factory (código cliente decide):
LeitorItensCardapio leitor;
if (arquivo.endsWith(".csv")) {
    leitor = new LeitorItensCardapioCSV();
} else {
    leitor = new LeitorItensCardapioJSON();
}

// COM Factory (lógica centralizada):
FabricaLeitorItensCardapio fabrica = new FabricaLeitorItensCardapio();
LeitorItensCardapio leitor = fabrica.criaLeitor(arquivo);
```

**2. Flexibilidade:**
```java
// Adicionar novo formato só muda a fábrica
public LeitorItensCardapio criaLeitor(String nomeArquivo) {
    if (nomeArquivo.endsWith(".csv")) return new LeitorItensCardapioCSV();
    if (nomeArquivo.endsWith(".json")) return new LeitorItensCardapioJSON();
    if (nomeArquivo.endsWith(".xml")) return new LeitorItensCardapioXML(); // Novo!
    if (nomeArquivo.endsWith(".yaml")) return new LeitorItensCardapioYAML(); // Novo!
    return null;
}
```

**3. Código Cliente Desacoplado:**
```java
public class Cardapio {
    public Cardapio(String nomeArquivo) throws Exception {
        // Não sabe nem se importa se é CSV, JSON, XML...
        FabricaLeitorItensCardapio fabricaLeitor = new FabricaLeitorItensCardapio();
        LeitorItensCardapio leitor = fabricaLeitor.criaLeitor(nomeArquivo);
        
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        }
    }
}
```

**4. Único Ponto de Mudança:**
```java
// Para mudar critério de seleção, só muda aqui:
public LeitorItensCardapio criaLeitor(String nomeArquivo) {
    // Antes: baseado em extensão
    if (nomeArquivo.endsWith(".csv")) { ... }
    
    // Depois: baseado em magic number no arquivo
    String primeiraLinha = lerPrimeiraLinha(nomeArquivo);
    if (primeiraLinha.startsWith("{")) return new LeitorItensCardapioJSON();
    if (primeiraLinha.contains(";")) return new LeitorItensCardapioCSV();
    
    // Código cliente (Cardapio) não muda!
}
```

### 📊 Estrutura do Pattern no Projeto

```
┌─────────────────────────────────────┐
│      FabricaLeitorItensCardapio     │
│                                     │
│  + criaLeitor(String): LeitorIten..│
└────────────┬────────────────────────┘
             │ cria
             ▼
    ┌────────────────────┐
    │ LeitorItensCardapio│ ◄─── Interface
    │  (interface)        │
    └────────────────────┘
             ▲
             │ implementam
       ┌─────┴──────┐
       │            │
┌──────┴──────┐  ┌──┴──────────────┐
│ LeitorCSV   │  │ LeitorJSON      │
└─────────────┘  └─────────────────┘
```

### 💡 Quando usar Factory Pattern?

**Use Factory quando:**
- ✅ Criação de objetos é complexa
- ✅ Tipo de objeto depende de condições em runtime
- ✅ Quer centralizar lógica de criação
- ✅ Quer desacoplar código cliente das classes concretas
- ✅ Precisa de flexibilidade para adicionar novos tipos

**Não use Factory quando:**
- ❌ Criação é trivial (só `new Classe()`)
- ❌ Tipo de objeto é sempre o mesmo
- ❌ Não há benefício de abstração

### 💻 Exemplo de Uso

```java
// No Main
void main() throws Exception {
    String arquivo = IO.readln("Digite o nome do arquivo: ");
    
    // Cardapio usa a fábrica internamente
    Cardapio cardapio = new Cardapio(arquivo);
    
    // Usuário digita "itens.csv" → Fábrica cria LeitorCSV
    // Usuário digita "itens.json" → Fábrica cria LeitorJSON
    // Usuário digita "itens.xml" → Fábrica cria LeitorXML (futuro)
}
```

### ✅ Onde foi usado
- **Aula 16: `FabricaLeitorItensCardapio`** ⭐
- Centraliza lógica de criação de leitores
- Decide qual leitor instanciar baseado na extensão do arquivo
- Desacopla `Cardapio` das implementações concretas de leitores
- Facilita adição de novos formatos de arquivo

---

## 📊 Resumo de Conceitos por Aula

| Aula | Conceitos Principais |
|------|---------------------|
| Aula 10 | Composição, Encapsulamento, Getters/Setters |
| Aula 11 | Modificador Protected, Geradores IDE |
| Aula 12 | Manipulação de Strings, Comparação (equals) |
| Aula 13 | StringBuilder, Final, Classes Imutáveis |
| Aula 14 | Arquivos (Path, Files), Parsing CSV, IOException, Conversão de Tipos |
| Aula 15 | Parsing Manual de JSON, Regex Avançado, Tratamento de null |
| **Aula 16** | **Interfaces, Refatoração, Factory Pattern, Polimorfismo Avançado, SOLID** ⭐ |

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
17. ✅ **split com limite**: Preservar conteúdo com delimitadores
18. ✅ **Regex para parsing**: Usar expressões regulares quando apropriado
19. ✅ **Comentários sobre refatoração**: Documentar código temporário
20. ✅ **Programar para interface, não implementação** (Aula 16) ⭐
21. ✅ **Single Responsibility Principle**: Uma classe, uma responsabilidade (Aula 16) ⭐
22. ✅ **Open/Closed Principle**: Aberto para extensão, fechado para modificação (Aula 16) ⭐
23. ✅ **Dependency Inversion**: Depender de abstrações, não de concretizações (Aula 16) ⭐
24. ✅ **Factory para criação**: Centralizar lógica de instanciação (Aula 16) ⭐
25. ✅ **Refatoração incremental**: Pequenas mudanças, testes frequentes (Aula 16) ⭐

---

## 📚 Referências

- [Oracle Java Tutorials - OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Oracle Java Tutorials - Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Oracle Java Tutorials - File I/O](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Oracle Java Tutorials - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Oracle Java Tutorials - Regular Expressions](https://docs.oracle.com/javase/tutorial/essential/regex/)
- [JSON.org - Introducing JSON](https://www.json.org/)
- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Refactoring Guru - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Effective Java - Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- Slides e materiais do curso Java Elite - UNIPDS

---

_Documento atualizado em: Fevereiro 2026_
_Última revisão: Aula 16_
