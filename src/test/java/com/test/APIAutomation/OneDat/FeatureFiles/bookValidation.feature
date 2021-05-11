Feature: Validating Library Api's
@bookApi
Scenario:Verify adding book api's using AddBookApi
         Given Add book payload with "java" "bgi" 235 "sekhar"
         When user calls "AddBookApi" with "post" http request
         Then the Api call is success with status code 200
         And verify expected name in "books" is "java" using "GetBookApi"
       
Scenario:verify delete book api's using DeleteBookApi
         Given Delete payload for "books"
         When user calls "DeleteBookApi" with "post" http request
         Then the Api call is success with status code 200
         And "msg" in response body is "book is successfully deleted"         