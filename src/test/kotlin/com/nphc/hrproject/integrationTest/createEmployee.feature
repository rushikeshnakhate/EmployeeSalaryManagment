Feature:  Employee Management System

  Scenario: create request is  raised
    Given input csv file is provided with data
      | id    | login    | name    | Salary   | startdate  |
      | e0020 | newlogin | newName | 12334.33 | 2010-12-01 |
    When process is started
    Then data is loaded
      | e0020 | newlogin | newName | 12334.33 | 2010-12-01 |

