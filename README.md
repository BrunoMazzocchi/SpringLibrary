# Spring Library

Library REST API developed with Java Spring boot and JWT. 




![Java](https://img.shields.io/static/v1?style=for-the-badge&message=Java&color=007396&logo=Java&logoColor=FFFFFF&label=)

![Spring](https://img.shields.io/static/v1?style=for-the-badge&message=Spring&color=6DB33F&logo=Spring&logoColor=FFFFFF&label=)

![Spring Boot](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Boot&color=6DB33F&logo=Spring+Boot&logoColor=FFFFFF&label=)

![Spring Security](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Security&color=6DB33F&logo=Spring+Security&logoColor=FFFFFF&label=)

![JSON](https://img.shields.io/static/v1?style=for-the-badge&message=JSON&color=000000&logo=JSON&logoColor=FFFFFF&label=)

## API Reference

#### Get a book

```http
  GET /books/${id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Id` | `int` | **Required**. Search a specific book with an Id.

#### Get all books

```http
  GET /books/all
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `No Parameter`      |  | **Required**. Search all books |

#### Get books by author

```http
  GET /books/author/nameOrSurname
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Name or surname`      | `String` | **Required**. Search a book with the author's name or surname (not working right now) |

### Delete a book
```http
  Delete /books/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Id`      | `int` | **Required**. Deletes a book with the specified Id. |


### Save a book
```http
  Post /books/save
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Book`      | `book` | **Required**. Saves a book with the information required. |



#### Get all borrows

```http
  GET /borrows/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `No parameter` |  | **Required**.  Gets all the borrows registered.

### Gets a specific borrow
```http
  Get /borrows/book/{bookId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Id`      | `int` | **Required**. Search a specifics borrow with a book ID |

### Gets a specific borrow
```http
  Get /borrows/student/{studentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Id`      | `int` | **Required**. Search a specifics borrow with a student ID |

### Saves a borrow
```http
  Post /borrows/save
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Borrow`      | `borrow` | **Required**. Saves a borrow with the information required.|

## Authors

- [@BrunoMazzocchi](https://www.github.com/BrunoMazzocchi)


## 🚀 About Me
I'm a student looking for opportunities as a backend developer.

