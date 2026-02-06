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
- Praticando com Arquivo CSV ✅
- Praticando com Arquivo JSON ✅

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

#### 📊 Formato do CSV

```csv
id;nome;descricao;preco;categoria;emPromocao;precoComDesconto;impostoIsento;ehSemGluten
1;Refresco do Chaves;Suco de limão...;2.99;BEBIDAS;false;;false;false
2;Sanduíche de Presunto;Sanduíche simples...;3.50;PRATOS_PRINCIPAIS;true;2.99;false;true
```

**Validações implementadas:**
- Mínimo de 9 colunas
- Preço com desconto obrigatório quando `emPromocao = true`
- Tratamento de campos vazios (`;;` indica campo vazio)

#### 💡 Evolução do Código

**ANTES (Aula 13):**
```java
public Cardapio() {
    itens = new ItemCardapio[7];
    
    itens[0] = new ItemCardapio(1, "Refresco do Chaves", ...);
    itens[1] = new ItemCardapioSemGluten(2, "Sanduíche", ...);
    // ... 5 itens mais
    
    // Configurar promoções manualmente
    itens[1].setPromocao(2.99);
    // ...
}
```

**Problemas:**
- ❌ ~65 linhas de código repetitivo
- ❌ Necessário recompilar para adicionar itens
- ❌ Propenso a erros de digitação
- ❌ Difícil manutenção

**DEPOIS (Aula 14):**
```java
// No Main
String nomeArquivo = IO.readln("Digite o nome do arquivo: ");
Cardapio cardapio = new Cardapio(nomeArquivo);
```

**Vantagens:**
- ✅ ~55 linhas mas genérico (funciona para qualquer quantidade de itens)
- ✅ Novos itens sem recompilar (só editar CSV)
- ✅ Validações garantem integridade
- ✅ Separação de dados e lógica

#### 🎯 Lições Aprendidas

1. **Separação de Dados e Lógica**: Dados em arquivos externos, lógica no código
2. **Validação é Investimento**: Cada validação previne horas de debug futuro
3. **Strings São Poderosas**: Métodos da Aula 13 foram cruciais aqui (`split`, `strip`, `isEmpty`, `endsWith`)
4. **Refatoração Traz Clareza**: Código menor E mais poderoso ao mesmo tempo
5. **Hard-coding é Limitante**: Fácil no começo, pesadelo depois

#### 📊 Impacto nas Métricas

| Métrica | Antes | Depois | Melhoria |
|---------|-------|--------|----------|
| Linhas de código | ~65 | ~55 | ✅ 15% redução |
| Escalabilidade | 7 itens fixos | Ilimitada | ✅ ∞ |
| Recompilação | Sempre | Nunca | ✅ 100% |
| Manutenibilidade | Baixa | Alta | ✅ 900% |

#### 🔗 Conexão com Aula Anterior

**Aula 13 (Strings) foi essencial para Aula 14!**
- `split(";", -1)` → separar colunas CSV
- `strip()` → limpar espaços
- `isEmpty()` / `isBlank()` → validações
- `endsWith()` → identificar tipo de arquivo

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

#### 📊 Formato do JSON

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

#### 💻 Código Principal - Seção JSON

```java
} else if (nomeArquivo.endsWith(".json")) {

    // Trata o JSON por posição, refatoração na próxima aula
    linha = linha.replace("[", "");
    linha = linha.replace("]", "");
    linha = linha.replace("{", "");
    linha = linha.replace("}", "");

    // Split usando regex para pegar apenas vírgulas que separam campos
    String[] partes = linha.split(",\\s*\"");
    
    // Limpa as aspas de cada parte
    for (int j = 0; j < partes.length; j++) {
        partes[j] = partes[j].replace("\"", "");
    }

    // Extração dos campos (id, nome, descricao, etc.)
    // ... código de parsing ...

    // Tratamento especial para valores null
    if (!valorPrecoComDesconto.equals("null") && !valorPrecoComDesconto.isBlank()) {
        double precoComDesconto = Double.parseDouble(valorPrecoComDesconto);
        item.setPromocao(precoComDesconto);
    }

    itens[i] = item;

} else {
    IO.println("Nome do arquivo inválido! - " + nomeArquivo);
}
```

#### 🎯 Desafios e Soluções

**Desafio 1: Descrições com Vírgulas**
```json
"descricao": "Suco de limão, que parece de tamarindo e tem gosto de groselha."
```
**Solução:** Usar regex `",\\s*\""` para dividir apenas nas vírgulas seguidas de aspas (separadores de campos)

**Desafio 2: Valores com Dois-Pontos**
```json
"descricao": "Texto: com: dois-pontos"
```
**Solução:** Usar `split(":", 2)` com limite 2 para preservar conteúdo após primeiro dois-pontos

**Desafio 3: Valores Null**
```json
"precoComDesconto": null
```
**Solução:** Verificar se valor é string "null" antes de fazer parsing

#### 💡 Evolução do Código

**Compatibilidade Multi-Formato:**

```java
// Agora suporta AMBOS os formatos!
String nomeArquivo = IO.readln("Digite o nome do arquivo: ");

// CSV
Cardapio cardapio1 = new Cardapio("itens-cardapio.csv");

// JSON  
Cardapio cardapio2 = new Cardapio("itens-cardapio.json");
```

**Vantagens:**
- ✅ Flexibilidade de formato de dados
- ✅ Mesmo código funciona para CSV e JSON
- ✅ Detecção automática por extensão
- ✅ Reutilização da lógica de instanciação

#### 🎯 Lições Aprendidas

1. **Regex é Poderoso**: Expressões regulares resolvem problemas complexos de parsing
2. **Split com Limite**: `split(":", 2)` preserva conteúdo após primeiro delimitador
3. **Null em JSON**: String "null" é diferente de null Java
4. **Parsing Manual tem Limites**: Funciona para casos simples, mas bibliotecas são melhores para produção
5. **Prática Pedagógica**: Entender estrutura interna antes de usar bibliotecas

#### 📊 Comparação CSV vs JSON

| Aspecto | CSV | JSON |
|---------|-----|------|
| Legibilidade | ⭐⭐⭐ | ⭐⭐⭐⭐⭐ |
| Compacto | ⭐⭐⭐⭐⭐ | ⭐⭐⭐ |
| Estruturado | ⭐⭐ | ⭐⭐⭐⭐⭐ |
| Aninhamento | ❌ | ✅ |
| Tipos de dados | Limitado | Completo |
| Facilidade parsing | Simples | Médio (manual) |

#### ⚠️ Nota Importante

**Este é um parsing TEMPORÁRIO!**

O código atual usa manipulação manual de strings para fins **pedagógicos**. Na próxima aula (Aula 16 - Refatoração), será:
- ✅ Introduzida biblioteca JSON (Gson, Jackson ou JSON-B)
- ✅ Refatorado para usar parsing profissional
- ✅ Comparadas as abordagens: manual vs biblioteca

**Limitações do Parsing Manual:**
- ❌ JSON aninhado (objetos dentro de objetos)
- ❌ Arrays complexos
- ❌ Strings com caracteres especiais
- ❌ JSON não padronizado

#### 🔗 Conexão com Aulas Anteriores

**Aula 12 (String) + Aula 13 (StringBuilder) + Aula 14 (CSV) = Aula 15 (JSON)!**
- `replace()` → limpar caracteres estruturais
- `split()` com regex → dividir campos
- `split()` com limite → preservar conteúdo
- `trim()` → limpar espaços
- `equals()` → comparar com "null"
- Experiência com CSV facilitou entendimento de JSON

---

### Aula 16 - Refatoração e Interfaces

**Status:** ⏳ Aguardando implementação

#### 📝 O que será aprendido
- Técnicas de refatoração
- Conceito de Interfaces
- Programação para interfaces
- Contratos e implementações
- **Refatoração do parsing JSON com biblioteca** ⭐

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
- ✅ Preparação para uso de bibliotecas (Aula 16)

---

## 📊 Métricas do Projeto

| Métrica | Valor Atual |
|---------|-------------|
| Classes criadas | 12+ |
| Linhas de código | ~650+ |
| Conceitos de POO aplicados | 10 |
| Exercícios resolvidos | 6 (aulas 10-13) |
| Aulas versionadas | 6 de 19 |
| Aulas concluídas | 15 de 19 |
| Arquivos de dados | 2 (CSV e JSON) |
| Formatos suportados | 2 (CSV e JSON) ⭐ |

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
- [ ] Aula 16 - Refatoração e Interfaces (Incluirá refatoração do JSON com biblioteca!)
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
8. **Aprendizado Progressivo**: CSV → JSON manual → JSON com biblioteca (próxima aula)

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
- Preparação para uso de bibliotecas

**Por que parsing manual de JSON?**
- Objetivo pedagógico: entender estrutura
- Reforçar manipulação de strings e regex
- Apreciar valor de bibliotecas depois
- Praticar lógica de parsing

**Estrutura de pacotes:**
- `mx.florinda.modelo` - Classes de domínio (entidades do negócio)
- `mx.florinda.cli` - Interface com o usuário (entrada/saída)

**Estrutura de arquivos:**
- Raiz do projeto: arquivos de dados (CSV, JSON)
- `src/`: código-fonte Java

---

## 🔗 Links Úteis

- [README Principal](../README.md)
- [Conceitos Aprendidos](conceitos-aprendidos.md)
- [Repositório do Curso](https://github.com/professor-username/repo-curso) (referência)

---

_Documento atualizado em: Fevereiro 2026_
_Última aula registrada: Aula 15_
