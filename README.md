## Demo

### Add Recognition

#### Login as a normal user 'Morgan Thompson' and move to the home page.

![Moved to the home page](README/Screen%20Shot%202021-02-14%20at%2011.02.40.png)

#### Click 'Recognize My Colleague' button. 'Select Colleague' page is displayed.

![Select Colleague page is displayed](README/Screen%20Shot%202021-02-14%20at%2011.08.41.png)

#### Enter a colleague's name and search. The result is displayed.

![Colleague's result is displayed](README/Screen%20Shot%202021-02-14%20at%2011.14.30.png)

#### Click the colleague's link. 'Select Value' page is displayed.

![Select Value page is displayed](README/Screen%20Shot%202021-02-14%20at%2011.15.33.png)

#### Click a value's link. The page of the value, and the selected colleague's name and value are displayed. The user can give input for other fields.

![The details page of the value](README/Screen%20Shot%202021-02-14%20at%2011.27.07.png)

#### Save the recognition. The same page will be used for confirmation. The names of both the colleague 'Ashton Brown' and the manager 'Kerry Jordan' are displayed in the info bar. The save button is hidden and all fields are displayed as disable for view only.

![The confirmation page](README/Screen%20Shot%202021-02-14%20at%2011.27.56.png)

#### The colleague and the manager received emails as the notification for the recognition.

![The colleague's email](README/Screen%20Shot%202021-02-14%20at%2011.32.26.png)
![The manager's email](README/Screen%20Shot%202021-02-14%20at%2011.32.31.png)

### Check Activity

#### Go back to the home page. The added recognition can be found from the activity widget below the recognition buttons.

![The home page and activities](README/Screen%20Shot%202021-02-14%20at%2011.36.33.png)

#### Click a recognition's link in activities. The view page is displayed.

![The recognition view](README/Screen%20Shot%202021-02-14%20at%2011.55.21.png)

### Check All Recognitions

#### Go back to the home page and click 'View Recognitions' button. The list of recognitions is displayed.

![The recognitions list page 1](README/Screen%20Shot%202021-02-14%20at%2011.43.34.png)
![The recognitions list page 2](README/Screen%20Shot%202021-02-14%20at%2011.43.45.png)

#### Recognitions can be searched with subject / recognizer's name / recognized colleague's name by using Liferay's search engine.

![The search result for recognitions](README/Screen%20Shot%202021-02-14%20at%2011.46.44.png)

#### Click one of 'Recognition Details' buttons. The view page of the selected recognition can also be displayed here.

![The recognition view](README/Screen%20Shot%202021-02-14%20at%2011.52.56.png)

#### Click value tabs to switch the result list for each value.

![The search result of another value](README/Screen%20Shot%202021-02-14%20at%2011.50.32.png)

## Liferay DXP Settings

### Roles

#### Created a new role called 'Organization Manager'
![Roles 1](README/Screen%20Shot%202021-02-14%20at%2012.16.59.png)
![Roles 2](README/Screen%20Shot%202021-02-14%20at%2012.22.37.png)

### Users and Organizations

#### Added organizations. The 'Finance' is used for this demo'.
![Organization](README/Screen%20Shot%202021-02-14%20at%2012.26.25.png)

#### Added users and assigned to 'Finance'.
![Users](README/Screen%20Shot%202021-02-14%20at%2012.26.42.png)

#### Modified permissions for each user to add 'View' for 'User', which makes them searchable for other users.
![User permissions 1](README/Screen%20Shot%202021-02-14%20at%2012.36.05.png)
![User permissions 1](README/Screen%20Shot%202021-02-14%20at%2012.33.55.png)

#### Assigned 'Kerry Jordan' as the 'Organization Manager' of 'Finance'.
![Organization role 1](README/Screen%20Shot%202021-02-14%20at%2012.27.18.png)
![Organization role 2](README/Screen%20Shot%202021-02-14%20at%2012.27.21.png)

### Site and page

#### Created a new site for Company X and added new users to the site.
![Site memberships](README/Screen%20Shot%202021-02-14%20at%2012.37.15.png)

#### Created a new private page for the home page.
![Pages](README/Screen%20Shot%202021-02-14%20at%2012.38.37.png)

#### Added two widgets - Recognition(customized) and Activities(built-in).
![Home page editing](README/Screen%20Shot%202021-02-14%20at%2012.40.06.png)

### Mail
#### Added mail setting to bind my gmail account for sending notification mails.
![Mail setting](README/Screen%20Shot%202021-02-14%20at%2013.11.39.png)

## Code Summary
### recog-service
#### service.xml
Entities for recognitions.
#### RecognitionLocalServiceImpl.java, PerformanceRecognitionLocalServiceImpl.java, FriendshipRecognitionLocalServiceImpl.java
Methods for adding recognitions.
#### RecognitionModelResourcePermissionRegistrar.java, RecognitionPortletResourcePermissionRegistrar.java, default.xml
Permission definitions for 'VIEW'.
#### RecognitionIndexer.java
Methods for enabling searching for recognitions.
### recog-web
#### RecognitionPortlet.java
Methods for page rendering and actions.
#### RecognitionActivityInterpreter.java
Methods for rendering in Activities widget for recognitions.
#### view.jsp
The first page showing 'Recognize My Colleague' and 'View Recognitions' buttons.
#### select-colleague.jsp
The page to search and select colleagues.
#### select-value.jsp
The page to select values.
#### recognition.jsp
The page to entry details and save for recognition. Also, the same page is used for view recognition after saving by using different view mode.
#### recognition-list,jsp, recognition-actions.jsp
The page to search and display the list for recognitions.
#### default.xml
Permission definitions for 'VIEW'.
