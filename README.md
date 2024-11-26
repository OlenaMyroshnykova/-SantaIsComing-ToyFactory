# SantaIsComingToyFactory

## 🎅 Project Description
SantaIsComingToyFactory is a console application designed to manage the creation and storage of toys in Santa Claus's factory. This system allows elves to add, view, and delete toys, while Santa can oversee the toy lists and export them to a CSV file.

## 🛠️ Key Features
- **Toy Management**:
  - Elves can add good and bad toys to the inventory.
  - View all toys in the inventory.
  - Remove defective or unwanted toys.
- **Exclusive Features for Santa Claus**:
  - Check lists of toys for good and bad children.
  - Save the complete inventory to a CSV file.
- **MVC Architecture**:
  - Implementation of the Model-View-Controller architectural pattern.
  - Use of the Repository pattern for data persistence.
    
## Prerequisites

To run this project, you need to have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 11 or higher).
- [JUnit](https://junit.org/junit5/) for running tests.
- [Hamcrest](http://hamcrest.org/JavaHamcrest/) for flexible assertions in tests.
- [Maven](https://maven.apache.org/) for dependency management and build tasks.
- [Jira](https://www.atlassian.com/software/jira) for management.

## 🚀 Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/OlenaMyroshnykova/SantaIsComingToyFactory.git

## Project Structure

  - src/main/java:
  - controllers: Controllers managing system logic.
  - models: Classes representing good and bad toys.
  - views: User interaction via the console.
  - repository: Management of data persistence.
  - db: Simulated databases for toys.
  - singletons: Singleton management for database instances.
  - src/test/java:

   
## Unit tests to verify functionality across different system components.

<img src="./src/images/coverage.png" title="coverage report" alt="coverage report"/>

📖 Usage Example
Elf
-----------------------------------------
Toy Manager (Session Type: Elf)
1. Add toy
2. View all toys
3. Remove toy
4. Log out
Select an option: 1
-----------------------------------------
For a child...:
1. Good
2. Bad
Select an option: 1
Enter the title: LEGO City
Enter the brand: LEGO
Enter the recommended age: 8
Enter the category: Construction
Toy added successfully.


Santa Claus

-----------------------------------------
Toy Manager (Session Type: Santa Claus)
1. View list of toys for good children
2. View list of toys for bad children
3. Save the full toy list to CSV
4. Log out
Select an option: 3
List saved successfully to Toys.csv.

## Activity diagram

```mermaid
flowchart TB
    A((Inicio))
    A --> B[/Seleccionar tipo de usuario/]
    B -->|Elfo| C[Menú Elfo]
    B -->|Santa| D[Menú Santa]

    %% Bloque para Elfo
    C --> E[Añadir juguete]
    E --> E1[/Seleccionar tipo de juguete: para niño bueno o niño malo/]
    E1 --> E2[/Ingresar información del juguete/]
    E2 --> C

    C --> F[Ver todos los juguetes]
    F --> F1[Mostrar todos los juguetes]
    F1 --> C

    C --> G[Eliminar juguete]
    G --> G1[/Ingresar identificador del juguete/]
    G1 --> G2[Eliminar juguete]
    G2 --> C

    C --> H[Cerrar sesión]
    H --> Z[Menú principal]

    %% Bloque para Santa
    Z --> D
    D --> I[Ver juguetes para niños buenos]
    I --> I1[Mostrar juguetes para niños buenos]
    I1 --> D

    D --> J[Ver juguetes para niños malos]
    J --> J1[Mostrar juguetes para niños malos]
    J1 --> D

    D --> K[Guardar lista de juguetes en formato .csv]
    K --> K1[Guardar archivo .csv]
    K1 --> D

    D --> L[Cerrar sesión]
    L --> Z

    %% Cerrar programa
    Z --> X((Cerrar programa))
```

## Classes diagram

```mermaid
classDiagram
    direction LR

    class App {
        +main(String[] args)
    }

    class MainController {
        +index()
    }

    class MainView {
        +start()
        +quit()
    }

    class ElfView {
        +menu()
        +deleteToy()
        +displayAllToys()
        +selectChild()
        +postGoodToy()
        +postBadToy()
        +addToyResponse()
        +closeSession()
    }

    class SantaView {
        +menu()
        +viewGoodToys()
        +viewBadToys()
        +saveAllToysToCSV()
        +closeSession()
    }

    class Toy {
        -String id
        -String title
        -boolean isGoodToy
        +getId(): String
        +getTitle(): String
        +isGoodToy(): boolean
        +setTitle(String title)
    }

    class GoodToy {
        -String brand
        -int targetAge
        -String category
        +getBrand(): String
        +getTargetAge(): int
        +getCategory(): String
        +setBrand(String brand)
        +setTargetAge(int targetAge)
        +setCategory(String category)
    }

    class BadToy {
        -String content
        +getContent(): String
        +setContent(String content)
    }

    class ToyController {
        +postGoodToy(GoodToyDTO toyDTO)
        +postBadToy(BadToyDTO toyDTO)
    }

    class ToyRepository {
        +saveGoodToy(GoodToy toy)
        +saveBadToy(BadToy toy)
        +deleteToyById(String id): boolean
        +getAllToys(): List<Object>
    }

    class ToysDB {
        -List<GoodToy> goodToys
        -List<BadToy> badToys
        +getGoodToys(): List<GoodToy>
        +getBadToys(): List<BadToy>
        +addGoodToy(GoodToy toy)
        +addBadToy(BadToy toy)
        +clear()
    }

    class GoodToyDTO {
        -String title
        -String brand
        -int targetAge
        -String category
        +getTitle(): String
        +getBrand(): String
        +getTargetAge(): int
        +getCategory(): String
    }

    class BadToyDTO {
        -String title
        -String content
        +getTitle(): String
        +getContent(): String
    }

    App --> MainController
    MainController --> MainView
    MainView --> ElfView
    MainView --> SantaView
    ElfView --> ToyController
    SantaView --> ToyController
    ToyController --> ToyRepository
    ToyRepository --> ToysDB
    ToysDB --> GoodToy
    ToysDB --> BadToy
    Toy <|-- GoodToy
    Toy <|-- BadToy
    ToyController --> GoodToyDTO
    ToyController --> BadToyDTO
```
