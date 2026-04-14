# Online Shop System with Design Patterns

A desktop application built with **JavaFX and SceneBuilder** that simulates a simple online shop.  
The project demonstrates the use of multiple **design patterns** in a practical, interactive environment.

---

## Project Overview

This application allows users to:
- Add and remove products
- View products in a structured table
- Receive real-time notifications when products are added
- Customize products with additional services
- Simulate payment using different payment methods

The main goal of this project is to showcase the correct implementation and integration of several **design patterns**.

---

## User Interface

The application UI is built using **JavaFX + SceneBuilder** and consists of:

- **Left panel**
  - Gift wrapping option
  - Express delivery option
  - Cart button (future functionality)

- **Center panel**
  - Product table (name, price, category, details)
  - Add and remove product buttons

- **Right panel**
  - Real-time system messages (Observer output)

 <img width="1267" height="858" alt="image" src="https://github.com/user-attachments/assets/3178aa0b-2d53-499a-ac34-ad0fa570f985" />

---

## Adding Products

When the **"Add Product"** button is pressed:
1. A popup window appears
2. User inputs:
   - Name
   - Category
   - Price
   - Quantity
   - Detail (author / brand / material)
3. Product is created via `ProductFactory`
4. Added to `Inventory`
5. Observer updates the UI

<img width="391" height="536" alt="image" src="https://github.com/user-attachments/assets/ab058ade-166d-49c7-acac-5dd567ba990c" />

---

## Removing Products

- Select a product from the table
- Press **"Remove Product"**
- Product is removed from:
  - Inventory
  - Table view

---

## Shopping cart

When the **"Go to cart"** button is pressed:
1. A new window of the shopping cart appears
2. User can choose:
   - Their method of payment
   - To remove products from the cart
   - To go back to the store
3. When the preferred method of payment is chosen, a corresponding message appears on the screen

<img width="1254" height="854" alt="image" src="https://github.com/user-attachments/assets/c24562bd-719f-43c0-923e-2e674feb2444" />

---

## Design Patterns Used

### Factory Method
Used to create different types of products.

- `ProductFactory` creates:
  - `Book`
  - `Electronics`
  - `Furniture`

Centralizes object creation and removes direct dependency on concrete classes.

---

### Singleton
Used for managing the inventory.

- `Inventory` is a singleton class
- Stores all products in one shared instance

Ensures consistent product data across the entire application.

---

### Observer
Used for notifying the UI/console when new products are added.

- `Inventory` acts as the subject
- `UIObserver` listens for changes
- `AdminLogger` listens for changes
- Messages are displayed in the UI (right-side panel) and in the console

---

### Decorator
Used to add optional services to products.

- Base: `BasicOrder`
- Decorators:
  - `GiftWrapping`
  - `ExpressDelivery`

Allows dynamic addition of features without modifying the original object.

---

### Strategy
Used for selecting different payment methods.

- Interface: `PaymentStrategy`
- Implementations:
  - `CreditCard`
  - `BankTransfer`
  - `PayPal`

Encapsulates payment logic and allows runtime selection of behavior.

---


## Technologies Used

- Java 17+
- JavaFX
- SceneBuilder
- Object-Oriented Programming (OOP)
- Design Patterns

---

## How to Run

1. Open the project in your IDE (IntelliJ / Eclipse)
2. Make sure JavaFX is configured
3. Run:

```
Launcher.java
```
---

## Author

Developed as part of a **Design Patterns project**.
