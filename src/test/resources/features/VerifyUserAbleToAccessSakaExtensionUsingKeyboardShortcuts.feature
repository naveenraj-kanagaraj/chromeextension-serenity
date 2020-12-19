@keyboardShortcuts
Feature: Verify User Able To Access Saka Extension Using Keyboard Shortcuts

  Scenario: Verify User Able to Change the modes in saka Using SPACE Key
    Given open browser
    Given open new tab with "https://stackoverflow.com/" and store it in session variable "tab1"
    Then open The Saka Homepage
    And Verify Selected Option In Saka HomePage is "Tabs"
    Then Press Keyboard shorcuts to change mode
    And Verify Selected Option In Saka HomePage is "Recently Closed"
    Then Press Keyboard shorcuts to change mode
    And Verify Selected Option In Saka HomePage is "Bookmarks"
    Then Press Keyboard shorcuts to change mode
    And Verify Selected Option In Saka HomePage is "History"
    Then Press Keyboard shorcuts to change mode
    And Verify Selected Option In Saka HomePage is "Recently Viewed"
    Then Press Keyboard shorcuts to close saka
    And Swtich to tab of Name "tab1"


  Scenario: Verify User Able to Change The Saka Search to Desired Modes Using Keyboard Shortcuts
    Given open new tab with "https://google.com/" and store it in session variable "tab2"
    Then open The Saka Homepage
    And Verify Selected Option In Saka HomePage is "Tabs"
    Then press Keyboard shortcuts to Switch To saka Bookmark Search
    And Verify Selected Option In Saka HomePage is "Bookmarks"
    Then press Keyboard shortcuts to Switch To saka History Search
    And Verify Selected Option In Saka HomePage is "History"
    Then press Keyboard shortcuts to Switch To saka Recently Closed Tabs Search
    And Verify Selected Option In Saka HomePage is "Recently Closed"
    Then press Keyboard shortcuts to Switch To saka Tabs Search
    And Verify Selected Option In Saka HomePage is "Tabs"
    Then Press Keyboard shorcuts to close saka
    And Swtich to tab of Name "tab2"
