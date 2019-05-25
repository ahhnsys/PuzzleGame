Testing Summary

**StoryBoard:**
As the Storyboard mainly consists of Android code and images, no tests were implemented for these activities.
Instead, the functions were manually tested through the emulators and on an Android device.
The following have been manually tested:
+ The Moving of an Image through the use of by "holding" a button
+ The coordinates of an ImageView by touching on it
+ The Intent from one Activity to another through the use of the A button
+ The visibility of Images
+ Background Music is playing on all activities and can be stopped

**Puzzles:**
Because most of the code and logic besides the GUI are visualized, all operations display the results directly on the screen or send a feedback, so it can be easily and directly tested manually (can cover almost all code).
All the functions were manually tested through the emulators and on an Android device.
The following have been manually tested:
+ Correct display of the layout of each level
+ Correct reading, depositing and displaying of all letter buttons
+ Real-time display of the input and correct judgment (the correct result should go to the next scene and give feedback, the error result should clear the input and screen and give feedback)
+ The correct count of the correct answer for some levels
+ The correct clear interfere letters for some levels
+ The 24 point puzzle level correctly reads the user input and parses it correctly, and it can correctly judge whether the result is correct and the input meets the requirements.
+ All control buttons (including back, clear, skip, help and check) function properly
+ All timers are accurately timed, displayed and updated correctly, properly started and terminated, and the game is properly terminated and feedback is sent at the end of the timer
Besides, JUnit tests are used to help developer judge the correctness of some methods