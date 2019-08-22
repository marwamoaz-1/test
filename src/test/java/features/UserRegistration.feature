Feature: User Registration
     I want to check that User can register in our ecommerce website
     
     Scenario Outline: User Registration
     Given the user in the home page
     When I click on register link
     And I entered "<firstname>" , "<lastname>", "<email>", "<password>"
     Then The registration page displayed successfully
     
     Examples: 
     | firsname | lastname | email  | password |
     | marwa | moaz | m2m21@gmail.com | 20201290 |
     | salma | mohamed | soso22@gmail.com |12345678 |
          