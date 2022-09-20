Feature: the version can be retrieved
  #Scenario: client makes call to GET /person
  #  When the client calls /person
  #  Then the client receives a person-list from database
#
#
  #  Scenario: client make a call to GET /person/Id
  #    When the client makes calls /person/Id with following parameters
  #       | person id |
   #      | 2         |
  #    Then the client receives a person with the same Id

    #  Scenario: client put a person in the database
     #   When the client makes a post to /person with the following parameters
     #   | person name | person alter | person ort|
      #  | fahd        | 18           | köln      |
       # Then the client get a ok
        #And the perosn get saved in the database

     #   Scenario: client update a person
      #    When the client makes a put to /person/id with following parameters
       #   | person name | person alter | person ort| person id|
        #  | Nico        | 20           | köln      | 2        |
         # Then the client gets a ok
          #And the person with the same id get updated

          Scenario: client delete a person by Id
            When the client makes a delete to /person/id
            |person id |
            | 102      |
            Then the client gets a Ok
            And the person gets deleted