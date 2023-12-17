Feature: Sending a message on WhatsApp Web

  Background:
    Given I open WhatsApp web
    # You may add steps here for the user to scan the QR code and log in

  Scenario: Sending a message to a contact
    When I select contact "Eswar"
    And I send message "Hey Dude sending whatsapp message through Automation - just checking"
    And I send warn message "Alert: Hello, *User!*                                                                         We suspect this user is Bot/using 3rd party Automation tools. So chat with this User restricted. Due to violating WhatsApp Privacy policy this Account has been Banned for 24 hours. If you think user is a real please connect only through *WhatsApp call Service*. Thank You!"
    And I close the browser