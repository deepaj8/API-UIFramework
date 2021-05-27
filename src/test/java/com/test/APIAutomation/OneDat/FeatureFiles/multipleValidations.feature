Feature: Validating AddBook API with multiple data

  Scenario Outline: Verify adding book api's using multiple AddBookApi
         Given Add book payload with "<sheetname>" <testcaseid>
         When user calls multiple bookApi "AddBookApi" with "post" http request
         Then the bookApi call is success with status code 200
         And delete the book with "DeleteBookApi" resource
    Examples: 
      | sheetname | testcaseid|
      |BookDetails|   1       |
      |BookDetails|   2       |
      |BookDetails|   3       |
      |BookDetails|   4       |