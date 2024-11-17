# Dropbox API Integration with Spring Boot

Project for the Object-Oriented Programming exam, Università Politecnica delle Marche, Academic Year 2021/2022

<a name="index"></a>

## 📘 Table of Contents

* [💡 Introduction](#introduction)
* [🗄️ Data Structure](#data-structure)
* [🚀 API Requests](#api-requests)
* [📊 Response Examples](#response-examples)
* [🔎 Filters](#filters)
* [📐 UML Diagrams](#uml-diagrams)
* [🧪 Tests](#tests)
* [🛠️ Get Started](#get-started)
* [📚 Framework & Software](#framework-software)
* [👨🏻‍💻 Authors](#authors)

<a name="introduction"/></a>

## 💡 Introduction

This project is a Web Service that allows a client (e.g., Postman) to interact with Dropbox APIs via GET requests. The service enables operations on a specific Dropbox account, such as:

* Displaying all files in JSON format
* Obtaining statistics on the data
* Filtering data based on various parameters
* Obtaining statistics on filtered data

The project uses the Spring Boot framework. You can run the application from Eclipse by selecting "Run as: SpringBoot App," which starts a Tomcat server on port 8080.

<a name="data-structure"/></a>

## 🗄️ Data Structure

The data are structured with the following fields:

1. File/folder name
2. File/folder path
3. File extension
4. Last modified date
5. File size
6. Attribute indicating if the file is shared

<a name="api-requests"/></a>

## 🚀 API Requests

| Type | Route | Function |
| ---- | ----- | -------- |
| `GET` | /data | Returns all files in the Dropbox account as JSON |
| `GET` | /stats/dates/mostrecent/{extension} | Returns a **DataModel** with the most recent file of the specified extension |
| `GET` | /stats/dates/leastrecent/{extension} | Returns a **DataModel** with the least recent file of the specified extension |
| `GET` | /stats/size/biggestfile/{extension} | Returns a string with the name and size of the largest file for the specified extension |
| `GET` | /stats/size/smallestfile/{extension} | Returns a string with the name and size of the smallest file for the specified extension |
| `GET` | /stats/size/higherdim/{size} | Returns the number of files larger than the specified size, grouped by extension |
| `GET` | /stats/size/lowerdim/{size} | Returns the number of files smaller than the specified size, grouped by extension |
| `GET` | /stats/shared/extension/{extension} | Returns the number of shared files for the specified extension |
| `GET` | /stats/shared/folder | Returns the number of shared files in the specified folder, grouped by extension |
| `GET` | /filter/*type*/*parameter* | Returns the filtered Dropbox data based on the specified criteria |

**Note**: For requests marked with (X), allowed extensions for demonstration purposes are ".pdf", ".xls", ".jpg", ".doc", ".pptx".

<a name="response-examples"/></a>

## 📊 Response Examples

**GET /data**
```json
[
    {
        "tag": "folder",
        "name": "subfolder",
        "extension": "null",
        "id": "id:bzscu_Fx4CUAAAAAAAAAMw",
        "server_modified": "null",
        "size": 0,
        "path": "/OnlyMine/subfolder",
        "shared": false
    },
    {
        "tag": "file",
        "name": "report copy.doc",
        "extension": ".doc",
        "id": "id:bzscu_Fx4CUAAAAAAAAAOQ",
        "server_modified": "2021-12-27T18:21:59Z",
        "size": 102912,
        "path": "/OnlyMine/subfolder/report copy.doc",
        "shared": true
    }
]
```

**GET /stats/dates/mostrecent/.pdf**
```json
{
    "year": 2022,
    "month": 1,
    "day": 4,
    "name": "Exercise23.11.pdf"
}
```

**GET /stats/size/biggestfile/.doc**
```txt
The biggest .doc file is "report copy.doc" with a size of 12,864 kilobytes.
```

**GET /stats/size/higherdim/10000 (same for lowerdim)**
```txt
Files larger than 10,000 bytes:
7 PDF files
1 Excel document
5 JPG images
1 PowerPoint presentation
3 Word documents
```
**GET /stats/shared/extension/.jpg**
```txt
The number of .jpg files shared is: 2
```
**GET /stats/shared/folder?path=/Only mine**
Returns a JSON *SharedModel* showing the count of shared files by extension in the specified folder, along with the total count.
```json
{
    "tot": "Shared per folder: 1",
    "extension1": ".pdf: 1",
    "extension2": ".xls: 0",
    "extension3": ".jpg: 0",
    "extension4": ".pptx: 0",
    "extension5": ".doc: 0"
}
```

<a name="filters"/></a>

## 🔎 Filters

The available filter types are:

* **Name**: Returns files whose names start with the specified letter.
* **Extension**: Returns files with the specified extension.
* **Date**: Returns files last modified on the specified date.
* **Path**: Returns files containing the specified path segment.
* **Size**:
  * **Bigger**: Returns files larger than the specified size.
  * **Smaller**: Returns files smaller than the specified size.

<a name="uml-diagrams"/></a>

## 📐 UML Diagrams

### Use Cases:
![Use Cases](https://user-images.githubusercontent.com/94174873/148401729-b00089d1-46b9-40dc-b74a-e57846018dee.png)

### Packages:
![Packages](https://user-images.githubusercontent.com/94174873/148985484-ac2cc4d0-9e31-4ca8-b365-d5f097686af0.png)

### Utility:
![Utility](https://user-images.githubusercontent.com/94174873/148401945-909c90e9-3764-4b98-9f52-b9f5d4177a61.png)

### Filters:
![Filters](https://user-images.githubusercontent.com/94174873/148402087-0d033e18-3e9a-4ac8-8aca-f4fef3bcba2e.png)

### Stats:
![Stats](https://user-images.githubusercontent.com/94174873/148517357-9a1b9de8-53ca-4422-a39d-04a52c2b0a99.png)

### Exceptions:
![Exceptions](https://user-images.githubusercontent.com/94174873/148402114-4ffc7d9c-1508-4c8b-abec-860e82f29d3c.png)

### Controller:
![Controller](https://user-images.githubusercontent.com/94174873/148406449-b130c00b-d6a8-4a06-ae19-6afcd26066e5.png)

### Sequences:
#### get data
![get data](https://user-images.githubusercontent.com/94174873/148406587-5eb0c841-c898-4076-bb0f-30adb4ebb246.png)

#### get stats on dates
![dates1](https://user-images.githubusercontent.com/94174873/148406599-c3b6388a-44b0-478a-a946-3bf63ec0afdf.png)

![dates2](https://user-images.githubusercontent.com/94174873/148406617-2b281baa-37cd-46ad-8d0f-4b1e292a3e60.png)

#### get stats on size
![size1](https://user-images.githubusercontent.com/94174873/148406642-205640cf-a755-460a-9f6b-acb9cc1bd65f.png)

![size2](https://user-images.githubusercontent.com/94174873/148406662-0c703d45-9176-4229-a6a1-fa084bf6bf7c.png)

![size3](https://user-images.githubusercontent.com/94174873/148406680-23b222fd-e980-49f5-b36c-74039cc7dc9d.png)

![size4](https://user-images.githubusercontent.com/94174873/148406705-d9f7717d-8195-4b93-8de3-3fcac9af4935.png)

#### get stats on shared files
![shared1](https://user-images.githubusercontent.com/94174873/148406765-e2354979-8c05-46c2-80d4-9e2bd18e7590.png)

![shared2](https://user-images.githubusercontent.com/94174873/148406772-33e8edc0-b315-4d5e-b6a9-cdfce1715aaa.png)

#### get filters
![generic filter](https://user-images.githubusercontent.com/94174873/148406791-327c75eb-37d3-4e52-9f0d-7d1b2d1bcde4.png)

<a name="tests"/></a>

## 🧪 Tests

The project includes the following tests:

* **Test 1**: Checks that the filtered lists are not empty.
* **Test 2**: Verifies that the generated JSON is not empty.
* **Test 3**: Ensures there are no discrepancies between the generated JSONs.

<a name="get-started"/></a>

## 🛠️ Get Started

1. Open Eclipse.
2. Launch the application as a Spring Boot App.
3. Open Postman.
4. Send requests to the exposed APIs as listed in the table.

<a name="framework-software"/></a>

## 📚 Framework & Software

* **jsonsimple**: Library used to model JSON files as Java objects.
* **Eclipse**: Integrated Development Environment (IDE) used for the project.
* **Spring (v2.6.1)**: Framework for Java-based web application development.
* **Maven**: Build automation tool used for dependency management.
* **JUnit**: Framework for unit testing.
* **Postman**: Tool used to make HTTP requests to http://localhost:8080.
* **VisualParadigm**: Tool for creating UML diagrams.

<a name="authors"/></a>

## 👨🏻‍💻 Authors

| Name | Email | Contribution |
| ---- | ----- | ------------ |
| Pierandrea Porfiri | porfiripierandrea@gmail.com | 50% |
| Federico Staffolani | fede01staf@gmail.com | 50% |
