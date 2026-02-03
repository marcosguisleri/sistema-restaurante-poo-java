# 🍽️ Sistema de Restaurante - POO em Java

[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow.svg)]()

Sistema de gerenciamento para o **Restaurante da Dona Florinda**, desenvolvido como projeto prático do **Módulo 1 - Introdução ao Java** do curso **Java Elite** da **UNIPDS**.

O projeto evolui ao longo das 19 aulas, aplicando progressivamente conceitos de **Programação Orientada a Objetos (POO)**, desde código estruturado até implementações avançadas com herança, polimorfismo, interfaces, classes abstratas e tratamento de exceções.

---

## 📋 Sobre o Projeto

Este é um sistema de cardápio digital inspirado no universo do **Chaves**, desenvolvido para consolidar conceitos fundamentais de Java e POO:

- ✅ Classes e Objetos
- ✅ Encapsulamento (Getters e Setters)
- ✅ Herança e Polimorfismo
- ✅ Modificadores de Acesso
- ✅ Enums
- ✅ Arrays e Coleções
- ✅ Composição de Objetos

---

## 🚀 Funcionalidades

- 📝 Cadastro de itens do cardápio
- 🏷️ Categorização (Entradas, Pratos Principais, Sobremesas, Bebidas)
- 💰 Sistema de promoções com cálculo automático de desconto
- 🧾 Cálculo de impostos diferenciado por tipo de item
- 🌾 Identificação de itens sem glúten
- 🔍 Busca de itens por ID
- 📊 Relatórios (soma de preços, itens em promoção, etc.)

---

## 🏗️ Estrutura do Projeto

```
sistema-restaurante-poo-java/
├── src/
│   └── mx/florinda/
│       ├── cli/
│       │   └── Main.java                    # Ponto de entrada da aplicação
│       └── modelo/
│           ├── Cardapio.java                # Gerencia a coleção de itens
│           ├── CategoriaCardapio.java       # Enum com categorias
│           ├── ItemCardapio.java            # Classe base dos itens
│           ├── ItemCardapioBebida.java      # Especialização para bebidas
│           ├── ItemCardapioIsento.java      # Itens isentos de imposto
│           ├── ItemCardapioSemGluten.java   # Itens sem glúten
│           └── Restaurante.java             # Representa o restaurante
├── docs/
│   ├── evolucao-do-projeto.md              # Histórico de mudanças
│   └── conceitos-aprendidos.md             # Conceitos de POO aplicados
├── .gitignore
├── LICENSE
└── README.md
```

---

## 💻 Como Executar

### Pré-requisitos

- Java 21 ou superior
- IntelliJ IDEA (recomendado) ou qualquer IDE Java

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sistema-restaurante-poo-java.git
cd sistema-restaurante-poo-java
```

2. Abra o projeto na sua IDE

3. Execute a classe `Main.java` localizada em `src/mx/florinda/cli/`

4. Siga as instruções no console para interagir com o sistema

---

## 📚 Conceitos de POO Aplicados

### 1. **Encapsulamento**
- Atributos privados com getters e setters
- Controle de acesso aos dados

### 2. **Herança**
```java
ItemCardapio (classe pai)
    ├── ItemCardapioBebida
    ├── ItemCardapioIsento
    └── ItemCardapioSemGluten
```

### 3. **Polimorfismo**
- Sobrescrita de métodos (`@Override`)
- Comportamentos específicos em subclasses
- Exemplo: `getImposto()` calculado diferentemente em cada tipo

### 4. **Composição**
- `Restaurante` **tem um** `Cardapio`
- `Cardapio` **tem vários** `ItemCardapio`

### 5. **Enums**
- `CategoriaCardapio` para tipagem segura de categorias

---

## 🎯 Exemplos de Uso

### Consultar item do cardápio
```
Digite um id de um item de cardápio: 1

== Item do Cardápio ==
Id: 1
Nome: Refresco do Chaves
Descrição: Suco de limão que parece de tamarindo e tem gosto de groselha.
Preco: 2.99
Categoria: BEBIDAS
Imposto: 1.495
```

### Item em promoção
```
Digite um id de um item de cardápio: 2

== Item do Cardápio ==
Id: 2
Nome: Sanduíche de Presunto do Chaves
Item em promoção! 🤑
Preco: de 3.50 por 2.99
Porcentagem de desconto: 14.57%
Este item não contém glúten.
```

---

## 📖 Documentação Adicional

- [📈 Evolução do Projeto](docs/evolucao-do-projeto.md) - Histórico detalhado das aulas
- [🎓 Conceitos Aprendidos](docs/conceitos-aprendidos.md) - Explicações teóricas aplicadas

---

## 🎓 Sobre o Curso

**Curso:** Java Elite  
**Instituição:** UNIPDS (Pós-Graduação)  
**Módulo:** 01 - Introdução ao Java  
**Total de Aulas:** 19 videoaulas  
**Aula Atual:** 10 - Pacotes, Modificadores de Acesso, Getters e Setters

### 📚 Conteúdo do Módulo 1

1. ✅ O Que é Java?
2. ✅ JVM, JSR e JEP
3. ✅ Variáveis, Operadores e Condicionais
4. ✅ Arrays e Laços de Repetição
5. ✅ Classes, Atributos e Objetos
6. ✅ Métodos e Construtores
7. ✅ Arrays de Objetos, Composição e Enums
8. ✅ IntelliJ IDE e Debug
9. ✅ Organizando em Arquivos e Herança
10. ✅ **Pacotes, Modificadores de Acesso, Getters e Setters** ← Você está aqui!
11. ⏳ Protected
12. ⏳ String
13. ⏳ Imutabilidade, StringBuilder e Final
14. ⏳ Praticando com Arquivo CSV
15. ⏳ Praticando com Arquivo JSON
16. ⏳ Refatoração e Interfaces
17. ⏳ Classes Abstratas e Static
18. ⏳ Object, Classes Wrapper e Javadoc
19. ⏳ JARs e Exceptions

> **Nota:** Este repositório documenta meu aprendizado a partir da **Aula 10**, onde começou o versionamento do código. O projeto continua evoluindo nas próximas 9 aulas do módulo.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21+
- **IDE:** IntelliJ IDEA
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Controle de Versão:** Git & GitHub

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👨‍💻 Autor

Desenvolvido como projeto de aprendizado no curso **Java Elite da UNIPDS**.

---

## 🤝 Contribuições

Como este é um projeto educacional pessoal, não estou aceitando contribuições externas no momento. Porém, feedbacks e sugestões são sempre bem-vindos!

---

## 📬 Contato

Se tiver dúvidas ou sugestões sobre o projeto, sinta-se à vontade para abrir uma [issue](../../issues).

---

<div align="center">

**⭐ Se este projeto te ajudou de alguma forma, deixe uma estrela! ⭐**

Feito com ☕ e muito aprendizado!

</div>
