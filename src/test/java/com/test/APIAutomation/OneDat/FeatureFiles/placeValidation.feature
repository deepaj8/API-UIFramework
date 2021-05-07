Feature: Validating Place Api's
Scenario:Verify adding place api's using AddplaceApi
         Given Add payload with "Greenhouse" "Hindi" "india"
         When user calls "AddPlaceApi" with "post" http request
         Then the Api call is success with status code 200
         And "status" in response body is "OK"
         And verify expected name in "places" is "Greenhouse" using "GetPlaceApi"
         
Scenario:verify delete place api's using DeletePlaceApi
         Given Delete payload for "places"
         When user calls "DeletePlaceApi" with "post" http request
         Then the Api call is success with status code 200
         And "status" in response body is "OK"         