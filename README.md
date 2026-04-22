# 🧠 Sistema Gestor de Lembretes

![Java](https://img.shields.io/badge/Java-17+-orange)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

Sistema de gestão de lembretes desenvolvido em Java, com execução via linha de comandos e persistência de dados em banco de dados PostgreSQL.

---

## 📌 Objetivo

Este projeto tem como objetivo aplicar conceitos fundamentais de programação, incluindo:

* Programação Orientada a Objetos (POO)
* Estruturas condicionais e de repetição
* Arquitetura em camadas (MVC)
* Persistência de dados com JDBC
* Organização e boas práticas de código

---

## ⚙️ Tecnologias

* **Java**
* **Maven**
* **PostgreSQL**
* **JDBC**
* **IntelliJ IDEA**

---

## 🗂️ Estrutura do Projeto

```
src/
 └── main/
      ├── java/
      │    ├── controller/
      │    ├── model/
      │    │    ├── dao/
      │    │    └── entity/
      │    └── view/
      └── resources/
           └── sql/
```

---

## 🚀 Funcionalidades

### 👤 Utilizador

* Registro de usuário
* Login com autenticação

### 🗃️ Categorias

* Criar, editar e remover categorias
* Validação de uso antes da remoção

### 📝 Lembretes

* Criar lembretes
* Editar e remover
* Alterar estado (backlog, a fazer, fazendo, feito)
* Filtros por categoria, prioridade e estado

### 📊 Relatórios

* Estrutura planejada (em desenvolvimento)

---

## 🗄️ Configuração do Banco de Dados

O sistema utiliza PostgreSQL.

### Configuração padrão:

```
URL: jdbc:postgresql://localhost:5432/fiufiu
USER: postgres
PASSWORD: postgres
```

> ⚠️ Altere conforme sua configuração local.

---

## ▶️ Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/AliceMartiz/Sistema-Gestor-de-Lembretes
```

### 2. Acessar o projeto

```bash
cd Sistema-Gestor-de-Lembretes
```

### 3. Instalar dependências (Maven)

```bash
mvn clean install
```

### 4. Executar o projeto

Execute a classe principal:

```
SistemaGestorDeLembretes.java
```

---

## 🧪 Estrutura de Código

O projeto segue o padrão:

* **Controller** → lógica da aplicação
* **Model (DAO/Entity)** → acesso e representação de dados
* **View** → interação com o usuário (terminal)

---

## ⚠️ Tratamento de Erros

* Conexão com banco validada via JDBC
* Tratamento básico de exceções
* Melhorias planejadas para robustez

---

## 🚧 Status do Projeto

🚧 Em desenvolvimento ativo

Funcionalidades ainda estão sendo implementadas e podem sofrer alterações.

---

## 💡 Melhorias Futuras

* Implementação completa de relatórios
* Validações mais robustas
* Melhor tratamento de exceções
* Interface mais amigável no terminal

---

## 👩‍💻 Autora

**Alice Martinez**

---

## 📄 Licença

Projeto acadêmico para fins educacionais.
