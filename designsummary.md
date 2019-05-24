Design Summary

**Storyboard:**
The Activities within the 'Storyboard' directory each contain similar designs for consistency.
Each Activity contains three main parts of code; The Move Controls Method, The A Button Method, and the Data Method.
The Move Controls have been implemented with a onTouch as to allow continuous movement whereas the A button was separated from the controls.
The Maps have been divided into two parts, as the original idea of focusing on the character while the map was zoomed in was unachievable.
Each Maps contains puzzle chest which can be opened and Other Activities can be accessed through the use of the A button.
To make the character open the puzzles a little more realistic, coordinates have been used to set limitations on the A button.
In order to send and receive Data from the puzzle without resetting the Storyboard Activities "OnActivityResult" is used.
This is required for "items", as there are "items" that are needed to open certain puzzles,
each activity already has item images within their xml, and the items are "used" based on their visibility.
Background Music is automatically played throughout the Game with the use of "Service". However, this caused the Music to continue to
play once the App is closed and so a Play and Pause button was added in the top-left corner.

