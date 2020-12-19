@defaultMode
Feature: Verify User able to set the Default Mode

  Scenario Outline: Verify User able to set the Default Mode of the saka Chrome Extension
    Given open browser
    Then Make default mode of saka as <Mode>
    Then open The Saka Homepage
    And Verify Selected Option In Saka HomePage is <Mode>
    Examples:
      | Mode                |
      | "Recently Closed"   |
      |  "Bookmarks"        |
      |   "History"         |
      |   "Recently Viewed" |
      |   "Tabs"            |

