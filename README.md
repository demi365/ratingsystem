# ratingsystem
A sample spring project, that is used to learn spring boot and hibernate, along with sqlite integration

The whole system is a book rating system,
base-context of the application is '/springapp' and runs on port 8090, so as not not conflict with already running ports,
this can be modified in the application.yaml.

The API are,
'user' which accepts GET, POST, PUT, DELETE by default supported by the RepositoryRestResource
Accpets 'first_name', 'last_name', 'email'

'book' which accepts GET, POST, PUT, DELETE by default supported by the RepositoryRestResource
Accepts 'book_name'

'rating', this is written with a custom controller and a service to support the business logic,
PUT = "/{user_id}/{book_id}/{rating}" - all integers, the user_id can add a rating for the book_id
POST= "/{user_id}/{book_id}/{rating}" - all integers, the user_id can add a rating for the book_id
GET = "/{rating_id}" which can be used to fetch rating by rating_id, which is auto-generated id
DELETE = "/{rating_id}" which deleted rating by id
GET = "/" returns all the ratings ever logged

APIs tested with Postman
