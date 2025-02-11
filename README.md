# Library-App
A Java-based Library Management System with a **GUI (Swing)**, supporting **In-Memory** and **MySQL Database** storage options.  

## Features
- Add, Search, and Remove Books
- Search by Title and Author
- Choose between In-Memory and MySQL Storage
- Swing GUI Interface

## Technologies Used
- Java 23
- Swing (for GUI)
- JDBC (for database conenction)
- MySQL (for database storage)

## Setup & Installation

### 1️⃣ **Clone the Repository**

Clone the repository to your local machine:
``` bash
git clone https://github.com/Kaloyanov5/Library-System.git
cd Library-System
```
### 2️⃣ Download JDBC Driver
To use the **DatabaseBookRepository**, you need the **JDBC driver** for MySQL:
- Download the **MySQL Connector/J** (JDBC driver) from the [official MySQL website](https://dev.mysql.com/downloads/connector/j/).
- After downloading, add the JDBC JAR file to your project classpath.

If you're using **IntelliJ IDEA**, follow these steps to add the driver:
- Open **Project Structure** (File > Project Structure).
- Navigate to **Libraries** and click the `+` sign.
- Select the downloaded JDBC JAR file to add it as a library.

### 3️⃣ **Compile and Run (Using IntelliJ or Terminal)**

#### Using IntelliJ IDEA:
- Open the project in IntelliJ IDEA.
- Select **Main.java** as the main class.
- Click **Run** ▶️.

#### Using Command Line:
```bash
javac -d out src/Main.java
java -cp out Main
```
### 4️⃣ **Database Setup (Optional)**

If you're using **DatabaseBookRepository**, follow these steps to configure the database:

- **MySQL Connection**: Ensure your database connection settings are correct in the `db_config.properties` file located in the `resources/` folder.
- **Table Creation**: Run the `schema.sql` script (found in `src/database`) in **MySQL Workbench** to create the necessary tables in your MySQL database.

## Usage
1. Run the program.
2. Select either **In-Memory Storage** or **Database Storage**.
3. Use the **GUI** to add, search, or remove books.
4. View the results in the **output area** of the GUI.

## License
This project is open-source and available under the **MIT License**.

## Contributing
Feel free to submit pull requests!
For major changes, please open an issue first to discuss your ideas
