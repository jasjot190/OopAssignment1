Sorting Application - ReadMe
Group Name: TeamMineru
Assignment: Assignment 1 - Complexity and Sorting
Course: Oop3
Instructor: Maryam Moussavi   

1. Introduction
This application sorts 3D geometric shapes (e.g., Cylinder, Cone, Pyramid, Prisms) based on their height, base area, or volume using six sorting algorithms:

Bubble Sort

Insertion Sort

Selection Sort

Merge Sort

Quick Sort

Heap Sort

2. Installation
Ensure you have Java 8 or later installed on your system.

Download the Sort.jar file from the submission folder.

Place the Sort.jar file in your desired directory.

3. Running the Program
To run the program, use the following command in the terminal or command prompt:

bash
Copy
java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_algorithm>
Command-Line Arguments:
-f or -F: Specifies the input file containing the shapes (e.g., shapes1.txt).

-t or -T: Specifies the compare type:

h for height

a for base area

v for volume

-s or -S: Specifies the sorting algorithm:

b for Bubble Sort

s for Selection Sort

i for Insertion Sort

m for Merge Sort

q for Quick Sort

z for Heap Sort

Examples:
Sort by volume using Bubble Sort:

bash
Copy
java -jar Sort.jar -fshapes1.txt -Tv -Sb
Sort by height using Quick Sort:

bash
Copy
java -jar Sort.jar -f"res/shapes1.txt" -th -sq
4. Input File Format
The input file should follow this format:

The first line contains the number of shapes.

Each subsequent line describes a shape:

Cylinder: Cylinder <height> <radius>

Cone: Cone <height> <radius>

Pyramid: Pyramid <height> <edge_length>

Prisms: <PrismType> <height> <edge_length>
(e.g., SquarePrism 8945.234 3745.334)

5. Output
The program will:

Print the time taken to sort the shapes (in milliseconds).

Display the first, last, and every thousandth sorted shape.

6. Troubleshooting
Invalid Command-Line Arguments: Ensure the arguments are in the correct format (e.g., -fshapes1.txt, not -f shapes1.txt).

File Not Found: Ensure the file path is correct and the file exists.

7. Contact
For questions or issues, contact:
Jasjot Singh
jasjot.singh@edu.sait.ca

