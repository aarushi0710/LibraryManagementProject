# Simple Library Management System

A modular, console-driven Java application built to streamline basic library inventory and circulation operations using native Java Object Serialization for local data persistence.

---

## 1. Project Overview
The **Simple Library Management System** provides an efficient solution for small departmental libraries and resource centers to manage physical book collections. It eliminates the need for manual record-keeping while avoiding the complex setups required by enterprise database systems.

The system operates completely through a command-line interface, enabling administrators to register books, view catalogs, issue and return items, and save state automatically across sessions without external database dependencies.

---

## 2. Key Features
- **Book Management**: Add new books to the system with a unique Book ID and title.
- **Catalog Inspection**: Display the complete list of books along with their current status (`Available` or `Issued`).
- **Circulation Control**: Process book issuance and returns with built-in status validation.
- **Local Data Persistence**: Automatically loads existing library data from `library_data.txt` on launch and saves updated state upon exit.

---

## 3. Technologies Used
- **Programming Language**: Java (JDK 17 or higher recommended)
- **Core Libraries**: `java.util.*`, `java.io.*`
- **Persistence Strategy**: Native Java Object Serialization (`java.io.Serializable`)
- **Version Control**: Git & GitHub

---

## 4. Setup & Execution Instructions

### Prerequisites
- Installed **Java Development Kit (JDK 8+)**.

### Step 1: Clone the Repository
