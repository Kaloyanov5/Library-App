# Library-App
**Library Management System (Swing + Java)**

A simple Library Management System with a Graphical User Interface (GUI) built using Java Swing.
Users can add, search, and remove books, with the option to store books in memory or in a database.

## Features
- Add Books – Title, Author, ISBN, and Year
- Search Books – By Title or Author
- Remove Books – Using ISBN
- Choose Storage – Use either an in-memory repository or a database repository
- Error Handling – Prevents invalid inputs
- GUI Built with Swing – Easy-to-use interface

## Technologies Used
- Java 23
- Swing (for GUI)
- JDBC (for database conenction)
- MySQL (for database storage)

## Setup & Installation

1️⃣ **Clone the Repository**
``` bash
git clone https://github.com/Kaloyanov5/Library-System.git
cd Library-System
```
2️⃣ **Compile and Run (Using IntelliJ or Terminal)**

🔹 Using IntelliJ IDEA:
  - Open the project in IntelliJ IDEA
  - Select GUI.java as the main class

Click Run ▶️

🔹 Using Command Line:

``` bash
javac -d out src/Main.java
java -cp out Main
```
3️⃣ **Database Setup (Optional)**

If using DatabaseBookRepository, make sure to configure:
- MySQL connection
- Table creation SQL script

## Usage
1. Run the program
2. Choose In-Memory Storage or Database Storage
3. Use the GUI to Add, Search, or Remove books
4. View results in the output area

## License
This project is open-source and available under the MIT License.

## Contributing
Feel free to submit pull requests!
For major changes, please open an issue first to discuss your ideas
