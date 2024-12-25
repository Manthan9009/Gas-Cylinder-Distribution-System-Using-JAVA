# Gas-Cylinder-Distribution-System-Using-JAVA
This repository contains the code for my second-semester project, "Gas Cylinder Distribution System." The project showcases key programming concepts and technologies, including:

. Java Programming: Core Java concepts and advanced features.
. JDBC: Database connectivity for seamless interaction with a PostgreSQL database.
. DSA (Data Structures and Algorithms): Implementation of data structures like Circular Queue and Linked List.
. DBMS: Efficient database management to handle customer data and stock information.


==> Project Overview

        The project simulates the operations of a gas cylinder distribution system. It manages:
        
        1. Customer Database: Stores and manipulates customer data.
        
        2. Stock Management: Tracks and updates the inventory of 5kg, 14.2kg, and 19kg gas cylinders.
        
        3. Dynamic Operations: Implements functionalities like adding/removing customers, selling cylinders, and stock display.


==> Database
        
        The project uses a PostgreSQL database for managing:
        
        . Customer Data: Personal and contact details of customers.
        
        . Warehouse Data: Inventory details of different types of gas cylinders.


==> Folder and File Structure
        
        The codebase is organized into the following folders and files:
        
              >Colors
              
                  C.java: Contains color codes for console-based outputs.
              
              >Database
              
                  CustomerDatabase.java: Handles operations related to the customer database.
              
                  Triggers.java: Implements database triggers for automated tasks.
              
                  WarehouseDatabase.java: Manages inventory data in the database.
              
              >DataStructure
              
                  CircularQueueMob.java: Implements a circular queue for managing operations.
              
                  LLAadhar.java: Uses linked lists to handle customer Aadhar data.
              
              >Main
              
                  Main.java: The entry point of the application, containing a switch-case structure for various functionalities.
              
              >Operations
              
                  AddCustomer.java: Adds a new customer to the database.
              
                  CallTruck.java: Manages truck loading for cylinder distribution.
              
                  DisplayStock.java: Displays the current stock of gas cylinders.
              
                  RemoveCustomer.java: Removes a customer from the database.
              
                  SearchCustomer.java: Searches for a customer in the database.
              
                  SellCylinder.java: Handles cylinder sale operations.
              
                  UpdateCustomer.java: Updates customer details.
              
              >Warehouse
              
                  Warehouse.java: Manages warehouse-related operations, including stock management and capacity tracking.

              
==> Key Features
        
        1. Dynamic Data Structures: Efficient management using Circular Queue and Linked List.
        
        2. Robust Database Interaction: Smooth integration with PostgreSQL for data persistence.
        
        3. Scalable Design: Modular architecture for ease of expansion.
        
        4. User-Friendly Interface: Simplified switch-case-based navigation for core functionalities.


==> Technologies Used
        
        . Java: For core application logic.
        
        . JDBC: For database connectivity.
        
        . PostgreSQL: For database management.
        
        . DSA: Circular Queue and Linked List implementations.


==> How to Run
        
        1. Clone this repository.
        
        2. Set up a PostgreSQL database with the required schemas and tables.
        
        3. Configure the database connection in the code.
        
        4. Compile and run Main.java to start the application.



Thank you for exploring this project. Feel free to contribute, raise issues, or provide feedback!
