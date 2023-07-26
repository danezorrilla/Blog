# Summary

- Transformed the app architecture into MVVM
- Created a repository to create our Retrofit instance and call the HTTP method
- Implemented ViewModel to handle the HTTP request and sends the results to the View,
  removing the networking duplications.
- Updated the UI so that for the PostMetaData, the view is in a CardView
- Implemented Unit Testing and created custom test cases for network call
- Implemented coroutines for asynchronous call
- Implemented Paging3 library that helps to load and display small data at a time

# If I had more time I would have implemented the following tasks


- Dagger Hilt for Dependency Injection
- RoomDB to store the data into a local database so that app will run in offline mode
