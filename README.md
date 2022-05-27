This is a `Spring Boot` starts and exposes four (4) endpoints as listed below

1. List Students `localhost:8080/students/list` - `GET`
2. Get Student by Id `localhost:8080/students/{sid}` - `GET`
3. Delete Student by Id `localhost:8080/students/{sid}` - `DELETE`
4. Create Student `localhost:8080/students` - `POST`

This `TinyService` is backed by an `in-memory` database called `h2` that is pretty straight-forward to setup. All that is needed to do is

- Drop a `data.sql` file in the `/src/main/resources` and upon start up those SQLs will be executed
- Add a few configuration to the `application.properties` in order to enable the `h2` database as well as to enable the `h2-console` that is accessible depending on server url `localhost:8080/h2-console` (when the application is running).

**Note**: The `in-memory` version of `h2` means the content of the database will only live during the life-cycle of the application.

Upon start-up of the application we have `PopulateDatabase` class that basically uses `Spring Data` repository to create `20K` Student object and `Bulk Save` it in the db. So once your application is started, you have `20K` records. You can `increase/decrease` this as you wish.

**Note:** When navigating to `h2-console` don't forget to update the `JDBC url` to point to the same that is in `src/main/resources/application.properties`
