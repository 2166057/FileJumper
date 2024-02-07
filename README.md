# Utilization Guide for FileJumper

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
   - [Clone and Build](#clone-and-build)
   - [Maven Dependency](#maven-dependency)
   - [Usage](#usage)
- [Supported Data Types](#supported-data-types)

---

## Introduction

Welcome to FileJumper! This library is designed to simplify working with JSON files in Java. It provides convenient methods and tools to manipulate JSON data effortlessly.

This README serves as a guide to help you understand how to use the library effectively and efficiently.

## Getting Started

### Clone and Build

To compile, build or modify the library from source, follow the steps outlined below:

1. **Clone the FileJumper repository** to your local machine:

    ```bash
    git clone https://github.com/2166057/filejumper.git
    ```

2. Navigate to the cloned repository:

    ```bash
    cd filejumper
    ```

3. Build the library using Maven (or other build tools if applicable):

    ```bash
    mvn clean package
    ```

4. Once the build is successful, you can find the compiled JAR file in the target directory.

5. Include the JAR file in your Java project by copying it to your project's lib or libs folder.

### Maven Dependency

To use FileJumper in your Maven project, you can add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>net.wattpadpremium</groupId>
    <artifactId>filejumper</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Usage

To use the `JsonFileCreator` for creating or editing a JSON file, follow the steps outlined below:

1. **Instantiate JsonFileCreator:**

    ```java
    JsonFileCreator fileCreator = JsonFileCreator.createJsonFile(new File("./foo.json"));
    ```

   This creates a new instance of `JsonFileCreator`, specifying the target JSON file (`foo.json` in this example).

2. **Edit the JSON file with a template:**

   1.**Create Editing Task** by implementing the `JsonTask` interface. This interface has a single method `editTemplate` that takes a `JsonFileModification` object as a parameter. This object is used to interact with the JSON file.

    ```java
    fileCreator.editWithTemplate(new JsonTask() {
        @Override
        public void editTemplate(JsonFileModification jumper) {
            // Edit the JSON file here
        }
    });
    ```
   2.**Get values from the JSON file** using the `get<Type>Value` methods. These methods take two parameters: the first is the name of the property, and the second is the default value to return if the property does not exist in the file.

   ```java
    Integer integer = jumper.getIntValue("integer", 0);
    String string = jumper.getStringValue("string", "default");
    Boolean bool = jumper.getBooleanValue("bool", false);
    ```
   3.**Create or Edit a JSON Object** within the file. This involves creating a new JSON object, setting its properties, and then getting or creating a JSON object in the file using the `getJsonObject` method.

   ```java
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("integer", integer);
    jsonObject.addProperty("string", string);
    jsonObject.addProperty("bool", bool);
    
    JsonFileModification jsonFileModification = jumper.getJsonObject("jsonObject", jsonObject);
    ```

   4.**Create or Edit a JSON Array** within the file. This involves creating a default JSON array, and then getting or creating a JSON array in the file using the `getJsonArrayValue` method.

   ```java
    JsonArray defaultArray = new JsonArray();
    defaultArray.add("test");
    defaultArray.add("test2");
    defaultArray.add("test3");

    JsonArray array = jumper.getJsonArrayValue("jsonArray", defaultArray);
    ```

   5.**Set values (Override)** in the JSON file using the `set<Type>Value` methods. These methods take two parameters: the first is the name of the property, and the second is the value to set.

   ```java
    jumper.setBooleanValue("bool", true);
    jumper.setIntValue("integer", 1);
    jumper.setStringValue("string", "new value");
    ```

   Customize the code within `editTemplate` according to your specific JSON modification requirements. The numbered steps above represent different actions you might take within the template.

## Supported Data Types

`JsonFileCreator` supports the following data types for interacting with JSON files:

- String
- Integer
- Boolean
- Char
- Short
- Byte
- Long
- Float
- Double
- JSON Object
- JSON Array

These data types cover common scenarios when working with JSON files. Choose the appropriate method based on the type of data you are dealing with.

