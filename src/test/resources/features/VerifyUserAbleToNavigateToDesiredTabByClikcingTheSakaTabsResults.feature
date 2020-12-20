@TabResults
Feature: User Navigate From Saka TabsResults

  Scenario: Verify User Able To Navigate To Desired Tab By Clikcing The Saka TabsResults
    Given open browser
    Given open new tab with "https://stackoverflow.com/" and store it in session variable "tab1"
    Given open new tab with "https://www.linkedin.com/" and store it in session variable "tab2"
    Given open new tab with "https://www.facebook.com/" and store it in session variable "tab3"
    Given open new tab with "https://www.google.com" and store it in session variable "tab4"
    Given open new tab with "https://www.github.com" and store it in session variable "tab5"
    Then open The Saka Homepage
    And Verify Selected Option In Saka HomePage is "Tabs"
    Then Get the "4"th result url and store it in session variable "ResultUrl"
    And Click "4" th result in the saka Tab mode
    And Verify current url is equal to "ResultUrl"