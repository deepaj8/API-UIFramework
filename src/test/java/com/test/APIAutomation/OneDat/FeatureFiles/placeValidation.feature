Feature: Validating Place Api's
Scenario:Verify adding place api's using AddplaceApi
         Given Add place payload
         When user calls "AddPlaceApi" with post http request
         Then the Api call is success with status code 200
         And "status" in response body is "OK"