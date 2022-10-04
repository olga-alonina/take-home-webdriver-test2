Feature:
  @Test @Checkbox
  Scenario: User should be able uncheck and check boxes
    Given user on "checkboxes" page
    When user click on checkboxes
    Then status of box was changed

  @Test @Context_menu
  Scenario: User should be able to see alert menu
    Given user on "context_menu" page
    When user click on box
    Then user should be able to see alert menu

  @Test @Drag_Drop
  Scenario:user should be able to see switching texts after drags
    Given user on "drag_and_drop" page
    When user drags A to B
    Then user should be able to see switching texts

  @Test @Drop_Down_Menu
  Scenario Outline:user should be able to see selected option
    Given user on "dropdown" page
    When user click on "<option>"
    Then user should be able to see that "<option>" was selected
    Examples:
      | option      |
      | Option 1 |
      | Option 2 |

  @Test @Dynamic_Content
  Scenario: user should be able to see changes of content
    Given user on "dynamic_content" page
    When user refresh the page
    Then content should be changed

  @Test @Dynamic_Controls
  Scenario Outline:
    Given user on "dynamic_controls" page
    When user click on button "<button>"
    And uses explicit wait
    Then verify that the checkbox "<status>"
    Examples:
      | button  | status         |
      | remove  | It's gone!     |
      | add     | It's back!     |
      | enable  | It's enabled!  |
      | disable | It's disabled! |

  @Test @Dynamic_Loading
  Scenario:
    Given user on "dynamic_loading/2" page
    When user click on button start
    And uses explicit wait
    Then asserts that "Hello World!" is displayed

  @Test @File_Upload
  Scenario:upload
    Given user on "upload" page
    When clicks on "choose file"
    And clicks on "upload button"
    Then asserts that "File Uploaded!"

  @Test @File_Download
  Scenario:download
    Given user on "download" page
    When clicks on the file
    Then asserts that the file is downloaded

  @Test @Floating_Menu
  Scenario:floating menu
    Given user on "floating_menu" page
    When user scrolls the page
    Then asserts that the floating menu is still displayed

  @Test @Login
  Scenario Outline: User should be able to login
    Given user on "login" page
    When user input "<username>" and "<password>"
    Then user should able to see "<message>"
    Examples:
      | username          | password                 | message                                        |
      ##correct   1
      | tomsmith | SuperSecretPassword! |You logged into a secure area!|
        ##incorrect both   2
      | olga           | alonina                            |Your username is invalid!|
      ##wrong password   3
      | tomsmith | alonina                            |Your password is invalid!|
      ##wrong login   4
      | olga          | SuperSecretPassword! |Your username is invalid!|
      ##empty login   5
      |                   | SuperSecretPassword! |Your username is invalid!|
      ##empty password 6
      | tomsmith |                                            |Your password is invalid!|
      ##empty all
      |                    |                                           |Your username is invalid!|

  @Test @Iframe
  Scenario:iframe
    Given user on "iframe" page
    When user type text inside iframe "New Text"
    Then asserts that  text appeared as expected.

  @Test @Mouse_Hover
  Scenario:Mouse_Hover
    Given user on "hovers" page
    When user hover over on each image
    Then asserts that information is displayed for each image

  @Test @JS_Alert
  Scenario Outline:JS_Alert
    Given user on "javascript_alerts" page
    When user click on button JS "<button>"
    Then asserts alert "<message>"
    And result text will be "<result>"
    Examples:
      | button     | message           | result                           |
      | JS Alert   | I am a JS Alert   | You successfuly clicked an alert |
      | JS Confirm | I am a JS Confirm | You clicked: Ok                  |
      | JS Prompt  | I am a JS prompt  | you entered: important message  |

  @Test @JSError
  Scenario:JSError
    Given user on "javascript_error" page
    Then asserts that the page contains error: "Cannot read properties of undefined (reading 'xyz')"


  @Test @Notification_Message
  Scenario Outline: Notification_Message
    Given user on "notification_message_rendered" page
    When user clicks on the Click Here link a multiple times
    Then asserts that one of the "<message>"
    Examples:
      | message                              |
      | Action Successful                    |
      | Action unsuccessful please try again |
      | Action Unsuccessful                  |

  @Test @New_Tab
  Scenario: New_Tab
    Given user on "windows" page
    When user clicks on the Click Here link
    Then asserts that a new tab is opened with text "New Window"