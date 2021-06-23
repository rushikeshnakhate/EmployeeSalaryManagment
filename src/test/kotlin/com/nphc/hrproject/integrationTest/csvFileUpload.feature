Feature:  Employee Management System

  Scenario: csv file has at least one invalid row
    Given input csv file is provided with data
      | id   | login   | name         | Salary   | startdate  |
      | e001 | hpotter | Harry Potter | 12334.33 | 16-Nov-01  |
      | e002 | rwesley | Ron Weasley  | 12334.33 | 2010-12-01 |
      | e001 | hpotter | Harry Potter | 12334.33 | 16-Nov- 01 |
    When process is started
    Then all data is discarded


  Scenario:  duplicate employee id is discarded
    Given input csv file is provided with data
      | id   | login | name        | Salary   | startdate  |
      | e002 | user1 | Ron Weasley | 12334.33 | 2010-12-01 |
      | e002 | user1 | Ron Weasley | 12334.33 | 2010-12-01 |
    When process is started
    Then all data is discarded


  Scenario: csv file has at least one invalid row
    Given input csv file is provided with data
      | id   | login   | name        | Salary   | startdate  |
      | e002 | rwesley | Ron Weasley | 12334.33 | 2010-12-01 |
    When process is started
    Then data is loaded
      | e002 | rwesley | Ron Weasley | 12334.33 | 2010-12-01 |

