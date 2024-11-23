# Project in dev








# SantaIsComing-ToyFactory
Santa Toy Factory is a console-based application for managing toy inventory, designed using the MVC (Model-View-Controller) architecture. It helps Santa's elves to register, view, and delete toys, while Santa can review toy lists and export them as CSV files.
## Features

### For Elves:
1. **Add toys:**
   - Toys for good children (including title, brand, age range, and category).
   - Toys for naughty children (including title and content).
2. **View all toys.**
3. **Delete toys from the inventory.**
4. **Log out of the session.**

### For Santa:
1. **View a list of toys for good children.**
2. **View a list of toys for naughty children.**
3. **Save the list of all toys as a CSV file.**
4. **Log out of the session.**

## Project Structure

## Activity diagram

```mermaid
flowchart TD
    A((Inicio)) --> B[/Seleccionar tipo de usuario/]
    B -->|Elfo| C[Menú Elfo]
    B -->|Santa| D[Menú Santa]

    %% Bloque para Elfo
    C --> E[Añadir juguete]
    C --> F[Ver todos los juguetes]
    C --> G[Eliminar juguete]
    C --> H[Cerrar sesión]

    E --> E1[/Seleccionar tipo de juguete: para niño bueno o niño malo/]
    E1 --> E2[/Ingresar información del juguete/]
    E2 --> C

    F --> F1[Mostrar todos los juguetes]
    F1 --> C

    G --> G1[/Ingresar identificador del juguete/]
    G1 --> G2[Eliminar juguete]
    G2 --> C

    H((Sesión cerrada))

    %% Bloque para Santa
    D --> I[Ver juguetes para niños buenos]
    D --> J[Ver juguetes para niños malos]
    D --> K[Guardar lista de juguetes en formato .csv]
    D --> L[Cerrar sesión]

    I --> I1[Mostrar juguetes para niños buenos]
    I1 --> D

    J --> J1[Mostrar juguetes para niños malos]
    J1 --> D

    K --> K1[Guardar archivo .csv]
    K1 --> D

    L --> H

```

## Classes diagram

```mermaid
classDiagram
    class Toy {
        - String title
        + Toy(String title)
        + String getTitle()
        + void setTitle(String title)
        + String getDetails()
    }

    class GoodToy {
        - String brand
        - String ageRange
        - String category
        + GoodToy(String title, String brand, String ageRange, String category)
        + String getDetails()
        + String getBrand()
        + void setBrand(String brand)
        + String getAgeRange()
        + void setAgeRange(String ageRange)
        + String getCategory()
        + void setCategory(String category)
    }

    class BadToy {
        - String content
        + BadToy(String title, String content)
        + String getDetails()
        + String getContent()
        + void setContent(String content)
    }

    class ToyRepository {
        + void add(Toy toy)
        + void delete(String title)
        + List<Toy> findAll()
        + Toy findByTitle(String title)
    }

    class InMemoryToyRepository {
        - List<Toy> toys
        + void add(Toy toy)
        + void delete(String title)
        + List<Toy> findAll()
        + Toy findByTitle(String title)
    }

    class ToyService {
        - ToyRepository repository
        + ToyService(ToyRepository repository)
        + void addToy(Toy toy)
        + void deleteToy(String title)
        + List<Toy> getAllToys()
        + List<Toy> getToysByType(Class<? extends Toy> type)
    }

    class ToyView {
        - ToyService toyService
        + ToyView(ToyService toyService)
        + void displayMenu()
    }

    class SantaToyFactoryApp {
        + static void main(String[] args)
    }

    Toy <|-- GoodToy
    Toy <|-- BadToy
    ToyRepository <|-- InMemoryToyRepository
    InMemoryToyRepository <-- ToyService : uses
    ToyService <-- ToyView : uses
    SantaToyFactoryApp --> ToyView : interacts
```
