#Summary

This application took a lot longer to complete than anticipated, At first there wasn't much
difficulty, I transform the app architecture into MVVM. I create a repository to create our
Retrofit instance and call the HTTP method. The ViewModel handled the HTTP request and sends the
results to the View,  removing the networking duplications.
I updated the UI so that for the PostMetaData the view will be in a CardView. Test files has been
included, testing the network call. For loading the large data set things got complicated.
I tried implemented coroutines but it didn't really improve the UX that much, I tired implementing
Paging3 library with the same result, except the recyclerview keeps repopulating when I get to the
end. If I had more time, I would work on fixing the bug as well as include Dagger Hilt for
Dependency Injection, as well as include RoomDB to store the data into a local database, so we
get the data from the database as oppose to the server
