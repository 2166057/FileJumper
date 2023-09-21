# Utilization Guide for FileJumper

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Clone and Build](#clone-and-build)
  - [Usage](#usage)
- [Examples](#examples)

---

## Introduction

Welcome to FileJumper! This library is designed to simplify working with JSON files in Java. It provides convenient methods and tools to manipulate JSON data effortlessly.

This README serves as a guide to help you understand how to use the library effectively and efficiently.

## Getting Started

### Clone and Build

To use FileJumper in your project, you can follow these steps:

1. **Clone the FileJumper repository** to your local machine:

   ```bash
   git clone https://github.com/2166057/filejumper.git
2. Navigate to the cloned repository:

    ```bash
    cd filejumper
3. Build the library using Maven (or other build tools if applicable):

    ```bash
    mvn clean package
4. Once the build is successful, you can find the compiled JAR file in the target directory.

5. Include the JAR file in your Java project by copying it to your project's lib or libs folder.

6. Add the necessary dependencies to your project's build configuration. For example, if you're using Maven, add the following dependency to your pom.xml:

    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>
    
### Usage
Now that you have FileJumper included in your project, you can start using it as described below.

To get started with FileJumper, you can create an instance of JsonFileJumper and use it as demonstrated in the following example:

    JsonFileJumper fileJumper = JsonFileTemplateBuilder.createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
        @Override
        protected void editTemplate(JsonFileJumper jumper) {
            // Perform JSON operations here
        }
    });
The JsonVerificationRunnable allows you to define your JSON operations within the editTemplate method. Here's a breakdown of some common operations you can perform:

## Examples
Let's look at a few examples to demonstrate the usage of FileJumper:

Example 1: Adding JSON Fields

    JsonFileJumper fileJumper = JsonFileTemplateBuilder.createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
        @Override
        protected void editTemplate(JsonFileJumper jumper) {
            check("Name", "John Doe");
            check("Age", 30);
        }
    });

Example 2: Writing Custom JSON Objects

    JsonFileJumper fileJumper = JsonFileTemplateBuilder.createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
        @Override
        protected void editTemplate(JsonFileJumper jumper) {
            JsonObject customObject = a JsonObject();
            customObject.addProperty("Property1", "Value1");
            customObject.addProperty("Property2", 12345);
            jumper.writeJsonObjectToFile("CustomData", customObject);
        }
    });

Example 3: Full Example

    JsonFileJumper fileJumper = JsonFileTemplateBuilder.createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
        @Override
        protected void editTemplate(JsonFileJumper jumper) {
            check("BooleanTemplateExample",true);
            check("StringTemplateExample","String");
            check("IntegerTemplateExample",123);
            check("DoubleTemplateExample",256.33);
            checkNestedDoubleValue("Nested.Double", 34234.33);
            try {
                jumper.getFileWriter().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                jumper.getFileReader().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("propertyNumber", 1234);
            jsonObject.addProperty("propertyString", "CustomObjectString");
            jumper.writeJsonObjectToFile("CustomObject",jsonObject);
        }
    });

  Resulting *File.json*

    {
      "BooleanTemplateExample": true,
      "StringTemplateExample": "String",
      "IntegerTemplateExample": 123,
      "DoubleTemplateExample": 256.33,
      "Nested": {
        "Double": 34234.33
      },
      "CustomObject": {
        "propertyNumber": 1234,
        "propertyString": "CustomObjectString"
      }
    }
