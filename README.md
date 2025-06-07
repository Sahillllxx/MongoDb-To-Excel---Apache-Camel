# 🚀 MongoDb-To-Excel---Apache-Camel

A hands-on Spring Boot project that demonstrates how to export data from MongoDB to an Excel file using [Apache Camel](https://camel.apache.org/).

---

## 📝 Overview

This project is designed to help you:
- 🔗 **Connect to MongoDB**: Seamlessly fetch documents from your chosen collection.
- 🔄 **Transform Data**: Process and clean data as needed.
- 📑 **Export to Excel**: Write your data into a structured Excel (`.xlsx`) file.
- ⚡ **Powered by Apache Camel & Spring Boot**: Benefit from powerful routing and easy configuration.

---

## ✨ Features

- **Spring Boot Integration**: Quick setup, dependency injection, and easy configuration.
- **MongoDB Connectivity**: Securely and flexibly connect to your MongoDB instance.
- **Excel Export**: Auto-generate Excel files from your data with customizable columns.
- **Configurable Workflows**: Modify endpoints, transformation logic, and output format as your needs grow.
- **Extensible Architecture**: Add more processors, endpoints, or transformation rules as required.

---

## 🚦 Prerequisites

- [Java 8+](https://adoptopenjdk.net/)
- [Maven 3.x](https://maven.apache.org/)
- [MongoDB](https://www.mongodb.com/) instance (local or remote)

---

## ⚡ Quick Start

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Sahillllxx/MongoDb-To-Excel---Apache-Camel.git
   cd MongoDb-To-Excel---Apache-Camel
   ```

2. **Configure MongoDB & Output**
   - Open `src/main/resources/application.properties` and set:
     ```properties
     spring.data.mongodb.uri=mongodb://localhost:27017/your-db
     mongodb.collection=your-collection
     excel.output.path=output.xlsx
     ```
   - Or use environment variables for secret values.

3. **Build the Project**
   ```bash
   mvn clean package
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   _or run the JAR:_
   ```bash
   java -jar target/mongodb-to-excel-camel-*.jar
   ```

5. **Check the Result**
   - After a successful run, find your Excel file at the specified output path!

---

## 📁 Project Structure

```
.
├── src/
│   └── main/
│       ├── java/        # Spring Boot application, Camel routes, processors
│       └── resources/   # application.properties, additional configs
├── pom.xml              # Maven dependencies and build configuration
```

---

## ⚙️ Configuration

All configs can be set in `application.properties`:
- `spring.data.mongodb.uri` – MongoDB connection string
- `mongodb.collection` – Collection to export from
- `excel.output.path` – Where to save the generated Excel file

---

## 🧩 Dependencies

Key dependencies include:
- `spring-boot-starter`
- `camel-spring-boot-starter`
- `camel-mongodb`
- `camel-excel` or `camel-poi`
- `mongodb-driver-sync`
- `apache-poi` (if not included in Camel Excel)

Details in [`pom.xml`](./pom.xml).

---

## 🛠️ Customization Tips

- Change which fields export: Edit the Camel route or custom processor.
- Transform/clean data: Add more processors for formatting or calculations.
- Modify Excel: Adjust column names, sheet names, or file structure.

---

## 🤝 Contributing

Contributions are welcome!  
Feel free to fork, open issues, or make pull requests.

---

## 📣 Feedback

Questions, suggestions, or want to show off your usage?  
Open an [issue](https://github.com/Sahillllxx/MongoDb-To-Excel---Apache-Camel/issues) or start a discussion!

---
```
