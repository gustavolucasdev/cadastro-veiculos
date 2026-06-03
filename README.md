# 🚗 Sistema de Cadastro de Veículos

## 📖 Sobre o Projeto

Este é um projeto simples que desenvolvi durante meus estudos de Java para praticar conceitos fundamentais de Programação Orientada a Objetos (POO), estruturas de dados e organização em camadas.

O sistema funciona através do terminal e permite realizar operações básicas de um CRUD (Create, Read, Update, Delete), utilizando uma lista em memória (`ArrayList`) para armazenar os veículos cadastrados.

### Funcionalidades

✅ Cadastrar veículos

✅ Listar veículos cadastrados

✅ Buscar veículo pela placa

✅ Remover veículo pela placa

✅ Encerrar o sistema

---

## 🎯 Objetivo do Projeto

O principal objetivo deste projeto foi praticar:

- Classes e Objetos
- Encapsulamento
- Métodos
- Construtores
- Listas (`ArrayList`)
- Estrutura de repetição (`do-while`)
- Estrutura de decisão (`switch-case`)
- Organização em camadas
- Separação de responsabilidades
- Boas práticas de programação

---

## 🏗️ Estrutura do Projeto

```text
src
└── com.gustavolucasdev
    ├── Program.java
    │
    ├── entities
    │   └── Veiculos.java
    │
    ├── repositories
    │   └── VeiculoRepository.java
    │
    └── services
        └── VeiculoService.java
```

---

## 📂 Camadas do Projeto

### 📌 Entity

Responsável por representar o objeto Veículo.

Arquivo:

```java
Veiculos.java
```

Atributos:

```java
private String placa;
private String modelo;
private String marca;
private int ano;
```

Exemplo de criação:

```java
Veiculos veiculo = new Veiculos(
    "ABC1234",
    "Fiat",
    "Strada",
    2026
);
```

---

### 📌 Repository

Responsável pelo armazenamento e manipulação dos dados.

Arquivo:

```java
VeiculoRepository.java
```

Métodos implementados:

| Método | Função |
|----------|----------|
| salvar() | Cadastra um veículo |
| listar() | Retorna todos os veículos |
| buscarPlaca() | Busca um veículo pela placa |
| removerPorPlaca() | Remove um veículo pela placa |

---

### 📌 Service

Responsável pela regra de negócio.

Arquivo:

```java
VeiculoService.java
```

Atualmente ele faz a comunicação entre o programa principal e o repositório.

Métodos disponíveis:

```java
cadastrar()
listar()
buscarPlaca()
removerPorPlaca()
```

---

### 📌 Program

Responsável pela interação com o usuário.

Arquivo:

```java
Program.java
```

Menu principal:

```text
1 - Cadastrar
2 - Listar
3 - Buscar por placa
4 - Remover
5 - Sair
```

Utilizei um:

```java
do {
   ...
} while(opcao != 5);
```

para manter o sistema em execução até o usuário escolher sair.

---

## 🔄 Fluxo da Aplicação

```text
Usuário
   ↓
Program
   ↓
Service
   ↓
Repository
   ↓
ArrayList
```

Essa separação deixa o código mais organizado e facilita futuras manutenções.

---

## 💻 Exemplo de Uso

### Cadastro

```text
Informe a placa: HJK1234
Informe a marca: Volkswagen
Informe o modelo: Gol
Informe o ano: 2020

Veículo cadastrado com sucesso!
```

### Listagem

```text
Placa: HJK1234
Marca: Volkswagen
Modelo: Gol
Ano: 2020
```

### Busca

```text
Informe a placa: HJK1234

Placa: HJK1234
Marca: Volkswagen
Modelo: Gol
Ano: 2020
```

### Remoção

```text
Informe a placa: HJK1234

Veículo removido com sucesso!
```

---

## 🛠️ Tecnologias Utilizadas

- Java
- IntelliJ IDEA
- Programação Orientada a Objetos (POO)
- Collections Framework (`ArrayList`)

---

## 📚 O que Aprendi

Durante o desenvolvimento deste projeto consegui praticar diversos conceitos importantes:

- Criação de classes e objetos
- Encapsulamento com getters e setters
- Construtores
- Organização em pacotes
- Separação entre Entity, Service e Repository
- Manipulação de listas
- Busca de objetos em coleções
- Remoção de elementos utilizando `removeIf`
- Estruturas de repetição e decisão
- Entrada de dados com `Scanner`

---

## 👨‍💻 Autor

Desenvolvido por **Gustavo Lucas Ferreira Silva** durante os estudos de Java.

Este projeto faz parte da minha jornada de aprendizado em Programação Orientada a Objetos e desenvolvimento backend com Java. 🚀
