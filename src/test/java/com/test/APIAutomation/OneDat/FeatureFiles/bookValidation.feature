Feature: Validating Library Api's
@bookApi
Scenario:Verify adding book api's using AddBookApi
         Given Add book payload with "python" "klm" 236 "deepa"
         When user calls bookApi "AddBookApi" with "post" http request
         Then the bookApi call is success with status code 200
         And verify expected name in books is "python" using "GetBookApi"
     
Scenario:verify delete book api's using DeleteBookApi
         Given Delete payload for books
         When user calls bookApi "DeleteBookApi" with "post" http request
         Then the bookApi call is success with status code 200
         And "msg" in response body is "book is successfully deleted"         