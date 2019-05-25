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

**Puzzles:**
The Activities within the 'Puzzles' directory each also contain similar designs for consistency.
Most of the levels in the puzzles are word guessing puzzles, to make game not so boring, some other kind of puzzles are also been added.
And there are three forms of word guessing puzzles.
The first one is using all the leters provided to form a word.
The second one is choosing some letters provided to form a word.
The third one is trying to form more words using the letters provided.
What's more, there are some special puzzles, like sudoku, 24 points card game and so on.
In all the puzzles, timer is used to limit the time and increase the difficulty, player have to solve the puzzle in 5 minutes or the game is over.
Three or four control buttons are provided in each puzzle, player can use them to return to the previous scene, skip this level, clear the input or get some hints.
There is a bomb picture in some levels, player can use it to let the disturbing letters disappear, thus reducing the difficulty.
The answer entered by the user will show on the acreen and be automatically detected in real time. If it is correct, a message will appear and the character will get the item. It it's wrong, a message will appear and the input will be cleared.
The correct answer of each puzzle is related with the storyboard.
