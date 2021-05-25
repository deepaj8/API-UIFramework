Feature: validating the authentication api's
  Scenario: Verify get courses api's 
         Given access the coursesapi with accesstoken
         When user calls coursesapi "GetCoursesApi" with get request
         Then the getInstructor in response body is "RahulShetty"