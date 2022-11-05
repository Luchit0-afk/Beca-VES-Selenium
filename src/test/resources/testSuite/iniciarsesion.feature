Feature: The board is empty?
  The game has not started yet

  Scenario: Game isn't begin and board is empty
    Given Game is begin
    When I ask the system whether board is empty
    Then The answer should be true 
