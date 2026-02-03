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

**Bloco 4 - POO Avançada (Aulas 11-13)** ← **VOCÊ ESTÁ AQUI**
- Protected ✅
- String
- Imutabilidade, StringBuilder e Final

**Bloco 5 - Arquivos e Dados (Aulas 14-15)**
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

**Refatoração de Pacotes:**
- Criado novo pacote `mx.florinda.modelo.isento`
- Movida classe `ItemCardapioIsento` para o novo pacote
- Reorganização da estrutura de pacotes para melhor separação de responsabilidades

**Modificador de Acesso:**
- Alterado construtor de `ItemCardapio` de `default` (package-private) para `protected`
- Permitiu acesso do construtor por subclasses em pacotes diferentes
- Demonstração prática da diferença entre modificadores

#### 🎓 Conceitos Aplicados
- ✅ Modificador de acesso `protected`
- ✅ Visibilidade entre pacotes e herança
- ✅ Refatoração de código
- ✅ Organização em sub-pacotes

#### 🔍 Processo de Aprendizado

**Problema encontrado:**
```java
// ItemCardapioIsento movido para mx.florinda.modelo.isento
// Erro no construtor super() porque ItemCardapio tinha construtor default
public class ItemCardapioIsento extends ItemCardapio {
    ItemCardapioIsento(...) {
        super(...); // ❌ ERRO: construtor não visível
    }
}
```

**Solução tentada 1:**
```java
// Em ItemCardapio
public ItemCardapio(...) { // public funciona ✅
    // ...
}
```

**Solução final (melhor prática):**
```java
// Em ItemCardapio
protected ItemCardapio(...) { // protected é mais apropriado ✅
    // ...
}
```

#### 💡 Aprendizado Chave

**Protected permite:**
- ✅ Acesso por subclasses (mesmo em outros pacotes)
- ✅ Acesso por classes no mesmo pacote
- ❌ NÃO permite acesso público externo

**Tabela de Visibilidade:**

| Modificador | Mesma Classe | Mesmo Pacote | Subclasse (outro pacote) | Qualquer Classe |
|-------------|--------------|--------------|--------------------------|-----------------|
| `private`   | ✅           | ❌           | ❌                       | ❌              |
| `default`   | ✅           | ✅           | ❌                       | ❌              |
| `protected` | ✅           | ✅           | ✅                       | ❌              |
| `public`    | ✅           | ✅           | ✅                       | ✅              |

#### 📝 Nova Estrutura de Pacotes

```
mx.florinda/
├── cli/
│   └── Main.java
└── modelo/
    ├── Cardapio.java
    ├── CategoriaCardapio.java
    ├── ItemCardapio.java (construtor protected)
    ├── ItemCardapioBebida.java
    ├── ItemCardapioSemGluten.java
    ├── Restaurante.java
    └── isento/
        └── ItemCardapioIsento.java (usa construtor protected)
```

#### 🎯 Por que usar Protected?

**Vantagens:**
- ✅ Mais seguro que `public` (restringe acesso)
- ✅ Mais flexível que `default` (permite herança entre pacotes)
- ✅ Encapsula lógica de construção
- ✅ Segue o princípio do menor privilégio

**Quando usar:**
- Construtores de classes base abstratas
- Métodos que devem ser sobrescritos por subclasses
- Atributos que subclasses precisam acessar diretamente

---

### Aula 12 - String

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Manipulação de Strings em Java
- Métodos úteis da classe String
- Pool de Strings

---

### Aula 13 - Imutabilidade, StringBuilder e Final

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Conceito de imutabilidade
- StringBuilder vs String
- Palavra-chave `final` em variáveis, métodos e classes

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
| Classes criadas | 8 |
| Linhas de código | ~400 |
| Conceitos de POO aplicados | 5 |
| Exercícios resolvidos | 2 (aula 10) |
| Aulas versionadas | 1 de 19 |

---

## 🎯 Próximos Passos

**Bloco 4 - POO Avançada:**
- [ ] Aula 11 - Protected
- [ ] Aula 12 - String
- [ ] Aula 13 - Imutabilidade, StringBuilder e Final

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
_Última aula registrada: Aula 10_