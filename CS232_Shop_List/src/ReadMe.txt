Healthy Economics (text width is 80 characters)

Summary

This is a shopping application for creating healthy shopping lists.  Data is 
persisted and it would be possible to expand the application to track calories 
and nutritional information when the groceries are consumed as well.  The
application was created for Mike Tizio's CS 232 class at Boston University in 
the fall of 2018.

Description of Architecture

The code is heavily object oriented and the included HealthEconomics.xml UML 
diagram (created using the free draw.io app) describes the relationship
between objects described here:
  - Class UserList - all account (the application support multiple accounts)
  - Class User - user's info and a user owns a ProductList and ShoppingList
  - Class ShoppingList - user's shopping list
  - Class ShoppingListProduct - instance of a Product on the list
  - Class Product - product with nutritional info that can be purchased
  - Class ProductList - all products that have been added to the application
  - Class ApplicationInterface - all interfaces for input and output 

There are also three abstract classes ItemBase, ListItemBase and ListBase that
would help support expansion to different (non-shopping) lists.  Additional 
classes are used to organize code and support testing and exception handling.

Instruction

When the program is started the previous session is automatically loaded.
This logic is controlled in the ApplicationInterface class.

  1. Welcome Screen - options:
     a) Setup new user
     b) Open existing user
     c) Exit the application
     d) Enter testing mode option

  2. Main Shopping List Interface - options:
     a) Add a Product
     b) Remove a Product
     c) Update priority of a list item
     d) Sort the list by priority
     e) Display the list
     f) Assign prices to list items
     g) Go shopping and purchase products
     h) Enter testing mode options
     i) Exit - back to Welcome Screen

Java and Software Engineering

Demonstrated design, problem solving and programming concepts:
  - Flow of control - branching and loops are numerous
  - Inheritance
  - Polymorphism
  - Encapsulation
  - Abstract classes
  - Interfaces
  - Exception handling
  - Streams and file I/O to binary and text files to persist and share data
  - Dynamic data structure ArrayList (Array was used in early versions)
  - Recursion through implementation of merge sort
  

ToDo
Add Partial Fill
Start removing purchased items b/c they break partial fill
Add ability to delete a product from product list.
Make is so that you can delete a user.
Make it so that you cannot add a duplicate user.
Handle when there are no saved users.
When adding a product to the shopping list check if the product already exists.
implement show just purchased in shoppinglistinterfacedisplaylist
implement setters and getters for nutritional information



Done
Format displayed List - doe this through the interface section.
Implement go shopping.
Implement write to text file.
implement get prices
Add quantity to display.
test interface should be moved to a separate section similar to start interface and shopping list interface
shopping list interface code in the switch statement should be moved to methods to better organize code.
Add sorting.
Add interface
Persist data by saving to a file.
Display List
Add equals method to ShoppingList
Add equals method to ShoppingListProduct
Add equals method to Product