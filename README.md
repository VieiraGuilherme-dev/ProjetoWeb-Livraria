# 📚 Sistema de Gestão de Livraria

Este projeto consiste em uma aplicação web moderna e responsiva para gerenciar uma **livraria**, com funcionalidades completas para cadastrar livros físicos e digitais, exibir listas atualizadas, realizar compras e acompanhar o histórico, incluindo atualização automática do estoque de livros físicos.

---

## 📌 Funcionalidades

- Cadastro de livros físicos e digitais com informações detalhadas (título, autor, gênero, preço, etc.).
- Exibição de listas de livros disponíveis para compra.
- Sistema de compras online com integração de pagamento.
- Acompanhamento do histórico de compras dos usuários.
- Atualização automática do estoque de livros físicos após cada compra.
- Cadastro de usuários (clientes e administradores).
- Busca e filtragem de livros por diferentes critérios.

---

## 🗂️ Estrutura do Projeto


src/
└── main/
│ ├── controller/
│ ├── model/
│ ├── repository/
│ ├── service/
└── resources/


---


---

## 🛠️ Tecnologias Utilizadas

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
• Linguagem principal utilizada no desenvolvimento da aplicação.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)  
• Framework que facilita a criação de aplicações Java robustas, com injeção de dependência, API REST, entre outros.

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)  
• Sistema gerenciador de banco de dados relacional usado para armazenar as informações do sistema.

![JPA](https://img.shields.io/badge/JPA-007396?style=for-the-badge&logo=hibernate&logoColor=white)  
• API de persistência utilizada para mapear os objetos Java para tabelas no banco de dados.

![JDBC](https://img.shields.io/badge/JDBC-003B57?style=for-the-badge&logo=oracle&logoColor=white)  
• API utilizada para conectar e executar consultas SQL diretamente no banco de dados.

![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)  
• Plataforma utilizada para testar os endpoints da API REST, garantindo o correto funcionamento das rotas, validações e respostas do sistema.

---
## 📄 Consultas SQL (DQL) exigidas

- Todos os livros cadastrados
- Todos os usuários clientes
- Todas as compras realizadas
- Histórico de compras com status
- Livros disponíveis em estoque

As consultas estão presentes no arquivo `consultas.sql` dentro da pasta `/scripts`.

## ✅ Entregáveis

- ✅ Histórias de usuários (User  Stories)
- ✅ Diagrama físico do banco de dados (PNG/JPG)
- ✅ Script SQL completo para PostgreSQL (DDL + DQL)
- ✅ Projeto Java Spring Boot funcional com JDBC
- ✅ Consultas SQL solicitadas
- ✅ Repositório público no GitHub


---

### 👨‍💻 Desenvolvido por

*Guilherme Vieira, Vinicius Marques e Wagner Teofilo*


## 🧠 Como Executar o Projeto

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git

