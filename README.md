# 🍽️ Sistema de Restaurante - Projeto Java

Projeto desenvolvido durante a pós-graduação em Java, simulando um sistema de gerenciamento de restaurante com cardápio interativo.

## 📚 Aulas Implementadas

### Aula 14 - Praticando com Arquivo CSV
- ✅ Implementação de leitura de arquivos CSV
- ✅ Refatoração do construtor da classe `Cardapio`
- ✅ Parsing de dados estruturados (CSV)
- ✅ Validação de dados de entrada
- ✅ Instanciação dinâmica de objetos a partir de arquivos
- ✅ Preparação para suporte a arquivos JSON

**Principais conceitos aplicados:**
- Manipulação de arquivos com `java.nio.file.Path` e `Files`
- Parsing de strings com `split()`
- Tratamento de exceções (`IOException`)
- Conversão de tipos de dados
- Validação de estrutura de dados

### Aulas Anteriores
- Aula 13: Trabalhando com Strings
- Aula 12: Herança e Polimorfismo
- Aula 11: Encapsulamento e Modificadores de Acesso
- Aula 10: Métodos e Construtores
- Aula 09: Classes e Objetos
- Aulas 01-08: Fundamentos de Java

## 🏗️ Estrutura do Projeto

```
src/
├── Main.java                    # Ponto de entrada do sistema
├── Cardapio.java               # Gerenciamento do cardápio (agora com leitura de CSV)
├── ItemCardapio.java           # Classe base para itens
├── ItemCardapioBebida.java     # Especialização para bebidas
├── ItemCardapioIsento.java     # Itens isentos de impostos
├── ItemCardapioSemGluten.java  # Itens sem glúten
└── CategoriaCardapio.java      # Enum de categorias

Arquivos de dados (raiz do projeto):
├── itens-cardapio.csv          # Dados do cardápio em CSV
└── itens-cardapio.json         # Dados do cardápio em JSON (próxima aula)
```

## 📊 Formato dos Arquivos de Dados

### CSV (itens-cardapio.csv)
Formato: `id;nome;descricao;preco;categoria;emPromocao;precoComDesconto;impostoIsento;ehSemGluten`

Exemplo:
```csv
1;Refresco do Chaves;Suco de limão que parece de tamarindo;2.99;BEBIDAS;false;;false;false
2;Sanduíche de Presunto;Sanduíche simples feito com amor;3.50;PRATOS_PRINCIPAIS;true;2.99;false;true
```

**Validações implementadas:**
- Mínimo de 9 colunas obrigatórias
- Preço com desconto obrigatório quando `emPromocao = true`
- Tipos de dados validados durante parsing

### JSON (itens-cardapio.json)
Em desenvolvimento para a próxima aula.

## 🎯 Funcionalidades

### Sistema de Cardápio
- [x] Carregamento dinâmico de itens via CSV
- [x] Listagem de itens por categoria
- [x] Sistema de promoções
- [x] Cálculo automático de impostos
- [x] Suporte a itens especiais (isentos, sem glúten, bebidas)
- [ ] Carregamento via JSON (próxima aula)

### Hierarquia de Classes
```
ItemCardapio (classe base)
├── ItemCardapioBebida (sem impostos sobre bebidas)
├── ItemCardapioIsento (produtos isentos)
└── ItemCardapioSemGluten (produtos sem glúten, imposto reduzido)
```

## 🚀 Como Executar

1. Compile o projeto:
```bash
javac src/*.java
```

2. Execute o sistema:
```bash
java -cp src Main
```

3. Quando solicitado, informe o nome do arquivo:
```
Digite o nome do arquivo: itens-cardapio.csv
```

## 💡 Aprendizados

### Aula 14 - CSV
- Manipulação de arquivos é fundamental para persistência de dados
- Parsing de strings requer validação cuidadosa
- A estrutura de dados (CSV) deve ser bem documentada
- Tratamento de exceções garante robustez do sistema
- Refatoração eliminou código repetitivo do construtor anterior

### Evolução do Código
**Antes (Aula 13):** Instanciação manual de todos os itens no construtor
```java
itens[0] = new ItemCardapio(1, "Refresco do Chaves", ...);
itens[1] = new ItemCardapioSemGluten(2, "Sanduíche", ...);
// ... dezenas de linhas
```

**Depois (Aula 14):** Leitura dinâmica de arquivos
```java
Cardapio cardapio = new Cardapio("itens-cardapio.csv");
// Todos os itens carregados automaticamente!
```

## 📝 Próximos Passos

- [ ] Implementar leitura de arquivos JSON (Aula 15)
- [ ] Adicionar persistência de pedidos
- [ ] Implementar sistema de busca no cardápio
- [ ] Criar relatórios de vendas

## 🛠️ Tecnologias

- Java 17+
- java.nio.file para manipulação de arquivos
- Padrão de projeto: Herança e Polimorfismo

## 📖 Observações

- Os arquivos de dados devem estar na raiz do projeto
- O sistema valida a estrutura dos arquivos CSV
- Tratamento de erros implementado para entradas inválidas
- Código preparado para expansão futura (JSON)

---

**Status do Projeto:** 🟢 Em desenvolvimento ativo  
**Última atualização:** Aula 14 - Praticando com Arquivo CSV