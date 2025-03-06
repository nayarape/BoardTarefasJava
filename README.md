# Boarddio - Gerenciador de Tarefas

O **Boarddio** é um aplicativo de gerenciamento de tarefas que permite criar e gerenciar boards personalizáveis. Ele foi desenvolvido com Java, Spring Boot, JPA (Hibernate) e MySQL, proporcionando uma maneira fácil de acompanhar e manipular as tarefas de forma eficiente.

## 📋 Funcionalidades

- **Criar novo board:** Permite criar boards com colunas customizáveis.
- **Manipulação de Cards:** Cada board possui cards que podem ser movidos, bloqueados ou cancelados.
- **Gerenciamento de Colunas:** Cada board contém ao menos três colunas, sendo uma de início, uma de finalização e uma de cancelamento, além de colunas pendentes.
- **Armazenamento no Banco de Dados:** Todos os boards, colunas e cards são armazenados em um banco de dados MySQL.

## 🛠 Tecnologias Usadas

- **Java 11+**
- **Spring Boot**
- **JPA (Hibernate)**
- **MySQL**
- **Maven** (para gerenciamento de dependências)


``` mermaid

erDiagram
    BOARD {
        INT id PK
        VARCHAR nome
    }

    COLUMN {
        INT id PK
        VARCHAR nome
        VARCHAR tipo
        INT ordem
        INT board_id FK
    }

    CARD {
        INT id PK
        VARCHAR titulo
        TEXT descricao
        DATETIME data_criacao
        BOOLEAN bloqueado
        INT coluna_id FK
    }

    BLOQUEIO {
        INT id PK
        INT card_id FK
        TEXT motivo_bloqueio
        TEXT motivo_desbloqueio
        DATETIME data_bloqueio
        DATETIME data_desbloqueio
    }

    BOARD ||--o| COLUMN : "possui"
    COLUMN ||--o| CARD : "contém"
    CARD ||--o| BLOQUEIO : "tem"

```


