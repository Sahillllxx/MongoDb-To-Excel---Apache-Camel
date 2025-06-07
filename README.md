# MongoDb-To-Excel---Apache-Camel

A simple project that demonstrates how to export data from MongoDB to an Excel file using [Apache Camel](https://camel.apache.org/).

## Overview

This repository provides an integration workflow that:
- Connects to a MongoDB database
- Retrieves documents from a specified collection
- Transforms the data as needed
- Writes the data to an Excel (.xlsx) file

The integration is built using Apache Camel, allowing for robust routing, transformation, and extensibility.

## Features

- **MongoDB Integration:** Seamlessly connect and read data from MongoDB collections.
- **Excel Export:** Automatically create and populate Excel files from MongoDB documents.
- **Configurable Routes:** Easily change source/destination and data transformation logic.
- **Extensible:** Add more processors, endpoints, or transformations as your use case evolves.

## Prerequisites

- Java 8 or higher
- Maven 3.x
- Access to a MongoDB instance

## Getting Started

1. **Clone this repository:**
   ```bash
   git clone https://github.com/Sahillllxx/MongoDb-To-Excel---Apache-Camel.git
   cd MongoDb-To-Excel---Apache-Camel
   ```

2. **Configure MongoDB Connection:**
   - Edit the configuration file (typically `application.properties` or within the Camel route) to set your MongoDB URI, database, and collection.

3. **Build the project:**
   ```bash
   mvn clean package
   ```

4. **Run the Camel application:**
   ```bash
   mvn camel:run
   ```
   or run the generated JAR file:
   ```bash
   java -jar target/mongodb-to-excel-camel-*.jar
   ```

5. **Result:**
   - After running, an Excel file will be generated with the exported data.

## Project Structure

```
.
├── src/
│   └── main/
│       └── java/        # Java source files (Camel routes, processors, etc.)
│       └── resources/   # Application configuration
├── pom.xml              # Maven dependencies and build configuration
```

## Configuration

Typical configuration options include:
- `mongodb.uri` - MongoDB connection string
- `mongodb.database` - Database name
- `mongodb.collection` - Source collection
- `excel.output.path` - Destination path for the Excel file

Configure these in your `application.properties` or as environment variables.

## Dependencies

Key dependencies:
- Apache Camel (camel-core, camel-mongodb, camel-excel or camel-poi)
- MongoDB Java driver
- Apache POI (for Excel interaction, if not provided by Camel Excel component)

See `pom.xml` for details.

## Customization

You can customize:
- The fields to export (by modifying the Camel route or processor)
- Data transformation logic (add processors for cleaning or formatting)
- Output Excel file structure (sheet names, columns, etc.)


**Contributions are welcome!**  
Feel free to fork this repo and submit pull requests or open issues.
