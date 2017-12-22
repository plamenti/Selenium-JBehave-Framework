Narrative:
In order to  find some information
As a  user
I want to search with Google

Scenario: Search in google
Given navigate to google
When type some <text> in search field and press enter
Then result from search is present

Examples:
|text|
|JBehave|
|Java|
|C#|
|JavaScript|