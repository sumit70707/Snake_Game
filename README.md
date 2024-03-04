# Snake Game in Java

This is a simple Snake Game implemented in Java using object-oriented programming concepts and Java Swing for the graphical user interface.

## Project Details

- The Snake has the ability to move in all four directions.
- The snake's length grows as it eats food. When the snake crosses itself or strikes the perimeter of the box, the game is over.
- Food is always given at different positions.

## How to Run

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE or code editor.
3. Compile and run the `Game.java` file.

## Implementation

The project is organized into the following classes:

- `Snake`: Represents the snake in the game. It includes properties such as length, direction, and body segments. Methods are implemented to move the snake, check for collisions, and grow the snake when it eats food.
- `Food`: Represents the food in the game. Methods are implemented to generate random positions for food and check if food is eaten.
- `SnakeGame`: Main class that contains the game logic. It handles user input, updates the positions of the snake and food, checks for collisions, and displays the game using Java Swing.

## Features

- Arrow keys can be used to control the direction of the snake.
- The game displays the current score based on the length of the snake and the number of food items eaten.
- When the game ends, a game over message is displayed, and the player can choose to restart the game if desired.

## Contributions

Contributions to this project are welcome! Feel free to fork the repository and submit pull requests with any improvements or new features.

