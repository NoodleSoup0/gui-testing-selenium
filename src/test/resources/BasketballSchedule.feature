Feature: View Basketball Schedule
  As an avid Northwestern Basketball fan,
  In order to know how the team is doing,
  I want to view the team’s schedule.

Scenario: View Basketball Team Score
  Given I am using Chrome
  And I load the nusports page
  When I load the Women's Basketball schedule
  Then the schedule should display "W, 82-49"
