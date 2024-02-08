# Utilization Guide for FileJumper

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
   - [Maven Dependency](#maven-dependency)
   - [Usage](#usage)
- [Supported Data Types](#supported-data-types)

---

## Introduction

Welcome to FileJumper! This library is designed to simplify working with JSON files in Java. It provides convenient methods and tools to manipulate JSON data effortlessly.

This README serves as a guide to help you understand how to use the library effectively and efficiently.

## Getting Started

### Maven Dependency

To use FileJumper in your Maven project, you can add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.github.2166057</groupId>
    <artifactId>filejumper</artifactId>
    <version>2.0.1</version>
</dependency>
```

### Usage

To use the `JsonFileCreator` for creating or editing a JSON file, follow the steps outlined below:

1. **Instantiate JsonFileCreator:**
    ```java
    JsonFileJumper jsonFileJumper = FileJumper.createJsonFileJumper(new File("foo.json"));
    ```
   This creates a new instance of `JsonFileCreator`, specifying the target JSON file (`foo.json` in this example).  


2. **Edit the JSON file with a template:**

   what is a template? A template is a series of actions that will be performed on the JSON file to retrieve and modify data, it allows you to set a default value for each field in the JSON file, and then modify the fields as needed.

   ```java
    JsonFileJumper jsonFileJumper = FileJumper.createJsonFileJumper(new File("foo.json"));
    jsonFileJumper.editWithTemplate(new JsonJumperTask() {
        @Override
        public void editTemplate(JsonFileModificator jsonFileModificator) {
        //Your code here
        }
    });
    ```

   inside the `editTemplate` method, you can perform actions such as:

   ```java
    Integer integer = jsonFileModificator.getIntValue("integer", 0);
    String string = jsonFileModificator.getStringValue("string", "default");
    Boolean bool = jsonFileModificator.getBooleanValue("bool", false);
    ```
   
   if the field does not exist in the JSON file, the default value will be used and created inside the file for you.


3. **Modify without a template:**
 
   to modify a JSON file without using a template your can use the `JsonFileModificator` dirrectly from the `JsonFileJumper`

    ```java
     jsonFileJumper.getJsonFileModificator(); 
     ```
   
   you can perform the same actions as in the template, but you will have to save the changes manually.  


4. **Save the changes:**

   After modifying the JSON file, you can save the changes by calling the `save` method:

    ```java
    jsonFileJumper.save();
    ```
   
    _Note: The `save` method is not required if you are using the `JsonJumperTask` with a template._
## Supported Data Types

`FileJumper` supports the following data types for interacting with JSON files:

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

