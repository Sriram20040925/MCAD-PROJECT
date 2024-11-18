CGPA Calculator App

This is a simple Android application for calculating the **CGPA (Cumulative Grade Point Average)** based on user-provided grades. The app allows users to input the number of subjects and their corresponding grades, and then calculates the CGPA.

## Features

1. **Dynamic Grade Input:**  
   Users can specify the number of subjects, and the app dynamically generates input fields for grades.

2. **Grade Validation:**  
   The app validates grades to ensure only valid inputs are allowed (e.g., O, A+, A, B+, etc.).

3. **User-Friendly Interface:**  
   The application provides a clean and simple UI with clear instructions for users.

4. **Accurate CGPA Calculation:**  
   The app uses a grade-to-point mapping to calculate CGPA accurately.

## Screenshots

### Main Screen
The user is prompted to enter the number of subjects.

![Main Screen](screenshot1.png)

### Grade Input
Dynamic input fields are generated based on the number of subjects.

![Grade Input](screenshot2.png)

### CGPA Result
The calculated CGPA is displayed.

![CGPA Result](screenshot3.png)

## How to Use

1. Enter the number of subjects in the provided field.
2. Click **Submit** to generate input fields for grades.
3. Enter grades for each subject (valid grades: O, A+, A, B+, B, C+, C, D, F).
4. Click **Calculate CGPA** to view the result.

## Grade to Point Mapping

| Grade | Points |
|-------|--------|
| O     | 10.0   |
| A+    | 9.0    |
| A     | 8.0    |
| B+    | 7.0    |
| B     | 6.0    |
| C+    | 5.0    |
| C     | 4.0    |
| D     | 3.0    |
| F     | 0.0    |

## Code Overview

### `MainActivity.java`

The primary activity handles:
- Dynamic creation of grade input fields based on user input.
- Grade validation and mapping.
- CGPA calculation logic.

### `activity_main.xml`

Defines the layout of the application, including:
- Input field for the number of subjects.
- A dynamically visible layout for grade input fields.
- A button for submitting grades and calculating CGPA.
- TextView to display the calculated CGPA.

## Prerequisites

- Android Studio
- Minimum SDK: 21 (Android 5.0 Lollipop)

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/cgpa-calculator.git

2. Open the project in Android Studio.


3. Build and run the application on an emulator or physical device.



Future Improvements

Add functionality to store and retrieve past CGPA calculations.

Support for weighted grades (credit hours).

Localization for multiple languages.


Author

SRIRAM. G
This project was created as a learning exercise and for assisting students in calculating CGPA.

License

This project is licensed under the MIT License - see the LICENSE file for details.
