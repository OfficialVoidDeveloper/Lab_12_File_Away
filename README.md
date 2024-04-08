# Reading And Writing Files in Java

## Main();
The main method is the entry point of the program. It prompts the user to choose between reading a file and writing to a file. Based on the user's input, it calls the WriteFile or ReadFile method accordingly.

#### Functionality

The method uses a Scanner to take user input for reading or writing a file.
It creates a JFileChooser object and sets the current directory to the user's working directory.
It loops until the user chooses either to read or write a file.
If the user chooses to write a file, it calls the WriteFile method.
If the user chooses to read a file, it calls the ReadFile method.
If the user enters an invalid input, it prompts them to try again.

#### Method Steps

- Create a Scanner object to read user input.
Create a JFileChooser object and set the current directory to the user's working directory.
Prompt the user to choose between reading or writing a file.
If the user chooses to write a file, call the WriteFile method.
If the user chooses to read a file, call the ReadFile method.
Handle invalid input by prompting the user to try again.

#### Input

- User input: 'w' for writing a file, 'r' for reading a file.

#### Example Usage
`public static void main(String[] args) {
  // Main method to interact with file reading and writing
  // Prompts user to read or write a file
  }
  `

## ReadFile();
The ReadFile method is designed to read a text file using a JFileChooser to select the file. It then analyzes the file to count the number of lines, words, and characters in the text.

#### Functionality

The method takes a JFileChooser object as a parameter.
It opens a file selection dialog for the user to choose a file to read.
Once a file is selected, it reads the contents of the file, line by line.
It counts the total number of lines, words, and characters in the file.
Finally, it displays the line-by-line contents of the file along with the total counts. 

#### Method Steps

- Open the file selection dialog using the provided JFileChooser object.
If a file is selected (APPROVE_OPTION), proceed to read the file.
Read the contents of the file line by line and store each line in an ArrayList.
Count the total number of lines, words, and characters in the file.
Display the contents of the file along with the total counts.
Handle exceptions for file not found or I/O errors.

#### Output

- Line Count: Total number of lines in the file
Word Count: Total number of words in the file
Character Count: Total number of characters in the file

#### Example Usage
`JFileChooser fileChooser = new JFileChooser();` <br>
`ReadFile(fileChooser);`

## WriteFile();
The WriteFile method allows users to write to a selected file using a JFileChooser. It prompts the user to enter text, specifically the names of Devil Fruits from the anime series "One Piece," and appends them to the existing content of the file.

#### Functionality

- The method takes a JFileChooser object as a parameter for file selection.
It opens the selected file for writing using BufferedWriter.
It reads the existing content of the file and stores it in an ArrayList.
It prompts the user to enter the names of Devil Fruits, which are then written to the file.
The user can choose to enter more Devil Fruits or finish writing.
The file is updated with the new content, including the added Devil Fruit names.

#### Method Steps

- Select a file using the provided JFileChooser.
Open the file for writing and reading using BufferedWriter and BufferedReader.
Read the existing content of the file and store it in an ArrayList.
Prompt the user to enter the names of Devil Fruits from One Piece.
Write the entered text to the file and ask if the user wants to add more.
If the user chooses to stop, save the changes to the file and close the writer.

#### Input

- User input: Devil Fruit names such as "Mera Mera no mi" from One Piece.
User input: 'y' to enter more Devil Fruits, 'n' to finish writing.

#### Example Usage
`JFileChooser fileChooser = new JFileChooser();`
<br>
`WriteFile(fileChooser);`
