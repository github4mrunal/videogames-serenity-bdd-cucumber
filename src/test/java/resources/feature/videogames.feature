Feature:  Testing different request on the video games application

  Scenario Outline: Create a videogame and verify if videogame is added
    When I create a new videogame by providing the information name "<name>" releaseDate "<releaseDate>" rating "<rating>"
    Then I verify the videogame is created

    Examples:
      | name        | releaseDate              | rating    |
      | Race Peguin | 2021-07-31T19:08:27.609Z | Universal |

  Scenario: Getting videogame information by Id
    When I send GET request to videogames endpoint with Id "id",I should received the videogame information

  Scenario: Update a created videogame & verify if the videogame is updated
    When  I update a created videogame by providing the new name"<name>" category and rating
    Then I verify the videogame is updated

  Scenario: Delete a created videogame & verify the videogame is deleted
    When I delete a created videogame ,they must get back a valid status code is 200


  Scenario: Verify if the video games application can be accessed by users
    When User sends a GET requets to videogames endpoint, they must get back a valid status code 200

