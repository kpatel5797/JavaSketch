# JavaSketch

JavaSketch is an application similar to Microsoft Paint, written in Java.

The user can draw lines, circles, and rectangles by selecting the shape button, colour, and thickness of the shape and then dragging mouse on the canvas.

The shape on the canvas can be selected by choosing the select button, and then clicking on the shape to be selected on canvas. Once the shape is selected, the user can change the border thickness and border colour of the shape, and can also move it around the canvas. Clicking outside the shape or pressing the ESC key unselectes the shape.

Selecting the eraser button and clicking on the shape erases the shape.

Selecting the fill button and clicking on the shape fills it with the selected colour.

The application also has a customizable palatte aling with a fixed one, where the user can choose any colour they want from the colour chooser dialog.

File -> New clears everythign on the canvas without saving. File -> Save saves the drawn shapes in a file with a .jsketch extension.

To run the application, just enter the commands gradle build, gradle run, gradle clean on the command line.
