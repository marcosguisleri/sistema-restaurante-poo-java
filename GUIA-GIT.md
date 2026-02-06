# 🚀 Guia de Comandos Git - Inicializando o Repositório

Este guia te ajudará a colocar seu projeto no GitHub passo a passo.

---

## 📋 Pré-requisitos

1. ✅ Git instalado no seu computador
2. ✅ Conta no GitHub criada
3. ✅ IntelliJ IDEA com o projeto aberto

---

## 🔧 Passo 1: Configurar Git (só precisa fazer uma vez)

Abra o terminal/prompt de comando e configure seu nome e email:

```bash
git config --global user.name "Seu Nome Completo"
git config --global user.email "seu.email@exemplo.com"
```

---

## 🌟 Passo 2: Criar Repositório no GitHub

1. Acesse: https://github.com/new
2. Preencha:
    - **Repository name:** `sistema-restaurante-poo-java`
    - **Description:**
      `Sistema de gerenciamento de restaurante desenvolvido em Java aplicando conceitos de POO - Projeto do Módulo 1 do curso Java Elite (UNIPDS)`
    - **Visibility:** Public (para aparecer no seu perfil)
    - ⚠️ **NÃO marque** "Add a README file"
    - ⚠️ **NÃO marque** "Add .gitignore"
    - ⚠️ **NÃO marque** "Choose a license"
3. Clique em **Create repository**

---

## 💻 Passo 3: Preparar Arquivos Localmente

### 3.1 Organizar Estrutura do Projeto

Copie todos os arquivos criados para a pasta do seu projeto:

```
CursoProjeto/  (sua pasta do IntelliJ)
├── .gitignore          ← Arquivo que você baixou
├── LICENSE             ← Arquivo que você baixou
├── README.md           ← Arquivo que você baixou
├── docs/
│   ├── conceitos-aprendidos.md    ← Arquivo que você baixou
│   └── evolucao-do-projeto.md     ← Arquivo que você baixou
├── .idea/              ← Pasta do IntelliJ (será ignorada pelo git)
├── out/                ← Pasta de compilação (será ignorada)
└── src/
    └── mx/florinda/
        ├── cli/
        │   └── Main.java
        └── modelo/
            ├── Cardapio.java
            ├── CategoriaCardapio.java
            ├── ItemCardapio.java
            ├── ItemCardapioBebida.java
            ├── ItemCardapioIsento.java
            ├── ItemCardapioSemGluten.java
            └── Restaurante.java
```

### 3.2 Editar o LICENSE

Abra o arquivo `LICENSE` e substitua `[Seu Nome Aqui]` pelo seu nome real.

---

## 🎯 Passo 4: Inicializar Git no Projeto

Abra o terminal **dentro da pasta do seu projeto** (onde está o arquivo `.gitignore`):

### No Windows (PowerShell ou CMD)

```bash
cd C:\caminho\para\seu\CursoProjeto
```

### No Linux/Mac

```bash
cd /caminho/para/seu/CursoProjeto
```

---

## 📦 Passo 5: Comandos Git para Subir o Projeto

Execute os comandos **na ordem**:

### 5.1 Inicializar repositório Git

```bash
git init
```

### 5.2 Adicionar todos os arquivos

```bash
git add .
```

### 5.3 Fazer o primeiro commit

```bash
git commit -m "feat: inicializa projeto com estrutura base do Restaurante (aula 10)"
```

### 5.4 Renomear branch para main (padrão do GitHub)

```bash
git branch -M main
```

### 5.5 Conectar com o repositório remoto do GitHub

**⚠️ SUBSTITUA `seu-usuario` pelo seu nome de usuário do GitHub:**

```bash
git remote add origin https://github.com/seu-usuario/sistema-restaurante-poo-java.git
```

### 5.6 Enviar código para o GitHub

```bash
git push -u origin main
```

Se pedir usuário e senha:

- **Usuário:** seu nome de usuário do GitHub
- **Senha:** use um **Personal Access Token** (não a senha normal)
    - Para criar: https://github.com/settings/tokens

---

## ✅ Verificar se Funcionou

1. Acesse: `https://github.com/seu-usuario/sistema-restaurante-poo-java`
2. Você deve ver todos os arquivos lá!
3. O README.md será exibido automaticamente na página inicial

---

## 🔄 Comandos para Próximos Commits (Aulas Futuras)

Sempre que fizer mudanças no código:

### 1. Verificar o que mudou

```bash
git status
```

### 2. Adicionar as mudanças

```bash
# Adicionar todos os arquivos modificados
git add .

# OU adicionar arquivo específico
git add src/mx/florinda/modelo/NomeArquivo.java
```

### 3. Fazer o commit com mensagem descritiva

```bash
# Exemplos de boas mensagens:

# Nova funcionalidade
git commit -m "feat: adiciona método de busca por categoria no Cardapio (aula 11)"

# Correção de bug
git commit -m "fix: corrige cálculo de imposto em ItemCardapioBebida"

# Refatoração
git commit -m "refactor: melhora encapsulamento da classe Restaurante (aula 12)"

# Exercício
git commit -m "feat: implementa sistema de pedidos (aula 13 - exercício 1)"

# Documentação
git commit -m "docs: atualiza README com instruções de execução"
```

### 4. Enviar para o GitHub

```bash
git push
```

---

## 🎨 Convenção de Commits (Semantic Commit Messages)

Use prefixos para deixar o histórico organizado:

| Prefixo     | Quando usar         | Exemplo                                            |
|-------------|---------------------|----------------------------------------------------|
| `feat:`     | Nova funcionalidade | `feat: adiciona cálculo de taxa de serviço`        |
| `fix:`      | Correção de bug     | `fix: corrige NullPointerException no getCardapio` |
| `refactor:` | Melhoria de código  | `refactor: simplifica método getSomaDosPrecos`     |
| `docs:`     | Documentação        | `docs: adiciona javadoc nas classes do modelo`     |
| `style:`    | Formatação          | `style: ajusta indentação do código`               |
| `test:`     | Testes              | `test: adiciona testes unitários para Cardapio`    |
| `chore:`    | Tarefas gerais      | `chore: atualiza .gitignore`                       |

---

## 🆘 Comandos Úteis de Emergência

### Desfazer último commit (mas manter as mudanças)

```bash
git reset --soft HEAD~1
```

### Descartar mudanças não commitadas

```bash
git checkout -- nome-do-arquivo.java
```

### Ver histórico de commits

```bash
git log --oneline
```

### Ver diferenças do que mudou

```bash
git diff
```

### Ver branches

```bash
git branch -a
```

---

## 🔗 Links Importantes

- **Seu repositório:** `https://github.com/seu-usuario/sistema-restaurante-poo-java`
- **Criar Personal Access Token:** https://github.com/settings/tokens
- **GitHub Desktop (alternativa visual):** https://desktop.github.com/
- **GitKraken (cliente visual avançado):** https://www.gitkraken.com/

---

## 💡 Dicas Profissionais

1. ✅ **Commit frequentemente**: Pequenos commits são melhores que grandes
2. ✅ **Mensagens descritivas**: Explique O QUE e POR QUE mudou
3. ✅ **Um commit = uma mudança lógica**: Não misture várias funcionalidades
4. ✅ **Push regularmente**: Não deixe acumular commits locais
5. ✅ **README atualizado**: Mantenha a documentação sincronizada

---

## 🎯 Exemplo de Fluxo Completo (Aula 11 Futura)

```bash
# 1. Você fez mudanças no código durante a aula 11
# 2. Verificar o que mudou
git status

# 3. Adicionar tudo
git add .

# 4. Commitar com mensagem
git commit -m "feat: adiciona relacionamento entre Pedido e ItemCardapio (aula 11)"

# 5. Enviar para GitHub
git push

# 6. Atualizar documentação
# (editar docs/evolucao-do-projeto.md)

git add docs/evolucao-do-projeto.md
git commit -m "docs: documenta mudanças da aula 11"
git push
```

---

## ❓ Problemas Comuns

### "fatal: not a git repository"

**Solução:** Você não está na pasta correta. Use `cd` para ir até a pasta do projeto.

### "Permission denied"

**Solução:** Use Personal Access Token em vez de senha.

### "Updates were rejected"

**Solução:** Alguém fez mudanças no GitHub. Puxe primeiro:

```bash
git pull origin main
git push
```

### Conflito de merge

**Solução:** Edite o arquivo com conflito, depois:

```bash
git add .
git commit -m "fix: resolve conflito de merge"
git push
```

---

## 🎓 Próximos Passos

Depois de dominar o básico, você pode aprender:

- [ ] Branches (para trabalhar em funcionalidades isoladas)
- [ ] Pull Requests (para contribuir em projetos)
- [ ] GitHub Actions (CI/CD automático)
- [ ] Git Flow (metodologia de branches)

---

**🎉 Parabéns! Agora você tem seu projeto versionado profissionalmente!**

_Qualquer dúvida, consulte a documentação oficial: https://git-scm.com/doc_
