# Task CLI Manager

A command-line interface (CLI) application built in Java for managing daily tasks.

## Application Commands

The application utilizes a continuous loop. Run `help` in the terminal at any time to view the built-in manual:

| Command | Syntax Example | Description |
| :--- | :--- | :--- |
| **`ADD`** | `add Clean my room` | Creates a new task with an auto-incremented ID. |
| **`LIST`** | `list` | Displays all tasks currently tracked in the database. |
| **`UPDATE`** | `update 1 DOING` | Updates a task's status (`TODO`, `DOING`, `DONE`). |
| **`SEARCH`** | `search TODO` | Filters and prints tasks matching a specific status category. |
| **`REMOVE`** | `remove 1` | Permanently deletes a task by its unique numeric ID. |
| **`CLEAR`** | `clear` | Resets the repository, wiping out all currently tracked tasks. |
| **`HELP`** | `help` | Dynamically extracts and prints structural usage tips for all commands. |
| **`EXIT`** | `exit` | Closes the application. |
