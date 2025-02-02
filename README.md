---

# ToDoList Application

This repository contains my **ToDoList Application** project, developed as part of my Android development training. This project served as a continuous learning experience, evolving session by session as I integrated key Android concepts using Kotlin. The application allows users to manage a list of tasks by adding tasks with different priority levels and displaying them dynamically.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies and Tools](#technologies-and-tools)
- [Development Process](#development-process)
- [Installation and Execution](#installation-and-execution)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

As part of my studies, I built this application to put into practice various Android development concepts. Starting with creating a simple user interface in Android Studio, I gradually enhanced the application by incorporating:

- Graphical user interfaces using XML
- Lists with ListView and later RecyclerView along with custom Adapters
- Android Activity lifecycle management
- Data persistence using SQLite
- User preferences management using SharedPreferences

Each phase of development allowed me to deepen my understanding and improve the functionality and usability of the application.

---

## Features

The ToDoList Application offers the following functionalities:

- **Task Addition:** Users can enter a task name and assign a priority (High, Medium, or Low).
- **Task Display:** Tasks are dynamically displayed in a list (initially using ListView and later transitioned to RecyclerView) that updates as tasks are added or removed.
- **Task Deletion:** Users can remove tasks by swiping on a list item.
- **Data Persistence:** All tasks are stored in an SQLite database to ensure data persistence.
- **User Preferences:** The app allows customization of display settings, such as toggling the visibility of task priority and adjusting the font size of the task list, using SharedPreferences.

---

## Technologies and Tools

The following technologies and tools were used to develop this application:

- **Language:** Kotlin (the recommended language for Android development)
- **IDE:** Android Studio (with a minimum SDK version of Android 8)
- **User Interface:**
  - XML layout files (e.g., LinearLayout, ConstraintLayout)
  - Standard Android widgets (TextView, EditText, RadioButton, Toast, etc.)
- **List Implementation:**
  - Initially implemented with ListView and a custom Adapter
  - Later enhanced using RecyclerView for better view recycling and performance
- **Database:** SQLite (with a defined contract and methods for insertion/deletion)
- **Preferences:** SharedPreferences for storing and managing user settings

---

## Development Process

The development of this application was organized into several sessions, each focusing on a specific aspect of Android development:

1. **Getting Started with Android Studio and Creating a Simple Interface**  
   I began by creating an empty project and adding an activity. I designed the main interface (`activity_main.xml`) using basic widgets and implemented Toasts and logging for debugging purposes.

2. **Using ListView, RecyclerView, and Adapters**  
   To improve the task display functionality, I first used a ListView with a custom Adapter, then transitioned to RecyclerView. This phase involved implementing Adapters and handling user interactions like swipe-to-delete.

3. **Managing the Activity Lifecycle**  
   I redefined and logged the Activity lifecycle methods in `MainActivity` to observe state changes, especially during screen rotations. I also implemented the `Parcelable` interface to manage state persistence across configuration changes.

4. **Data Persistence with SQLite**  
   I integrated an SQLite database to store tasks, which involved setting up a database contract and methods for data manipulation. The RecyclerView was updated to reflect changes in the database.

5. **Implementing User Preferences**  
   Finally, I added a settings interface that allows users to customize the display (e.g., toggling task priority and adjusting font size) using SharedPreferences.

---

## Installation and Execution

To install and run this application on your local machine, follow these steps:

1. **Clone the Repository:**

   ```bash
   git clone <REPOSITORY_URL>
   ```

2. **Open the Project in Android Studio:**
   - Launch Android Studio and select **File > Open**, then choose the cloned project folder.

3. **Set Up an Emulator or Connect a Device:**
   - Use an Android emulator configured with SDK Android 8 (or higher) or connect a physical device.

4. **Run the Application:**
   - Click the **Run** button in Android Studio to compile and launch the app.

---

## Contributing

Although this project was created as part of my coursework, I welcome any suggestions or improvements. To contribute:

1. **Fork the Repository.**
2. **Create a New Branch** for your feature or fix:

   ```bash
   git checkout -b feature/my-new-feature
   ```

3. **Commit Your Changes:**

   ```bash
   git commit -m "Add [feature/fix]: brief description"
   ```

4. **Push the Branch to Your Fork:**

   ```bash
   git push origin feature/my-new-feature
   ```

5. **Open a Pull Request** on the main repository.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

*This project reflects my progressive learning in Android development and my exploration of various aspects of mobile application creation. Please feel free to contact me with any questions or suggestions.*

---
