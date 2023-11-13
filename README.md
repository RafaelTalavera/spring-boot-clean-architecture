# Summary of the Spring Boot Clean Architecture Project

## Overview
This project implements a clean architecture in a Spring Boot application to manage money transfers between accounts. The project structure follows best practices and uses custom annotations to separate the application layers.

## Project Structure
1. **Web Adapters (`adapter.in_web`):**
   - `MoneyTransferController`: REST controller handling money transfer requests.

2. **Persistence Adapters (`adapter.out_persistence`):**
   - `AccountEntity`: JPA entity representing an account in the database.
   - `AccountMapper`: Converts between JPA entities and domain objects.
   - `AccountPersistenceAdapter`: Implements load and update ports for database operations.
   - `SpringAccountRepository`: JPA repository interface for account entities.

3. **Application Ports (`application.port`):**
   - `in.SendMoneyPort`: Inbound port for money transfer business logic.
   - `out.LoadAccountPort`: Outbound port for loading accounts from the database.
   - `out.UpdateAccountPort`: Outbound port for updating accounts in the database.

4. **Application Services (`application.service`):**
   - `SendMoneyService`: Implements business logic for money transfer.

5. **Domain (`domain`):**
   - `Account`: Domain object representing an account with methods to manage the balance.

6. **Custom Annotations (`common`):**
   - `PersistenceAdapter`, `UseCase`, `WebAdapter`: Custom annotations to identify layers and components in the application.

7. **Initialization Class (`Extra`):**
   - Initializes account data in the database using `SpringAccountRepository`.

8. **Spring Configuration (`application.yml`):**
   - Application, H2 database, and H2 console configuration.

## Execution
- The application is started from the `SpringBootCleanArchitectureApplication` class.
- It uses an in-memory H2 database for persistence.

## Observations
- The project follows clean architecture principles to separate layers and improve maintainability.
- Custom annotations are used to identify components and layers of the application.
- Business logic is contained in the `SendMoneyService`, separated from implementation details.
- A REST controller is included to handle money transfer requests.

This summary provides an overview of the project and its structure based on clean architecture with good development practices.
