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
    
### Usage
Now that you have FileJumper included in your project, you can start using it as described below.

To get started with FileJumper, you can create an instance of JsonFileCreator and use it as demonstrated in the following example:

    JsonFileCreator fileCreator = JsonFileCreator.createJsonFile(new File("./folder/foo.json"));

The JsonVerificationRunnable allows you to define your JSON operations within the editTemplate method. Here's a breakdown of some common operations you can perform:

## Examples
Let's look at a few examples to demonstrate the usage of FileJumper:

Example 1: editing a JSON file

    JsonFileCreator fileCreator = JsonFileCreator.createJsonFile(new File("./folder/foo.json"));
    fileCreator.editWithTemplate(new JsonTask() {
        @Override
        public void editTemplate(JsonFileModification fileModification) {
            fileModification.setBooleanValue("foo", true);
        }
    });

Example 2: default JSON values

    JsonFileCreator fileCreator = JsonFileCreator.createJsonFile(new File("./folder/foo.json"));
    fileCreator.editWithTemplate(new JsonTask() {
        @Override
        public void editTemplate(JsonFileModification fileModification) {
            fileModification.getBooleanValue("foo", true);
        }
    });

Example 3: Getting the values from the template

    Boolean foo = false;

    JsonFileCreator fileCreator = JsonFileCreator.createJsonFile(new File("./folder/foo.json"));
    fileCreator.editWithTemplate(new JsonTask() {
        @Override
        public void editTemplate(JsonFileModification fileModification) {
            foo = fileModification.getBooleanValue("foo", true);
        }
    });

in this example, foo will be set to true because the default value is true only if the boolean isn't present in the file.

### Supported Data Types

FileJumper supports the following data types: boolean, int, long, double, String, char, short and JSONObject.
