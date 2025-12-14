Students and Universities (CSC 222)

How to run (from the project folder):

1) Compile:
   javac -d bin src/*.java

2) Run with included sample input files:
   java -cp bin Main

Input files are in:
  data/StudentFile.txt
  data/Universities9.txt

Outputs will be created in:
  output/
    StudentsOutput.csv
    UniversitiesOutput.csv
    UniversityReports.txt
    UnmatchedStudents.csv
    Students.dat
    Universities.dat

Notes:
- Sorting uses BubbleSort with Comparable (per the provided handout).
- Duplicates are removed after sorting.
- Students whose university name is not found in the university file are written to UnmatchedStudents.csv.
