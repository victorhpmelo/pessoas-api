# Universidades API

Este é um projeto Spring Boot para a criação de uma API REST que gerencia informações relacionadas a universidades. Ele utiliza o Spring Data JPA para persistência de dados e o MySQL como banco de dados relacional.

## Requisitos

- Java 21
- Maven 3.8+
- MySQL 8.0+

## Tecnologias Utilizadas

- **Spring Boot 3.4.4**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para integração com o banco de dados.
- **MySQL Connector**: Driver JDBC para conexão com o banco de dados MySQL.
- **Lombok**: Para reduzir o boilerplate de código.
- **Spring Boot Starter Web**: Para criação de endpoints REST.
- **Spring Boot Starter Test**: Para testes unitários e de integração.

## Configuração do Banco de Dados

Certifique-se de que o MySQL está instalado e configurado. Crie um banco de dados para o projeto:

```sql
CREATE DATABASE pessoas;
```

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/universidades-api.git
   cd universidades-api
   ```

2. Compile o projeto com Maven:

   ```bash
   mvn clean install
   ```

3. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em `http://localhost:8080`.

## Estrutura do Projeto

- **src/main/java**: Contém o código-fonte da aplicação.
- **src/main/resources**: Contém os arquivos de configuração, como `application.properties`.
- **pom.xml**: Arquivo de configuração do Maven.

## Dependências Principais

As dependências principais do projeto estão listadas no arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Plugins de Build

Os plugins configurados no `pom.xml` incluem:

- **Maven Compiler Plugin**: Para compilar o código com suporte ao Lombok.
- **Spring Boot Maven Plugin**: Para empacotar e executar a aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Membros
- **Victor Hugo Pereira de Melo**
